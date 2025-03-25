package com.example.validation.validate;

import com.example.validation.annotation.DateValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// custom annotation 검증 클래스
public class DataValidValidator implements ConstraintValidator<DateValid, String> {
    private String pattern;

    @Override
    public void initialize(DateValid constraintAnnotation) {
        pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try{
            var localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}

