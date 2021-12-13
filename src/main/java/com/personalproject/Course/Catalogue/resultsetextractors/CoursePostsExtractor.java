package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursePostsExtractor implements ResultSetExtractor<List<CoursePost>> {

    @Override
    public List<CoursePost> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CoursePost> coursePostList = new ArrayList<>();
        User user;
        while(rs.next()){
            int userId = rs.getInt("User_id");
            CoursePost coursePost = new CoursePost(
                    rs.getInt("post_id"),
                    rs.getString("Name"),
                    userId,
                    rs.getDate("Date_submitted"),
                    rs.getString("Post_text"),
                    rs.getString("Course_link"),
                    rs.getString("Course_category"),
                    rs.getString("Course_duration"),
                    rs.getString("Course_type"),
                    rs.getInt("topic_id"),
                    rs.getString("Course_level")
            );
            coursePostList.add(coursePost);
        }
        return coursePostList;
    }
}
