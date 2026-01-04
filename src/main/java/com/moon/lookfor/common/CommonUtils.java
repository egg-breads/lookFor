package com.moon.lookfor.common;

import com.moon.lookfor.dto.RequestBodyRecord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    public static String UriPathBuild(String basePath, String... paths) {
        return Arrays.stream(paths).reduce(basePath, (a, b) -> a + "/" + b);
    }

    public static Map<String, Object> requestBodyBuild(RequestBodyRecord... bodyRecords) {
        Map<String, Object> body = new HashMap<>();
        Arrays.stream(bodyRecords).forEach(bodyRecord -> {
            body.put(bodyRecord.key(), bodyRecord.value());
        });

        return body;

    }

}
