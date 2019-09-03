package com.cardinal.configclient;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/")
@RestController
public class TwitterPropertyController {

    @Autowired
    @Lazy
    EurekaClient eurekaClient;

    @Value("${oauth.consumerKey: Default}")
    private String consumerKey;

    @Value("${oauth.consumerSecret: Default}")
    private String consumerSecret;

    @Value("${oauth.accessToken: Default}")
    private String accessToken;

    @Value("${oauth.accessTokenSecret: Default}")
    private String accessTokenSecret;


    @GetMapping("/consumerKey")
    public String getConsumerKey() {
        return consumerKey ;
    }

    @GetMapping("/consumerSecret")
    public String getConsumerSecret() {
        return consumerSecret;
    }

    @GetMapping("/accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    @GetMapping("/accessTokenSecret")
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }
}
