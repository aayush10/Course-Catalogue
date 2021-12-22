package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RegisterUserService registerUserService;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        String referrer = request.getHeader("Referer");
        System.out.println(referrer);
        request.getSession().setAttribute("url_prior_login",referrer);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("userExist",false);
        return "register_user";
    }

    @PostMapping("/register")
    public String submitUser(@ModelAttribute User user,HttpServletRequest request,Model model) throws ServletException {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        System.out.println("Encoded pass "+user.getPassword());

        boolean result = registerUserService.registerUser(user);
        if(!result){
            model.addAttribute("user",new User());
            model.addAttribute("userExist",true);
            return "register_user";
        }
        request.login(user.getUserName(),user.getPassword());
        return "redirect:/languages";
    }
}
