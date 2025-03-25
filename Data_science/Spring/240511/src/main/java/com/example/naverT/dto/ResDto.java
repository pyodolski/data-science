package com.example.naverT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResDto<T> {
    private Header header;
    private T data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Header {
        private String code;
        private String msg;
    }
}
