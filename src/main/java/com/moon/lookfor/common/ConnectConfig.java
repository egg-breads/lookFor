package com.moon.lookfor.common;


import com.moon.lookfor.dto.RequestBodyRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class ConnectConfig {


    @Value("${gov.share.api.host}")
    private String govShareApiHost;

//    @Bean
//    public RestClient restClient() {
//        return RestClient.builder()
//                .baseUrl("https://api.weather.gov")
//                .defaultHeader("Accept", "application/geo+json")
//                .defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
//                .build();
//    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(govShareApiHost)
                .defaultHeader("Content-Type", "application/json; charset=UTF-8")
                .build();
    }
}
