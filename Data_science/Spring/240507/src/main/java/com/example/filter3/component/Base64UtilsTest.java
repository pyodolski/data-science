package com.example.filter3.component;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.StringDecoder;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
class Base64UtilsTest {
    public String encode(String str) {
        return new String(Base64.getEncoder().encode(str.getBytes()));
    }
    public String decode(String encStr) {
        return new String(Base64.getDecoder().decode(encStr));
    }
}

