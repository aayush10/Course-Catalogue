package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RegisterUserService registerUserService;

    @GetMapping("/login")
    public String login(HttpServletRequest request,Model model) {
        String referrer=request.getHeader("Referer");
        if(referrer == null){           //user came from other site

            StringBuffer url = request.getRequestURL();
            for(int i=0;i<5;i++){
                url.deleteCharAt(url.length()-1);
            }
            url.append("languages");
            referrer = url.toString();
        }
        else if(getHref(referrer).equals("register")){
            referrer=(String)request.getSession().getAttribute("url_prior_login");
        }
        request.getSession().setAttribute("url_prior_login",referrer);

        model.addAttribute("loggedInUser",getLoggedInUserName());
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
        System.out.println("username registered is: "+user.getUserName());
        request.login(user.getUserName(),user.getPassword());
        return "redirect:/languages";
    }
    public String getHref(String referrer){
        int N = referrer.length();
        StringBuilder sb = new StringBuilder();
        while(referrer.charAt(--N)!='/'){
            sb.append(referrer.charAt(N));
        }
        return new String(sb.reverse());
    }

    public String getLoggedInUserName(){
        Object secUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUserName;
        if(secUser instanceof String){              //user is not logged in
            loggedInUserName="";
        }
        else{
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)secUser;
            loggedInUserName = user.getUsername();
        }
        return loggedInUserName;
    }
}
