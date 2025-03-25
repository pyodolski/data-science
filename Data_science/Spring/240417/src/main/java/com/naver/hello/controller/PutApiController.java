package com.naver.hello.controller;


import com.naver.hello.dto.Dto1;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/apis")
@RestController

public class PutApiController {
    @PutMapping(path = "/put")
        public Dto1 putMothod(@RequestBody Dto1 dto1) {
        return dto1;
    }


    @PutMapping(path = "/put/{user}/{id}")
    public Dto1 putMothod1(@PathVariable(name = "user") String userName,
            @PathVariable(name = "id") String userID,
            @RequestBody Dto1 dto1) {
        System.out.println(userName + " is " + userID);

        return dto1;
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteMethod(@PathVariable(name = "id") Long idx) {
        System.out.println("delete");
    }
}
