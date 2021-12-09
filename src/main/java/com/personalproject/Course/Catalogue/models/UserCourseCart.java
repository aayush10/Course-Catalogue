package com.personalproject.Course.Catalogue.models;

import java.util.ArrayList;
import java.util.List;

public class UserCourseCart {
    User user;
    List<Course> userCourses;
    List<LearningPath> userPaths;
    public List<Course> searchCourse(){return new ArrayList<>();}
    public boolean addCourse(Course course){
        userCourses.add(course);
        return true;
    }
    public boolean deleteCourse(Course course){
        userCourses.remove(course);
        return true;
    }
    public List<Course> getUserCourses(){
        return userCourses;
    }
}
