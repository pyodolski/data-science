package com.example.client.controller;

import com.example.client.dto.CarDto2;
import com.example.client.dto.ReserveDto;
import com.example.client.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/client")
@RestController
@RequiredArgsConstructor
public class CarApiController {

    private final CarService carService;

    @GetMapping(path = "")
    public CarDto2 getCar(@RequestParam(name = "name")String name,
                          @RequestParam(name = "age")int age){
        return carService.getForObject(name,age);
    }

    @GetMapping(path = "/entity")
    public CarDto2 getUser(@RequestParam(name = "name")String name,
                          @RequestParam(name = "age")int age){
        return carService.getForEntity(name,age);
    }

    @GetMapping(path = "/map")
    public String handleData(@RequestParam MultiValueMap<String, String> params) {
        List<String> values = params.get("key");  // List import java.util.* - awt(x)
        return "Recived data: " + values.toString();
    }

    @GetMapping(path = "/post")
    public CarDto2 postCar(@RequestParam(name = "name")String name,
                          @RequestParam(name = "age")int age){
        return carService.postForObj(name,age);
    }

    @GetMapping(path = "/post/exchange")
    public CarDto2 postCar2(@RequestParam(name = "name")String name,
                           @RequestParam(name = "age")int age){
        return carService.exchange(name,age);
   }
    @GetMapping(path = "/post/exchange")
    public ReserveDto postGeneric(@RequestParam(name = "name")String name,
                               @RequestParam(name = "age")int age){
        return carService.exchangePost(name,age);
    }


}