package com.example.sever.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GenericDto<T> {  // 강사님은 T 를 사용하셨더라..

    private Header header;
    private T data;  // 타입 미정


    @Builder
    @AllArgsConstructor
    @lombok.Data
    @NoArgsConstructor
    public static class Header{
        @JsonProperty(value = "res_type")
        private String resType;
        private String msg;
    }
}
