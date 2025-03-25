package com.example.sever.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class CarServerDto{
    private String name;
    private int age;
    @Builder.Default  // new ArrayList<>() 로 새로 생성하기 때문에 빌더에서 못 찾을 수 있다.
    private List<Car> cars =new ArrayList<>();

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Car{
        private String name;
        @JsonProperty(value = "car_num")
        private String carNum;
        private String brand;

    }
}
