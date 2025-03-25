package com.example.filter3.controller;

import com.example.filter3.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis")
@Slf4j  // lombok의 logging 시스템
public class UserController {

    // 1. name, age, pw를 받는 post method
    @PostMapping(path = "/post/user")
    public UserDto postUser(@RequestBody UserDto userDto){
        log.info("post={}", userDto);
        return userDto;
    }

    // 2. name, age, pw를 받는 query parameter를 받는 get method
    @GetMapping(path = "/get/user")
    public UserDto getUser(@RequestParam(name = "name")String name,
                           @RequestParam(name = "age")Integer age,
                           @RequestParam(name = "pw")String pw,
                           HttpServletRequest httpServletRequest){
        log.info("get params: name={}, age={}, pw={}, custom={}",name,age,pw, httpServletRequest.getAttribute("updateParam"));
        return UserDto.builder()
                .age(age).
                name(name).
                pw(pw).
                build();
    }

    @GetMapping(path = "/get/one")
    public void getOne(HttpServletRequest request){
        log.info("get in ...");
        String filterSTr = (String) request.getAttribute("updateParam");
        log.info(filterSTr);
    }
    @PostMapping(path = "/cpost")
    public UserDto post(HttpServletRequest httpServletRequest) {
        log.info("post={}", (UserDto)httpServletRequest.getAttribute("requestBody"));
        return (UserDto) httpServletRequest.getAttribute("requestBody");
    }


}
