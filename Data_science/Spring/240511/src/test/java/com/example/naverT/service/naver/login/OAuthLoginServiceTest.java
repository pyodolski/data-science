package com.example.naverT.service.naver.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OAuthLoginServiceTest {

    @Autowired
    OAuthLoginService oAuthLoginService;

    @Test
    void naverAuthUrl() {
        System.out.println(oAuthLoginService.naverAuthUrl());
    }
}