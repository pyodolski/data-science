package com.example.junit.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor // 생성자 주입을 자동으로 해주는 어노테이션
@Component
public class YenCalc implements ICalculator{

    private final ExchangeHandler exchangeHandler;  // @RequiredArgsConstructor 어노테이션 필요.
    private int priceFromServer;

    @Override
    public int sum(int x, int y) {
        return (x*priceFromServer+y*priceFromServer);
    }

    @Override
    public int minus(int x, int y) {
        return x*priceFromServer-y*priceFromServer;
    }

    @Override
    public void init() {  // 실제 서버에 접근해서 환율을 가져오는 애
        priceFromServer = exchangeHandler.yenPrice();

    }
}
