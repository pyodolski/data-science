package com.example.validation.dto;

import com.example.validation.annotation.DateValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class UserDto{
    @NotBlank
    private String name;
    @Max(value = 110)
    @Min(value = 20)
    private int age;

    @Email
    private String email;
    @DateValid
    @Size(min = 10, max = 10)
    @JsonProperty(value = "req_year_month_day")
    private String reqYearMonthDay;


    // 자바 로컬 타임 파싱
//    @AssertTrue(message = "yyyy/MM/dd 형식이 아닙니다.")
//    public boolean isReqYearMonthDayValidation() {
//        // LocalDate.parse : 잘못된 날짜 형식이 들어오면 throws 던짐 -> try-catch
//        try{
//            var localDate = LocalDate.parse(this.reqYearMonthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//        }catch (Exception e) {
//            return false;
//        }
//        return true;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReqYearMonthDay() {
        return reqYearMonthDay;
    }

    public void setReqYearMonthDay(String reqYearMonthDay) {
        this.reqYearMonthDay = reqYearMonthDay;
    }
}
