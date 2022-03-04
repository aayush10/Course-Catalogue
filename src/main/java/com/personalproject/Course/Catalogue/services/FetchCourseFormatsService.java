package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.resultsetextractors.PostFormatsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchCourseFormatsService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CourseFormat> getCourseFormats(int postId){
        String query = "SELECT * FROM `heroku_2a781f4548f803a.course_format` WHERE post_id = ?";
        return jdbcTemplate.query(query,new PostFormatsExtractor(),postId);
    }
}
