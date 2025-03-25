package com.example.junit.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DollarCalc implements ICalculator{

    private final ExchangeHandler exchangeHandler;  // @RequiredArgsConstructor 어노테이션 필요.
    private int priceFromServer;

    @Override
    public int sum(int x, int y) {
        return x*priceFromServer+y*priceFromServer;
    }

    @Override
    public int minus(int x, int y) {
        return x*priceFromServer-y*priceFromServer;
    }

    @Override
    public void init() {  // 실제 서버에 접근해서 환율을 가져오는 애
        priceFromServer = exchangeHandler.dollarPrice();

    }
}
