package com.example.junit.controller;

import com.example.junit.component.ExchangeHandler;
import com.example.junit.dto.ExchangeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class ExchangeControllerTest {

    @MockBean
    private ExchangeHandler exchangeHandler;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach  // 유닛 테스트를 실행할 때 마다 mockMvc를 실행하도록 하는 메서드
    public void init(){
        Mockito.when(exchangeHandler.dollarPrice()).thenReturn(100);
        Mockito.when(exchangeHandler.yenPrice()).thenReturn(200);
    }

    @Test
    void getYenSum() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/apis/exchange/get/yen/sum")
                        .queryParam("x", "10")
                        .queryParam("y","10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("4000"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void postDollarMinus() throws Exception {

        ExchangeDto exchangeDto = ExchangeDto.builder()
                .x(10)
                .y(10)
                .build();
        String jsonStr = new ObjectMapper().writeValueAsString(exchangeDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/apis/exchange/post/dollar/minus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.result_code").value("200 OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000))
                .andDo(MockMvcResultHandlers.print());
    }
}