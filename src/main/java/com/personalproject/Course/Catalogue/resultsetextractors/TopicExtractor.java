package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.models.Topic;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicExtractor implements ResultSetExtractor<List<Topic>> {
    @Override
    public List<Topic> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Topic> topicList = new ArrayList<>();
        while(rs.next()){
            Topic topic = new Topic();
            topic.setId(Integer.parseInt(rs.getString("TopicId")));
            topic.setCourseName(rs.getString("TopicName"));
            topic.setImageLink(rs.getString("Image"));
            topic.setCreatedDate(rs.getDate("Upload_time"));
            topic.setPopularity(rs.getInt("Popularity"));
            topicList.add(topic);
        }
        return topicList;
    }
}
