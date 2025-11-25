package com.moon.lookfor.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.lookfor.service.ExamWeatherService;
import io.modelcontextprotocol.server.McpServer;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class MCPConfig {
    // ✅ [추가] 대신 사용자님은 "어떤 기능(Tool)"을 제공할지만 등록하면 됩니다.
    // 예시: 날씨 정보 조회 툴
//    @Bean
//    @Description("Get weather alerts for a US state")
//    public Function<String, String> weatherFunction() {
//        return state -> "Alerts for " + state + ": Sunny"; // 실제 로직으로 대체
//    }

    @Bean
    public ToolCallbackProvider weatherTools(ExamWeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }
}
