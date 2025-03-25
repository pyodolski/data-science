package com.example.junit.controller;

import com.example.junit.component.DollarCalc;
import com.example.junit.component.ExchangeHandler;
import com.example.junit.component.YenCalc;
import com.example.junit.dto.ExchangeDto;
import com.example.junit.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final YenCalc yenCalc;
    private final DollarCalc dollarCalc;

    @GetMapping(path = "/get/yen/sum")
    public int getYenSum(@RequestParam (name = "x") int x,
                         @RequestParam (name = "y") int y){
        yenCalc.init();
        return yenCalc.sum(x,y);
    }
    @PostMapping(path = "/post/dollar/minus")
    public ResponseDto postDollarMinus(@RequestBody ExchangeDto exchangeDto){

        dollarCalc.init();
        return ResponseDto.builder().result(dollarCalc.minus(exchangeDto.getX(),exchangeDto.getY()))
                .response(ResponseDto.Response.builder()
                        .resultCode(String.valueOf(HttpStatus.OK)).build()).build();
    }

}
