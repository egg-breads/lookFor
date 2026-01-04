package com.moon.lookfor.service;

import com.moon.lookfor.common.CommonUtils;
import com.moon.lookfor.dto.RequestBodyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ParkingZoneServiceImp implements ParkingZoneService{

    @Value("${gov.share.api.key}")
    private String govShareApiKey;

    private final RestClient restClient;

    @Override
    @Tool(description = "지역명으로 무료주차장 검색")
    public Map findParkingZoneByCityName(String cityName) {
        String serviceKey = "f1b4c71d4f773ba6bff8e6079e0f956b";
//        String fullUrl = "https://www.eshare.go.kr/eshare-openapi/rsrc/list/010700/" + serviceKey;
        // 1. [변경] MultiValueMap(폼/URL용) 대신 일반 HashMap(JSON용) 사용
        // JSON Body: {"numOfRows": "100", "pageNo": "1", ...}
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("numOfRows", "100");
//        requestBody.put("pageNo", "1");
//        // 원래 주석 처리하셨던 날짜 필드 필요하면 주석 해제
//        // requestBody.put("updBgngYmd", "20251222");
//        // requestBody.put("updEndYmd", "20251231");
//
//        requestBody.put("ctpvCd", "41");
//        requestBody.put("sggCd", "360");

        String uri = CommonUtils.UriPathBuild("","eshare-openapi","rsrc","list","010700",govShareApiKey);

        Map<String, Object> requestBody = CommonUtils.requestBodyBuild(
                new RequestBodyRecord("numOfRows", "100"),
                new RequestBodyRecord("pageNo", "1"),
                new RequestBodyRecord("updBgngYmd", "20250101"),
                new RequestBodyRecord("updEndYmd", "20251231")
        );
        // 2. [변경] method(HttpMethod.GET)을 사용하여 강제로 Body 전송 기능 활성화
        return restClient.method(HttpMethod.GET)
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON) // ⭐️ [중요] 나 JSON 보낸다! 라고 명시
                .body(requestBody) // ⭐️ [중요] queryParams가 아니라 body에 넣음
                .retrieve()
                .body(Map.class);

    }
//    public Map findParkingZoneByCityName(String cityName) {
//        String serviceKey = "f1b4c71d4f773ba6bff8e6079e0f956b";
//
//        /**
//         *     "numOfRows": 100,
//         *     "pageNo": 1,
//         *     // "updBgngYmd": "20251222",
//         *     // "updEndYmd": "20251231",
//         *     "ctpvCd":"41",
//         *     "sggCd":"360"
//         */
//        // 1. MultiValueMap 생성 (값은 무조건 String이어야 함)
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("numOfRows", "100"); // String 변환 필요
//        params.add("pageNo", "1");
//        params.add("ctpvCd", "41");
//        params.add("sggCd", "360");
//
//        RestClient.RequestHeadersSpec<?> req = restClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/list/010700/"+ serviceKey)
//                        .queryParams(params) // ⭐️ 한 번에 주입 가능
//                        .build());
//
//        Map result = req.retrieve().body(Map.class);
//        return result;
//    }
}
