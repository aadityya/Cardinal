package com.cardinal.twitter.controller;

import com.cardinal.twitter.service.TimelineService;
import com.cdl.common.vo.TimelineResponseVO;
import com.cdl.common.vo.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/{userid}")
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @GetMapping(value = "/timeline")
    private TimelineResponseVO getTimeline(@PathVariable String userid) {
        List<Tweet> tweets = timelineService.getTimeLineByUser(userid);

        TimelineResponseVO responseVO = new TimelineResponseVO();

        responseVO.setTweets(tweets);

        return responseVO;
    }
}
