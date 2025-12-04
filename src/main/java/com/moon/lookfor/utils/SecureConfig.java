package com.moon.lookfor.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecureConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // 1. CSRF 보안 비활성화 (API 서버이므로 폼 태그 보안 불필요)
//                // 이걸 안 끄면 POST 요청(도구 실행) 할 때 403 에러 납니다.
//                .csrf(AbstractHttpConfigurer::disable)
//
//                // 2. 경로별 권한 설정
//                .authorizeHttpRequests(auth -> auth
//                        // "/mcp" 로 시작하는 모든 요청은 로그인 없이 허용
//                        .requestMatchers("/mcp/**").permitAll()
//                        // 그 외 나머지 요청은 인증 필요 (나중에 로그인 기능 쓸 때 대비)
//                        .anyRequest().authenticated()
//                );

                // 3. 기본 로그인 폼 사용 (혹시 브라우저로 다른 곳 들어갈 때 필요)
//                .formLogin(form -> form.defaultSuccessUrl("/", true));
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. CSRF 끄기 (API 요청 시 403 에러 방지)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. 로그인 폼 및 Basic Auth 끄기 (HTML 응답 방지)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)

                // 3. 모든 요청 허용 (404가 뜨더라도 서버 내부까지 진입 가능하게 함)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
