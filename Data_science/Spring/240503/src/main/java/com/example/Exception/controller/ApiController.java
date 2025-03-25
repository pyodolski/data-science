package com.example.Exception.controller;

import com.example.Exception.dto.Userdto;
import com.example.Exception.errors.MyException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated // controller의 valid를 수행
@RequestMapping("/api/user")
@RestController
public class ApiController {

    @GetMapping("")
    public ResponseEntity<Userdto> get (
            @Size(min = 5)
            @RequestParam(name = "name")String name,
            @NotNull
            @Min(value = 1)
            @RequestParam(name = "age") Integer age) {
        var dto = new Userdto();
        dto.setAge(age);
        dto.setName(name);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/api/user")
    public Userdto post(@Valid @RequestBody Userdto userdto) {
        return userdto;
    } // 객체 맵핑

    @GetMapping(path = "/error")
    public void customException() throws MyException {
        System.out.println("custom exception");
        throw new MyException();
    }
    // 클래스 내 선언시
    
    @ExceptionHandler(value =
            {MyException.class, Exception.class})
    public ResponseEntity handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
