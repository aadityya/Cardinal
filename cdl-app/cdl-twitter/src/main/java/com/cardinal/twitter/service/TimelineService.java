package com.cardinal.twitter.service;

import com.cdl.common.vo.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimelineService {

    @Autowired
    PropertyClient propertyClient;

    public List<Tweet> getTimeLineByUser(String userName) {

        List<Tweet> tweets = new ArrayList<>();

        //Twitter twitter = new TwitterFactory().getInstance();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(propertyClient.getConsumerKey())
                .setOAuthConsumerSecret(propertyClient.getConsumerSecret())
                .setOAuthAccessToken(propertyClient.getAccessToken())
                .setOAuthAccessTokenSecret(propertyClient.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            ResponseList<Status> statuses = twitter.getUserTimeline(userName);

            for(Status status : statuses) {
                Tweet tweet = new Tweet();
                tweet.setMessage(status.getText());
                tweets.add(tweet);
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return tweets;
    }
}
