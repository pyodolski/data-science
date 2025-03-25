package com.example.aop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoDto {
    @JsonProperty(value = "id", required = true)
    private String userId;
    @JsonProperty(value = "pw", required = true)
    private String userPw;
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
