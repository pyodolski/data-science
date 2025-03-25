package com.example.client.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    void uriTest(){
        // carService.getForObject("kim",19);
        // carService.getForEntity("kim", 19);
        // carService.getForObj("kim",19);
        carService.exchangePost("kim",19);
    }
}