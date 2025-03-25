package com.example.junit.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DollarCalcTest {

    @MockBean
    private ExchangeHandler handler;  // 가상의 컴포넌트 느낌

    @Autowired // DollarCalc도 컴포넌트니까 컴포넌트는 Autowired를 이용해 빈으로 주입
    private DollarCalc dollarCalc;

    @Test
    void dollarTest(){
        Mockito.when(handler.dollarPrice()).thenReturn(100);  // 100으로 리턴을 해달라.

        // 내로직
        dollarCalc.init();
        int sum = dollarCalc.sum(10,10);

        // 내로직이 맞는지 결과값 비교
        Assertions.assertEquals(2200, sum);
    }
}