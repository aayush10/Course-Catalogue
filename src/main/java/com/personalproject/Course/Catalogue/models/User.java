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
    public boolean postComment(CoursePost post){
        LocalDateTime currTime = LocalDateTime.now();
        Comment comment = new Comment(this,currTime);
        return post.addComment(comment);
    }
    public boolean login(String userName,String password){
        return loginService.login(userName,password);

    }
}
