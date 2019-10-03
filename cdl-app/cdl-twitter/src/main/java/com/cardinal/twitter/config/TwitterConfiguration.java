package com.cardinal.twitter.config;

import com.cardinal.twitter.service.PropertyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


@Component
public class TwitterConfiguration {

    @Autowired
    PropertyClient propertyClient;

    private static Twitter twitter;


    private void init() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(propertyClient.getConsumerKey())
                .setOAuthConsumerSecret(propertyClient.getConsumerSecret())
                .setOAuthAccessToken(propertyClient.getAccessToken())
                .setOAuthAccessTokenSecret(propertyClient.getAccessTokenSecret());

        twitter = new TwitterFactory(cb.build()).getInstance();
    }

    public Twitter getTwitterHandle() {

       if(null == twitter) {
           init();
       }

        return twitter;
    }
}
