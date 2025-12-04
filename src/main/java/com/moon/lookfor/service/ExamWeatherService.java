package com.moon.lookfor.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


public interface ExamWeatherService {

     String getWeatherForecastByLocation(double latitude, double longitude);

     String getAlerts(String state) throws Exception;
}
