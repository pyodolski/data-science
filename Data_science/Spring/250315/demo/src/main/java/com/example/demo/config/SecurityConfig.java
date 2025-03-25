package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🔥 모든 페이지 접근 허용 (보안 임시 해제)
                )
                .csrf(csrf -> csrf.disable()) // 🔥 CSRF 비활성화
                .formLogin(login -> login.disable()) // 🔥 기본 로그인 비활성화
                .logout(logout -> logout.disable()); // 🔥 로그아웃 비활성화

        return http.build();
    }
}
