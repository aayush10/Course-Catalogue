package com.personalproject.Course.Catalogue.dbConn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn {
    @Value("${mysql.userName}")
    private String userName;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
//    @Value("{mysql.driver}")
//    private static String driver;
    public JDBCConn(){
        System.out.println("JDBCConn bean created by spring..");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DataSource getDataSource() {
        System.out.println(this.url);
        DataSource dataSource = new DriverManagerDataSource(url,userName,password);
        return dataSource;
    }

}
