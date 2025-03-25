package com.example.filter3.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private ObjectMapper objectMapper = new ObjectMapper();
    public <T> T strToObj(String json, Class<T> classz) throws JsonProcessingException{
        return objectMapper.readValue(json, classz);
    }

    public <T> String objToStr(T obj) throws  JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
