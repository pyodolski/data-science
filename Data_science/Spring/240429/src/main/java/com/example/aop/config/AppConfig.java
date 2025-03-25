package com.example.aop.config;

import com.example.aop.aspect.LoggingAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LoggingAop loggingAop() {
        return new LoggingAop();
    }
}
