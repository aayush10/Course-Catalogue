package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.enums.*;
import com.personalproject.Course.Catalogue.services.LoginService;
import com.personalproject.Course.Catalogue.services.SearchService;
import com.personalproject.Course.Catalogue.services.SubmitCourseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Person{
    LoginService loginService;
    SearchService search;
    UserCourseCart userCart;
    SubmitCourseService submitCourseService;
    List<Course> submittedCourses;

    @Override
    public long getId() {
        return super.getId();
    }
    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(String role) {
        super.setRole(role);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }



    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public SearchService getSearch() {
        return search;
    }

    public void setSearch(SearchService search) {
        this.search = search;
    }

    public UserCourseCart getUserCart() {
        return userCart;
    }

    public void setUserCart(UserCourseCart userCart) {
        this.userCart = userCart;
    }

    public SubmitCourseService getSubmitCourseService() {
        return submitCourseService;
    }

    public void setSubmitCourseService(SubmitCourseService submitCourseService) {
        this.submitCourseService = submitCourseService;
    }

    public List<Course> getSubmittedCourses() {
        return submittedCourses;
    }

    public void setSubmittedCourses(List<Course> submittedCourses) {
        this.submittedCourses = submittedCourses;
    }

    public List<Course> getAllSavedCourses(){
        return userCart.getUserCourses();
    }
    public boolean submitCourse(CoursePost coursePost){
        return submitCourseService.submitCourse(coursePost);
    }
    public List<Course> searchCourse(String searchString){
        List<Course> res = search.searchByCourse(searchString);
        return res;
    }
    public boolean addToMyCourse(Course course){
        return userCart.addCourse(course);
    }
    public boolean deleteFromMyCourses(Course course){
        return userCart.deleteCourse(course);
    }
    public boolean login(String userName,String password){
        return loginService.login(userName,password);

    }
}
