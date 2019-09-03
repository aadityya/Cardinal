package com.cardinal.twitter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="cdl-config-client")
public interface PropertyClient {

    @RequestMapping(value = "/consumerKey", method = RequestMethod.GET)
    public String getConsumerKey();

    @RequestMapping(value = "/consumerSecret", method = RequestMethod.GET)
    public String getConsumerSecret();

    @RequestMapping(value = "/accessToken", method = RequestMethod.GET)
    public String getAccessToken();

    @RequestMapping(value = "/accessTokenSecret", method = RequestMethod.GET)
    public String getAccessTokenSecret();
}
