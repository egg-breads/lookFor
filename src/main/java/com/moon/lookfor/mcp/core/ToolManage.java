package com.moon.lookfor.mcp.core;

import com.moon.lookfor.service.ExamWeatherService;
import com.moon.lookfor.service.ParkingZoneService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ToolManage {
    // 1. 도구 등록 (예제 방식)
    @Bean
    public ToolCallbackProvider weatherTools(ExamWeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }

    @Bean
    public ToolCallbackProvider ParkingZoneTools(ParkingZoneService parkingZoneService) {
        return MethodToolCallbackProvider.builder().toolObjects(parkingZoneService).build();
    }
}
