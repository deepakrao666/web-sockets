package com.deepak.websockets.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${TWITTER_API_BEARER_TOKEN}")
    public String bearerToken;

    @Value("${RULES_URL}")
    public String ruleUrl;

    @Value("${STREAM_URL}")
    public String streamUrl;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
