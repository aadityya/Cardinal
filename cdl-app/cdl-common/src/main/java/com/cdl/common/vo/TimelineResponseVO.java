package com.cdl.common.vo;

import java.util.List;

public class TimelineResponseVO {

    private List<Tweet> tweets;

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
