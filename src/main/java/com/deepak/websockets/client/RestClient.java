package com.deepak.websockets.client;

import com.deepak.websockets.config.AppConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AppConfig appConfig;

    public <R> ResponseEntity<R> getForEntity(String url, Class<R> responseType) {
        return restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), responseType);
    }

    public HttpEntity getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(appConfig.bearerToken);
        return new HttpEntity<>(httpHeaders);
    }
}
