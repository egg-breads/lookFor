package com.moon.lookfor.controller;

import com.moon.lookfor.service.ParkingZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;

@RestController("/")
@RequiredArgsConstructor
public class ExamWeatherController {

    private final ParkingZoneService parkingZoneService;
//    private final RouterFunction<ServerResponse> mcpRouterFunction;

    @GetMapping("loc")
    public String getLoc(ServerRequest request) {

//      return examWeatherService.getWeatherForecastByLocation(47.6062, -122.3321);
//        return String.valueOf(mcpRouter.route(request)
//                .orElseThrow(() -> new RuntimeException("MCP 라우팅 실패")));
        return "ok";
    }

    @GetMapping("parking")
    public Map getParking() {
        Map result = parkingZoneService.findParkingZoneByCityName("테스트");
        return result;

    }

}
