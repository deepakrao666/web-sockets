package com.deepak.websockets.client;

import com.deepak.websockets.config.AppConfig;
import com.twitter.clientlib.ApiClient;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.Configuration;
import com.twitter.clientlib.auth.*;
import com.twitter.clientlib.model.*;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.api.TwitterApi;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class TwitterClient {


    @Autowired
    RestClient restClient;
    @Autowired
    AppConfig appConfig;

    public JSONObject getRules() {
        return restClient.getForEntity(appConfig.ruleUrl, JSONObject.class).getBody();
    }


//    public void something(){
//
//
//        // Instantiate library client
//        TwitterApi apiInstance = new TwitterApi();
//
//        // Instantiate auth credentials (App-only example)
//        TwitterCredentialsBearer credentials = new TwitterCredentialsBearer(System.getenv("APP-ONLY-ACCESS-TOKEN"));
//
//        // Pass credentials to library client
//        apiInstance.setTwitterCredentials(credentials);
//
//        String id = "1511757922354663425"; // String | A single Tweet ID.
//        Set<String> expansions = new HashSet<>(Arrays.asList("author_id")); // Set<String> | A comma separated list of fields to expand.
//        Set<String> tweetFields = new HashSet<>(Arrays.asList("created_at", "lang", "context_annotations")); // Set<String> | A comma separated list of Tweet fields to display.
//        Set<String> userFields = new HashSet<>(Arrays.asList("created_at", "description", "name")); // Set<String> | A comma separated list of User fields to display.
//
//        try {
//            SingleTweetLookupResponse result = apiInstance.tweets().findTweetById(id, expansions, tweetFields, userFields, null, null, null);
//            System.out.println(result);
//        } catch (ApiException e) {
//            System.err.println("Exception when calling TweetsApi#findTweetById");
//            System.err.println("Status code: " + e.getCode());
//            System.err.println("Reason: " + e.getResponseBody());
//            System.err.println("Response headers: " + e.getResponseHeaders());
//            e.printStackTrace();
//        }
//
//    }
}
