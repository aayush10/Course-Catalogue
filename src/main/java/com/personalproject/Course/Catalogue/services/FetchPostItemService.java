package com.personalproject.Course.Catalogue.services;


import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.resultsetextractors.PostItemExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FetchPostItemService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CoursePost getPostItem(int postId){
        String query = "SELECT * FROM coursedb.course_post WHERE post_id = ?";
        CoursePost coursePost = jdbcTemplate.query(query,new PostItemExtractor(),postId);
        return coursePost;
    }
}
