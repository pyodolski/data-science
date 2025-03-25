package com.example.junit.component;

import org.springframework.stereotype.Component;

@Component
public class ExchangeHandler {
    public int dollarPrice(){
        return 100;
    }

    public int yenPrice(){
        return 200;
    }
}
