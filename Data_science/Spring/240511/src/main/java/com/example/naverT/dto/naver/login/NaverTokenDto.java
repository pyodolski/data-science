package com.example.naverT.dto.naver.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NaverTokenDto {

    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "expires_in")
    private int expiresIn;

}
