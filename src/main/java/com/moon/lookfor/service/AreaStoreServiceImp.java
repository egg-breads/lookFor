package com.moon.lookfor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AreaStoreServiceImp {

    @Value("${public-key}")
    private String serviceKey;
    /**
     * serviceKey
     * -
     * 공공데이터포털에서 받은 인증키
     * page
     * 1
     * 페이지번호
     * perPage
     * 10
     * 한 페이지 결과 수
     * cond[frcs_nm::EQ]
     * 하쏘헤어
     * 검색값과 가맹점명이 일치하는 데이터를 검색
     * cond[usage_rgn_cd::EQ]
     * 42130
     * 검색값과 사용처지역코드가 일치하는 데이터를 검색
     * cond[ksic_cd::EQ]
     * 960
     * 검색값과 표준산업분류코드가 일치하는 데이터를 검색
     * cond[pvsn_inst_cd::EQ]
     * I0000004
     * 검색값과 제공기관코드가 일치하는 데이터를 검색
     * cond[crtr_ymd::EQ]
     * 20221229
     * 검색값과 기준일자가 일치하는 데이터를 검색
     * cond[brno::EQ]
     * 123
     * 검색값과 사업자번호가 일치하는 데이터를 검색
     * cond[emd_cd::EQ]
     * 123
     * 읍면동코드(법정동코드중 앞8자리)
     * returnType
     * JSON
     * 응답 데이터 포맷설정(JSON 또는 XML, default:"JSON")
     */

    @Tool(description = "지역 및 업체명으로 검색")
    public void findStoreInProvince(String storeName, String province) {

    }

    @Tool(description = "현재위치 및 업체명으로 검색")
    public void findStoreByLatLng(double latitude, double longitude, String province) {

    }
}
