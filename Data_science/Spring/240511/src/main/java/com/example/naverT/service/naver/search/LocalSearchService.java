package com.example.naverT.service.naver.search;

import com.example.naverT.dto.ResDto;
import com.example.naverT.dto.naver.search.NaverReqDto;
import com.example.naverT.dto.naver.search.NaverResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocalSearchService {

    @Value("${naver.uri.search.local}")
    private String uri;
    @Value("${naver.id}")
    private String id;
    @Value("${naver.secret}")
    private String secret;

    private final RestTemplate restTemplate;

    public ResDto process(NaverReqDto reqDto) {
        var makeUri = UriComponentsBuilder.fromUriString(uri)
                .queryParams(reqDto.localParamsMap())
                .encode()
                .build()
                .toUri();

        //log.info("local search uri= {}", makeUri);

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", id);
        headers.add("X-Naver-Client-Secret", secret);

        var reqEntity = RequestEntity.get(makeUri)
                                .headers(headers).build();
        var resEntity = restTemplate.exchange(reqEntity, NaverResDto.class);

        //log.info("naver res data = {}", resEntity);

        int length = Integer.parseInt(resEntity.getHeaders().get("Content-Length").get(0));
        var msg = "RES_OK";
        if (length <= 0) msg = "RES_FAIL";

        return ResDto.<NaverResDto>builder()
                .header(
                    ResDto.Header.builder()
                            .code(resEntity.getStatusCode().toString())
                            .msg(msg).build()
                )
                .data(resEntity.getBody()).build();
    }
}
