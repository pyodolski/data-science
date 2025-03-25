package com.naver.hello.objectmapper;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserTest {

    @Test
    void mapperTest() throws JsonProcessingException {
        var user = new User.Builder().name("kim")
                .age(19)
                .build();

        var objMapper = new ObjectMapper();
        var jsonText = objMapper.writeValueAsString(user);
        System.out.println(jsonText);

        //Json to Object
        var objVal = objMapper.readValue(jsonText, User.class);
        System.out.println(objVal.getName() + ":" + objVal.getAge());
    }

}