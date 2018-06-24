package com.smartexplorer.proxy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @Author
 * Karol Meksuła
 * 24-06-2018
 * */

@Configuration
public class BeansConfig {

    @Value("${core.api.key}")
    private String apiKey;

    @Bean("restConfigured")
    public RestTemplate restConfigured() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(apiKey, apiKey));
        return restTemplate;
    }

}
