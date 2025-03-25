package com.example.junit.component;

public interface ICalculator {
    int sum(int x, int y);
    int minus(int x, int y);

    void init();  // 환율 서버로부터 환율값 받아오기 위한 초기화 루틴
}

