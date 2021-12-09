package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.enums.CourseCategory;
import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.enums.CourseLength;
import com.personalproject.Course.Catalogue.enums.CourseType;

public class Course {
    int id;
    String courseName;
    public Course(){}
    public Course(int id,String courseName){
        this.id = id;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
