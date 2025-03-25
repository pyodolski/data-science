package com.naver.hello.controller;

import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import com.naver.hello.dto.PyoDto;
import com.naver.hello.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path ="/apis")
@RestController
public class PostApiController {
    // post 방식이기에 @PostMapping
    @PostMapping(path = "/post")
    public void post(@RequestBody Map<String, String> requestData) {
        //post방식은 msg body에 데이터가 넘어오므로
        //@RequestBody 어노테이션을 기억해야 합니다.
        requestData.entrySet().forEach(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });
    }

//    @PostMapping(path = "/post")
//    public UserDto postObj(@RequestBody UserDto dto) {
//        dto.getAge();
//        dto.getName();
//        return dto;
//    }


    /*
    RestController
     */
    @PostMapping(path = "/post/obj/{id}/param")
    public UserDto postObj2(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PostMapping(path = "/post/obj1/{name}")
    public PyoDto postObj3(@PathVariable(name = "name") String name,
                            @RequestBody PyoDto pyoDto) {
        pyoDto.setName(name);
        return pyoDto;
    }



}