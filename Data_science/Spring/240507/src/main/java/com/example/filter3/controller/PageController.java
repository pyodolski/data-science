package com.example.filter3.controller;

import com.example.filter3.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@RequestMapping(path = "/page")
@Controller
public class PageController {
    @PostMapping(path = "/login")
    public String login(HttpServletRequest httpServletRequest) {
        UserDto userDto = (UserDto) httpServletRequest.getAttribute("requestBody");
        log.info("page controller userinfo = {}", userDto);
        return "/page/login";

    }
    @GetMapping(path = "/login")
    public String

}
