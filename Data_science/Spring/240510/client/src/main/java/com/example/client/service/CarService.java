package com.example.client.service;

import com.example.client.dto.CarDto2;
import com.example.client.dto.GenericDto;
import com.example.client.dto.ReserveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.net.URI;

@RequiredArgsConstructor
@Slf4j
@Service
public class CarService {

    private final RestTemplate template;

    // GET Http://localhost:9090/api/server/get?name=kim&age=19
    public CarDto2 getForObject(String name, int age){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/get").
                queryParam("name",name).
                queryParam("age",age).
                encode().  // url 인코딩
                build().toUri();
        log.info("uri str={}", uri);

        var carDto=template.getForObject(uri, CarDto2.class);
        log.info("server to client return obj = {}", carDto);

        return null;
    }

    // GET Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public CarDto2 getForEntity(String name, int age){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/user/{id}/pw/{pw}").
                queryParam("name",name).
                queryParam("age",age).
                encode().  // url 인코딩
                        // pathvariable은 expand()를 활용해서 중괄호 순서대로 명기하면 된다.
                build().expand("coolmax","1234").toUri();
        log.info("uri str={}", uri);

        var resDto = template.getForEntity(uri, CarDto2.class);

        log.info("server http status={}", resDto.getStatusCode().toString());
        log.info("server header\n info1={}\n info2={}", resDto.getHeaders().get("x-auth"),resDto.getHeaders().get("time"));
        log.info("server body={}",resDto);

        return resDto.getBody();
    }

    // GET Http://localhost:9090/api/server/get?name=kim&age=19
    public CarDto2 getForObj(String name, int age){

        //MultiValueMap을 통해 QueryParam을 map으로 정의할 수 있다.
        // LinkedMultiValueMap은 MultiValueMap의 구현체로 우리는 LinkedMultiValueMap을 사용해서 적용
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        params.add("name",name);
        params.add("age",String.valueOf(age));

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/get").
                queryParams(params).
                encode()
                .build().toUri();
        log.info("uri str={}", uri.toString());

        var resDto = template.getForObject(uri, CarDto2.class);

        log.info("server to client return obj={}", resDto);
        return null;
    }

    // POST Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public CarDto2 postForObj(String name, int age){

        //MultiValueMap을 통해 QueryParam을 map으로 정의할 수 있다.
        // LinkedMultiValueMap은 MultiValueMap의 구현체로 우리는 LinkedMultiValueMap을 사용해서 적용
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        params.add("name",name);
        params.add("age",String.valueOf(age));

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/post").
                queryParams(params).
                encode()
                .build().toUri();
        log.info("uri str={}", uri.toString());

        var reserve = ReserveDto.builder().name("starbucks").price(10000).build();

        var resDto = template.postForObject(uri, reserve, CarDto2.class);
        log.info("server to client return obj={}", resDto);

        return resDto;
    }

    // POST Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public CarDto2 exchange(String name, int age){

        //MultiValueMap을 통해 QueryParam을 map으로 정의할 수 있다.
        // LinkedMultiValueMap은 MultiValueMap의 구현체로 우리는 LinkedMultiValueMap을 사용해서 적용
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        params.add("name",name);
        params.add("age",String.valueOf(age));

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/post/exchange").
                queryParams(params).
                encode()
                .build().toUri();

        log.info("uri str={}", uri.toString());  // 이까지는 동일

        var reserve = ReserveDto.builder().name("starbucks").price(10000).build();  // post 방식이라 body에 담을 내용을 dto로 만들어줌

        RequestEntity<ReserveDto> requestEntity = RequestEntity.post(uri)  // body 내용을 받을 requestEntity
                .contentType(MediaType.APPLICATION_JSON)  // json type으로 정해주기
                .header("x-auth", "daegu_univ")  // 클라이언트에서 헤더를 요구하는 일이 종종 있음(없어도 되지만)
                .body(reserve);  // body에 reserveDto 를 담는다.
                // body 만 넣어도 RequestEntity를 리턴하는 내부구조. build() 가 필요 없었다.


        var responseEntity = template.exchange(requestEntity, CarDto2.class);  // exchange가 원하는 정보를 알아서 파싱한다. 서버에서 CarDto를 리턴한다. template이 json 형태로 바꿔준다.
        log.info("server to status code = {}", responseEntity.getStatusCode().toString());
        log.info("server to client return obj={}", responseEntity.getBody());
        log.info("server headers infos = {}", responseEntity.getHeaders());

        return responseEntity.getBody();
    }

    // POST Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public CarDto2 exchangeGet(String name, int age){

        //MultiValueMap을 통해 QueryParam을 map으로 정의할 수 있다.
        // LinkedMultiValueMap은 MultiValueMap의 구현체로 우리는 LinkedMultiValueMap을 사용해서 적용
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        params.add("name",name);
        params.add("age",String.valueOf(age));

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/get/exchange").
                queryParams(params).
                encode()
                .build().toUri();

        log.info("uri str={}", uri.toString());  // 이까지는 동일

        var requestEntity = RequestEntity.get(uri)
                .header("x_auth","daegu_uuu")
                .build();

        var responseEntity = template.exchange(requestEntity, CarDto2.class);  // exchange가 원하는 정보를 알아서 파싱한다. 서버에서 CarDto를 리턴한다. template이 json 형태로 바꿔준다.

        return responseEntity.getBody();
    }

    // POST Http://localhost:9090/api/server/user/{id}/pw/{pw}?name=kim&age=19
    public ReserveDto exchangePost(String name, int age){

        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        params.add("name",name);
        params.add("age",String.valueOf(age));

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").
                path("/api/server/post/exchange/generic").
                queryParams(params).
                encode()
                .build().toUri();

        log.info("uri str={}", uri.toString());

        var reserve = ReserveDto.builder().name("starbucks").price(10000).build();
        var genericDto = GenericDto.<ReserveDto>builder().data(reserve).build();  // header은

        var requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-auth", "daegu_univ")
                .body(genericDto);

        // var responseEntity = template.exchange(requestEntity, GenericDto<ReserveDto>.class);
        var responseEntity = template
                .exchange(requestEntity, new ParameterizedTypeReference<GenericDto<ReserveDto>>(){});

        log.info("server to status code = {}", responseEntity.getStatusCode().toString());
        log.info("server to client return obj={}", responseEntity.getBody());
        log.info("server headers infos = {}", responseEntity.getHeaders());

        return responseEntity.getBody().getData();
    }
}
