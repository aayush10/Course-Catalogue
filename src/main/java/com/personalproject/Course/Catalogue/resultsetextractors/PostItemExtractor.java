package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.models.CoursePost;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostItemExtractor implements ResultSetExtractor<CoursePost> {

    @Override
    public CoursePost extractData(ResultSet rs) throws SQLException, DataAccessException {
        rs.next();
        int postId = rs.getInt("post_id");
        String postCourseName = rs.getString("Name");
        int userId = rs.getInt("User_id");
        Date date = rs.getDate("Date_submitted");
        String about = rs.getString("Post_text");
        String courseLink = rs.getString("Course_link");
        String courseCategory = rs.getString("Course_category");
        String courseDuration = rs.getString("Course_duration");
        String courseType = rs.getString("Course_type");
        int topicId = rs.getInt("topic_id");
        String courseLevel = rs.getString("Course_level");
        return new CoursePost(postId,postCourseName,userId,date,about,courseLink,courseCategory,courseDuration,courseType,topicId,courseLevel);
    }
}
