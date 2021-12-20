package com.personalproject.Course.Catalogue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register_user";
    }

    @PostMapping("/register")
    public void submitUser(){
        System.out.println("user registered");
    }
}
