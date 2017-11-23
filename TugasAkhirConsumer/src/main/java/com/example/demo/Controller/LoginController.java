package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @PostMapping("/login")
    public String loginSubmit(){
        return null;
    }

    @GetMapping("/logout")
    public String logout(){
        return null;
    }
}
