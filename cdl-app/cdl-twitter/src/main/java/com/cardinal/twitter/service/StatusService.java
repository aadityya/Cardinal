package com.cardinal.twitter.service;

import com.cardinal.twitter.config.TwitterConfiguration;
import com.cdl.common.vo.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusService {

    @Autowired
    TwitterConfiguration config;

    public Tweet postTweet(Tweet tweet) {

        Tweet responseTweet = null;
        Twitter twitter = config.getTwitterHandle();

        try {
            Status status = twitter.updateStatus(tweet.getMessage());
            responseTweet = new Tweet();
            responseTweet.setMessage(status.getText());
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return responseTweet;
    }

    public Tweet deleteTweet(Tweet tweet) {

        Twitter twitter = config.getTwitterHandle();
        Tweet responseTweet = null;
        Status statusToDelete = null;

        try {
            List<Status> statuses = twitter.getUserTimeline().stream().filter(status ->
                    tweet.getMessage().equals(status.getText())).collect(Collectors.toList());
            statusToDelete = statuses.get(0);

            twitter.destroyStatus(statusToDelete.getId());
            responseTweet = new Tweet();
            responseTweet.setMessage(statusToDelete.getText());

        } catch (TwitterException e) {
                e.printStackTrace();
        }

        return responseTweet;
    }

    public Tweet updateTweet(Tweet tweet) {

        Twitter twitter = config.getTwitterHandle();
        Tweet responseTweet = null;
        Status statusToUpdate = null;

        try {
            List<Status> statuses = twitter.getUserTimeline().stream().filter(status ->
                    tweet.getMessage().equals(status.getText())).collect(Collectors.toList());

            statusToUpdate = statuses.get(0);

            twitter.updateStatus(tweet.getMessage() + " - Updated");
            responseTweet = new Tweet();
            responseTweet.setMessage(statusToUpdate.getText());

        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return responseTweet;
    }
}
