package com.naver.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PyoDto {
    private String name;
    private String email;
    @JsonProperty(value = "my_hobby", required = true)
    private MyHobby myHobby;

    public static class MyHobby { // 객체 안에 속성을 추가할 수 있음
        private String name;
        private String use;
        private int terms;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUse() {
            return use;
        }
        public void setUse(String use) {
            this.use = use;
        }
        public int getTerms() {
            return terms;
        }
        public void setTerms(int terms) {
            this.terms = terms;
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
