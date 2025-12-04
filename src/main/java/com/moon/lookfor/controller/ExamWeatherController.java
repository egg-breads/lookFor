package com.moon.lookfor.controller;

import com.moon.lookfor.service.ExamWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Controller("/")
@RequiredArgsConstructor
public class ExamWeatherController {


//    private final RouterFunction<ServerResponse> mcpRouterFunction;

    @GetMapping("loc")
    public String getLoc(ServerRequest request) {

//      return examWeatherService.getWeatherForecastByLocation(47.6062, -122.3321);
//        return String.valueOf(mcpRouter.route(request)
//                .orElseThrow(() -> new RuntimeException("MCP 라우팅 실패")));
        return "ok";
    }

//    @GetMapping("/area")
//    public String getArea() {
//
//        return examWeatherService.getAlerts("NY");
//
//    }

}
