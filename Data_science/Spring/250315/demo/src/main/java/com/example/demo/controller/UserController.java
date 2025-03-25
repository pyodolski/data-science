package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping // 🔥 추가 (클래스 레벨 매핑)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home"; // 🔥 home.html이 있어야 함
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup"; // 🔥 signup.html이 있어야 함
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // 🔥 login.html이 있어야 함
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute UserVo userVo) {
        userService.joinUser(userVo);
        return "redirect:/login";

    }
}
