package com.example.validation.controller;

import com.example.validation.dto.ErrorResDto;
import com.example.validation.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apis/user")
@RestController
public class UserController {

    @PostMapping("/info")
    public ResponseEntity<?> userInfo(@Valid @RequestBody UserDto userDto,
                                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ErrorResDto resDto = ErrorResDto.builder()
                                    .response(HttpStatus.BAD_REQUEST.toString())
                                    .build();

            bindingResult.getAllErrors().forEach(e->{
                String fieldName = ((FieldError)e).getField();
                String msg = ((FieldError)e).getDefaultMessage();

                ErrorResDto.Error error = ErrorResDto.Error.builder()
                        .field(fieldName)
                        .msg(msg)
                        .build();
                resDto.addError(error);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resDto);
        }
        return ResponseEntity.ok(userDto);
    }
}
