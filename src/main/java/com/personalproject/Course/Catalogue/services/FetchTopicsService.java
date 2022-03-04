package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.Topic;
import com.personalproject.Course.Catalogue.resultsetextractors.TopicExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class FetchTopicsService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Topic> fetchTopics(){
        String query = "SELECT * FROM heroku_2a781f4548f803a.topic";
        List<Topic> topicList = jdbcTemplate.query(query,new TopicExtractor());
        return topicList;
    }
    public List<Topic> fetchTopic(String category){
        String query = "SELECT * FROM heroku_2a781f4548f803a.topic WHERE Category = ?";
        List<Topic> topicList = jdbcTemplate.query(query,new TopicExtractor(),category);
        return topicList;
    }
    public int getTopic(String topicName){
        String query = "SELECT * FROM heroku_2a781f4548f803a.topic WHERE TopicName = ?";
        List<Topic> topicList = jdbcTemplate.query(query,new TopicExtractor(),topicName);
        if(topicList.size() == 0){
            return -1;
        }
        return topicList.get(0).getId();
    }
}
