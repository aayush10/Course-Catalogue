package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.resultsetextractors.UserExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetUserDetailsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public User getUserDetails(long id){
        String query = "SELECT * FROM `heroku_2a781f4548f803a.user` WHERE userId = ?";
        User user = jdbcTemplate.query(query,new UserExtractor(),id);
        System.out.println("submittedby "+user.getUserName());
        return user;
    }
    public User getUserDetails(String username){
        String query = "SELECT * FROM `heroku_2a781f4548f803a.user` WHERE userName = ?";
        User user = jdbcTemplate.query(query,new UserExtractor(),username);
        return user;
    }
}
