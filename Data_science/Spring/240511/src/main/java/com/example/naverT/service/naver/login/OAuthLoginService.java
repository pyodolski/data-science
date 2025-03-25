package com.example.naverT.service.naver.login;

import com.example.naverT.dto.naver.login.FindMeDto;
import com.example.naverT.dto.naver.login.LoginParamsDto;
import com.example.naverT.dto.naver.login.NaverTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class OAuthLoginService {

    @Value("${naver.uri.auth}")
    private String authUrl;
    @Value("${naver.redirect-url}")
    private String redirectUrl;
    @Value("${naver.id}")
    private String clientId;
    @Value("${naver.secret}")
    private String clientSecret;

    @Value("${naver.uri.api}")
    private String openApi;

    private final RestTemplate restTemplate;

    public String naverAuthUrl() {
        return UriComponentsBuilder.fromUriString(authUrl+"/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUrl)
                .queryParam("state", "state string")
                .encode()
                .build().toUri().toString();
    }

    public String requestAccessToken(LoginParamsDto loginParamsDto) {
        var uri = UriComponentsBuilder.fromUriString(authUrl+"/token")
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("state", loginParamsDto.getState())
                .queryParam("code", loginParamsDto.getCode())
                .encode()
                .build().toUri();

        var requestEntity = RequestEntity.get(uri)
                .build();
        var res = restTemplate.exchange(requestEntity, NaverTokenDto.class);
        return res.getBody().getAccessToken();

    }

    public FindMeDto findMe(String accessToken) {
        var uri = UriComponentsBuilder.fromUriString(openApi+"/v1/nid/me")
                .encode()
                .build().toUri();

        var requestEntity = RequestEntity.get(uri)
                .header("Authorization", "Bearer "+accessToken)
                .build();
        var res = restTemplate.exchange(requestEntity, FindMeDto.class);
        return res.getBody();

    }


}
