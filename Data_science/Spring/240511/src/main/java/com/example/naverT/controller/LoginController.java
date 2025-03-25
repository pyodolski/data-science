package com.example.naverT.controller;

import com.example.naverT.dto.naver.login.LoginParamsDto;
import com.example.naverT.service.naver.login.OAuthLoginService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/oauth")
@Controller
public class LoginController {

    private final OAuthLoginService oAuthLoginService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    // html단에서 naver login 버튼 선택시 적용되는 URI
    @GetMapping("/naver/login")
    public void naverLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(oAuthLoginService.naverAuthUrl());
    }

    // naver redirect url
    @ResponseBody
    @GetMapping(path = "/naver")
    public ResponseEntity callbackNaver(LoginParamsDto loginParamsDto) {
        log.info("code={}, state={}", loginParamsDto.getCode(), loginParamsDto.getState());
        var token = oAuthLoginService.requestAccessToken(loginParamsDto);
        return ResponseEntity.ok(oAuthLoginService.findMe(token));

        //return ResponseEntity.ok("test");
    }
}
