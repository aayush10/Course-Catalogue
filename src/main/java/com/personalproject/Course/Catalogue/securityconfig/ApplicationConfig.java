package com.personalproject.Course.Catalogue.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {
    @Bean
    public DataSource dataSource(){
        System.out.println("dataSource called");
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setUrl("jdbc:mysql://mysqlinstanceaws.cv7yvcrnwwdv.us-east-2.rds.amazonaws.com:3306");
//        driverManagerDataSource.setUsername("ad_aayush06");
//        driverManagerDataSource.setPassword("aayush10rooney");

        driverManagerDataSource.setUrl("jdbc:mysql://b99e7c3286ebe6:0f1bff95@us-cdbr-east-05.cleardb.net/heroku_2a781f4548f803a?reconnect=true:3306");
        driverManagerDataSource.setUsername("b99e7c3286ebe6");
        driverManagerDataSource.setPassword("0f1bff95");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("Hellomotto24*");

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return driverManagerDataSource;
    }
}
