package com.moon.lookfor.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moon.lookfor.entity.Alert;
import com.moon.lookfor.entity.Forecast;
import com.moon.lookfor.entity.Points;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamWeatherServiceImp implements ExamWeatherService{
    private final RestClient restClient;

    @Tool(description = "Get weather forecast for a specific latitude/longitude")
    public String getWeatherForecastByLocation(double latitude, double longitude) {

        var points = restClient.get()
                .uri("/points/{latitude},{longitude}", latitude, longitude)
                .retrieve()
                .body(Points.class);

        var forecast = restClient.get().uri(points.properties().forecast()).retrieve().body(Forecast.class);

        String forecastText = forecast.properties().periods().stream().map(p -> String.format("""
                %s:
                Temperature: %s %s
                Wind: %s %s
                Forecast: %s
                """, p.name(), p.temperature(), p.temperatureUnit(), p.windSpeed(), p.windDirection(),
                p.detailedForecast())).collect(Collectors.joining());

        return forecastText;
    }

    // Async API 예제이므로, 결과도 비동기적으로(CompletableFuture) 반환하는 시나리오입니다.
    public String getAlerts(String state) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            // 실제 외부 API 호출 로직 (RestClient 등)
            // 여기서는 예시 리턴
            return "Weather Alert for " + state + ": Heavy Rain Expected.";
        }).get();
    }

//    @Tool(description = "Get weather alerts for a US state. Input is Two-letter US state code (e.g. CA, NY)")
//    public String getAlerts(
//            @ToolParam( description = "Two-letter US state code (e.g. CA, NY")
//            String state) {
//        Alert alert = restClient.get().uri("/alerts/active/area/{state}", state).retrieve().body(Alert.class);
//
//        assert alert != null;
//
//        return alert.features()
//                .stream()
//                .map(f -> String.format("""
//					Event: %s
//					Area: %s
//					Severity: %s
//					Description: %s
//					Instructions: %s
//					""", f.properties().event(), f.properties().areaDesc(), f.properties().severity(),
//                        f.properties().description(), f.properties().instruction()))
//                .collect(Collectors.joining("\n"));
//    }
}
