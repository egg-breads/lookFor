package com.moon.lookfor.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Configuration
public class CommonConfig {

    @Value("${gov.share.api.host}")
    private String govShareApiHost;

    @Value("${gov.share.api.key}")
    private String govShareApiKey;
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

    public static String UriPathBuild(String defaultUri, String... paths) {
        return Arrays.stream(paths).reduce(defaultUri, (a,b) -> a + "/" + b);
    }

    public static Map<String, Object> requestBodyBuild() {

    }

}
