package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    GetUserDetailsService getUserDetailsService;
    public boolean registerUser(User user){
        User dbUser = getUserDetailsService.getUserDetails(user.getUserName());
        if(dbUser != null){
            System.out.println("User already exists");
            return false;
        }
        String insertUser = "INSERT INTO `heroku_2a781f4548f803a.user`(userName,firstName,lastName,password,email,enabled,role)" +
                "VALUES(?,?,?,?,?,?,?)";

        String insertAuth = "INSERT INTO `heroku_2a781f4548f803a.authority` VALUES(?,?)";

        Object[] insertUserArgs = {
                user.getUserName(),user.getFirstName(),user.getLastName(),user.getPassword(),
                user.getEmail(),1,"USER"
        };
        Object[] insertAuthArgs = {
                user.getUserName(),"USER"
        };

        jdbcTemplate.update(insertUser,insertUserArgs);
        jdbcTemplate.update(insertAuth,insertAuthArgs);
        return true;
    }
}
