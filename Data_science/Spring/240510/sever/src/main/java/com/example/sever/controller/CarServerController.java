package com.example.sever.controller;

import com.example.sever.dto.CarServerDto;
import com.example.sever.dto.GenericDto;
import com.example.sever.dto.ReserveDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.users.GenericRole;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/server")
public class CarServerController {

    @GetMapping(path = "/get")
    public CarServerDto getCar(@RequestParam(name = "name")String name,
                       @RequestParam(name = "age")Integer age) {

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        return carServerDto;
    }

    @GetMapping(path = "/user/{id}/pw/{pw}")
    public ResponseEntity<CarServerDto> getUser(@RequestParam(name = "name")String name,
                                @RequestParam(name = "age")Integer age,
                                @PathVariable(name = "id")String id,
                                @PathVariable(name = "pw")String pw) {

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-auth",id+":"+pw);
        httpHeaders.add("time", LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(carServerDto);
    }

    @PostMapping(path = "/post")
    public CarServerDto post(@RequestBody ReserveDto reserveDto,
                             @RequestParam(name = "name")String name,
                             @RequestParam(name = "age")Integer age){
        log.info("post body = {}", reserveDto);

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        return carServerDto;
    }

    @PostMapping(path = "/post/exchange")
    public ResponseEntity<CarServerDto> postEx(@RequestBody ReserveDto reserveDto,
                             @RequestParam(name = "name")String name,
                             @RequestParam(name = "age")Integer age,
                               @RequestHeader(name = "x-auth")String xAuth){
        log.info("post body = {}", reserveDto);

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("res_xauth", xAuth);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(carServerDto);
    }

    @GetMapping(path = "/get/exchange")
    public CarServerDto getCarExchange(@RequestParam(name = "name")String name,
                               @RequestParam(name = "age")Integer age) {

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        CarServerDto carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        return carServerDto;
    }

    @PostMapping(path = "/post/exchange/generic")
    public ResponseEntity<GenericDto> postExchangeGeneric(@RequestBody GenericDto<ReserveDto> genericDto,
                                             @RequestParam(name = "name")String name,
                                             @RequestParam(name = "age")Integer age,
                                             @RequestHeader(name = "x-auth")String xAuth){
        log.info("post body = {}", genericDto);

        List<CarServerDto.Car> cars = Arrays.asList(
                CarServerDto.Car.builder().name("A4").carNum("A4-1111").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A6").carNum("A6-2222").brand("AUDI").build(),
                CarServerDto.Car.builder().name("A8").carNum("A8-3333").brand("AUDI").build()
        );

        var carServerDto = CarServerDto.builder().name(name).age(age).cars(cars).build();

        var headers = new HttpHeaders();
        headers.add("res_xauth", xAuth);

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(GenericDto.<ReserveDto>builder()
                    .header(
                        GenericDto.Header.builder()
                              .resType(HttpStatus.CREATED.toString())
                              .msg("good jab man").build())
                   .data(
                        genericDto.getData())
                .build());

    }
}
