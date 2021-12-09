package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.resultsetextractors.PrevPostCourseIdExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FetchPrevPostIdService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer getPrevPostId(){
        String sql = "SELECT MAX(post_id) FROM coursedb.course_post";
        Integer prevPostId = jdbcTemplate.query(sql, new PrevPostCourseIdExtractor());
        return prevPostId;
    }
}
