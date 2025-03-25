package com.naver.hello.controller;

import com.naver.hello.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// URI 지정 annotation
// http://localhost:8081/apis
@RequestMapping(path = "/apis")
// RequestMapping 은 GET, POST, DELETE, ... 등 들어오는 요청을 다 수행하겠다는 소리, URL = unique 한 URL 이여야한다.(당연하쥬)
@RestController  // rest 전용 controller (page관련 controller 가 아님)
public class GetApiController {

    // GET http://localhost:8081/apis/hello
    // Http method get method
    @GetMapping(path = "/hello")
    public String hello() {  // public 필수
        return "hello spring boot!";
    }

    // http://localhost:8081/apis/name/{kim}
    // URI path에 있는 변수라고 해서  PathVariable 이라고 말함.
    @GetMapping(path = "/name1/{idx}")
    public String pathVar(@PathVariable(name = "idx") String name) {

        return "path-variable value = " + name;
    }

    // 해보기
    // GET http://localhost:8080/apis/name/{kim}/age/{18}
    @GetMapping(path = "name/{first}/age/{old}")
    public String age(@PathVariable(name = "first") String name,
                      @PathVariable(name = "old") int age) {
        return "userInfo name: " + name + "age: " + age;
    }

    // require test
    // /name/kim/age/20, /name/park
    @GetMapping(path = {"name/{first}/age/{old}", "name/{first}"})
    public String required(@PathVariable(name = "first") String name,
                           @PathVariable(name = "old", required = false) Integer age) {  // required false : 하면 Integer 로 받아야 함
        if (age == null) age = 1;
        return "userInfo name: " + name + "age: " + age;
    }

    /*
     * Query Parameter
     */

    // http://localhost:8080/apis/query?id=kim&pw=1234
    @GetMapping(path = "/query")
    public String queryParams(@RequestParam(name = "id") String userId,
                              @RequestParam(name = "pw") String password) {
        return userId + ":" + password;
    }

    // http://localhost:8080/apis/query?id=kim&pw=1234
    @GetMapping(path = "/query2")
    public String queryParams1(@RequestParam(name = "id") String userId,
                               @RequestParam(name = "pw") String password) {
        return userId + ":" + password;
    }

    // GET http://localhost:8080/apis/query/{name}/
                                            // {age}?id=kim&pw=1234&addr=busan
    @GetMapping(path = "/query/{name}/{age}")
    public String mixGet(@PathVariable(name = "name")String userName,
                         @PathVariable(name = "age")int age,
                         @RequestParam(name = "id")String userID,
                         @RequestParam(name = "pw")String pw) {
        return userID + ":" + userName + ":" + userID + ":" + age + ":" + pw;
    }

    @GetMapping(path = "/query/map")
    public String queryMap(@RequestParam Map<String, String> params) {
        var sb = new StringBuilder();
        params.entrySet().forEach(e->{
            System.out.println("key=" + e.getKey());
            System.out.println("value=" + e.getValue());
            System.out.println();


            String id;
            if(e.getKey().equals("id")) id = e.getValue();

            sb.append(e.getKey() + "=" + e.getValue());
        });
        return sb.toString();
    }

    //http://localhost:8080/apis/obj?name=pyo&age=25&email=pp0928ww@naver.com
    @GetMapping(path = "/obj")
    public UserDto queryParamObj(UserDto userDto) {
        System.out.println(userDto.getName());
        return userDto;
    }
}