package com.cardinal.twitter.service;

import com.cardinal.twitter.config.TwitterConfiguration;
import com.cdl.common.vo.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimelineService {

    @Autowired
    TwitterConfiguration config;

    public List<Tweet> getTimeLineByUser(String userName) {

        List<Tweet> tweets = new ArrayList<>();
        Twitter twitter = config.getTwitterHandle();

        try {
            twitter.getUserTimeline(userName).stream().forEach(status -> {
                Tweet tweet = new Tweet();
                tweet.setMessage(status.getText());
                tweets.add(tweet);
            });
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return tweets;
    }


}
