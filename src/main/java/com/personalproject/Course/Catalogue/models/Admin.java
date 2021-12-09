package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.dbConn.JDBCConn;
import com.personalproject.Course.Catalogue.services.SearchService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person{
    SearchService searchService;
    JDBCConn conn;
    public boolean DeleteTopic(Topic topic){
        //insert db operations
        return true;
    }
    public boolean UpdateTopic(Topic topic){
        //insert db operations
        return true;
    }
    public List<Topic> searchTopic(String searchString){
        //todo
        return new ArrayList<>();
    }
//    public boolean addTopic(String topicName){
//        Topic topic = new Topic(topicName);
//        LocalDateTime dateTime = LocalDateTime.now();
//        //insert db operations
//        return true;
//    }
	public void searchCourse(String searchString){
        searchService.searchByCourse(searchString);
    }
    public List<Course> searchCourseById(String id){
        return new ArrayList<>();
    }
}
