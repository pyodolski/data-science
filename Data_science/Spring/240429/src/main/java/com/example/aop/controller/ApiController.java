package com.example.aop.controller;

import com.example.aop.dto.UserInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api")
@RestController
public class ApiController {
    /*
    *
    * 1. GET /api/user/{id}?name=kim
      2. POST /api/user
	    body =
	    {
		    "id":"max123"
		    "pw":"1234"
		    "email":"max@gmail.com"
		}
    **/
    // http://localhost:8083/api/user/max?name=pyo
    @GetMapping(path ="/user/{id}")
    public String userInfo(@PathVariable(name = "id") String userId,
                           @RequestParam(name = "name") String username) {
        return userId + ":" + username;

    }

    // http://localhost:8083/api/user
    @PostMapping("/user")
    public ResponseEntity<UserInfoDto> userInfo(@RequestBody UserInfoDto userInfoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);
    }
}
