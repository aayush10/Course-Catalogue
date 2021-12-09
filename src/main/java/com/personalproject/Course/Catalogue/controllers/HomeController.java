package com.personalproject.Course.Catalogue.controllers;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(){
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(authorities);
        return "Welcome to home";
    }
    @GetMapping("/user")
    public String user(){

        return "Welcome to user home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin home";
    }
}
