package com.personalproject.Course.Catalogue.enums;

public enum CourseFormat {
    TEXT,VIDEO,QUIZ,CERTIFICATED
}

class CourseCheck{
    public static void main(String[] main){
        String cf = "TEXT";
        CourseFormat check= CourseFormat.valueOf(cf);
        System.out.println(check);
    }
}
