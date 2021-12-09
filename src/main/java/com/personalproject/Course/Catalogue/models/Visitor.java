package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.dbConn.JDBCConn;
import com.personalproject.Course.Catalogue.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Visitor extends Person{

    SearchService searchService;
    JDBCConn jdbcConn;
    @Autowired
    JdbcTemplate jdbcTemplate;
    DataSource dataSource;
    //inject the below

    public Visitor(){
        System.out.println("Visitor being created");
    }

    public List<Course> searchCourse(String searchString){
        List<Course> res = searchService.searchByCourse(searchString);
        return res;
    }
    public boolean signUp(String firstName,String lastName,String email,String userName,String password) {
        String query = "insert into coursedb.user (userName,firstName,lastName,password,email) values(?,?,?,?,?)";
        Object[] args = {userName,firstName,lastName,password,email};
        jdbcTemplate.update(query,args);
        return true;
    }

}
