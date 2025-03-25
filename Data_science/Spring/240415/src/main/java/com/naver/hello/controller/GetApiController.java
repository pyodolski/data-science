package com.naver.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//URI 지정 annotaion
// http://localhost:8081/apis
@RequestMapping(path = "/apis")
@RestController // rest 전용 controller
public class GetApiController {
    // GET http://localhost:8081/apis/hello
    @GetMapping(path = "/hello")
    public String hello() {
        return "hello spring boot";
    }

}
