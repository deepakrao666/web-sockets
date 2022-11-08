package com.deepak.websockets.controller;

import com.deepak.websockets.client.TwitterClient;
import com.deepak.websockets.dto.Greeting;
import com.deepak.websockets.dto.HelloMessage;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@Slf4j
public class GreetingController {

    @Autowired
    TwitterClient twitterClient;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws Exception {
        Thread.sleep(200); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }

    @MessageMapping("/tweet")
    @SendTo("/topic/tweet-read")
    public JSONObject tweetRead() {
        final JSONObject rules = twitterClient.getRules();
        log.info("rules :{}", rules);
        return rules;
    }

}
