package com.example.naverT.service.naver;

import com.example.naverT.dto.naver.search.NaverReqDto;
import com.example.naverT.service.naver.search.LocalSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocalSearchServiceTest {

    @Autowired
    LocalSearchService localSearchService;

    @Test
    void process() {
        System.out.println(localSearchService.process(NaverReqDto.builder().query("국수").build()));
    }
}