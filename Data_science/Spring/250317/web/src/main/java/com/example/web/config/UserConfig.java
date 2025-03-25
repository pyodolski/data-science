package com.example.web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // 🔹 모든 요청을 인증 없이 허용
                )
                .csrf(csrf -> csrf.disable())  // 🔹 CSRF 비활성화 (개발 단계에서만 추천)
                .formLogin(form -> form.disable())  // 🔹 기본 로그인 페이지 제거
                .logout(logout -> logout.disable());  // 🔹 로그아웃 기능 제거

        return http.build();
    }
}
