package com.moon.lookfor.dto;

public record RequestBodyRecord(
        String key,   // ⭐️ 여기에 적어야 합니다!
        Object value
) {
    // 중괄호 안은 비워두거나, 검증 로직만 넣습니다.
}