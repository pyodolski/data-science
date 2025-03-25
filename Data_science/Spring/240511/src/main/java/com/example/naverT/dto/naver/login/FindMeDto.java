package com.example.naverT.dto.naver.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindMeDto {
    private String resultcode;
    private String message;

    private Response response;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Response {
        private String nickname;
        private String email;
    }
}
