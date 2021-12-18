package com.personalproject.Course.Catalogue.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(dataSource);
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT userName,password,enabled FROM coursedb.user" +
                        " WHERE userName = ?")
                .authoritiesByUsernameQuery("SELECT username,authority from coursedb.authority " +
                        " WHERE username = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();


        http.authorizeHttpRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/user").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/submitCourse").authenticated()
                .antMatchers(HttpMethod.POST,"/courses/*/*").authenticated()
                .antMatchers("/").permitAll()
                .and().formLogin()
                .loginPage("/login");
    }
}
