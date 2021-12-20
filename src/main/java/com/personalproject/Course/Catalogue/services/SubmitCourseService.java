package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.models.CoursePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

@Component
public class SubmitCourseService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FetchPrevPostIdService fetchPrevPostIdService;
    public boolean submitCourse(CoursePost coursePost){
        String query = "INSERT INTO coursedb.course_post (Name,User_id,Date_submitted,Post_text," +
                "Course_link,Course_category,Course_duration,Course_type,"+
                "topic_id,Course_level) VALUES(?,?,?,?,?,?,?,?,?,?)";
        LocalDate currDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currDate);
        System.out.println(coursePost.getLevel());
        Object[] args = {
                coursePost.getPostCourseName(),coursePost.getSubmittedBy().getId(),
                sqlDate,coursePost.getAbout(),coursePost.getCourseLink(),
                coursePost.getCategory().toString(),coursePost.getDuration().name(),
                coursePost.getType().toString(),
                coursePost.getTopicId(),coursePost.getLevel().toString()
                };
        jdbcTemplate.update(query,args);

        query = "INSERT INTO coursedb.course_format VALUES(?,?)";
        int prevPostId = fetchPrevPostIdService.getPrevPostId();
        List<CourseFormat> formats = coursePost.getFormats();
        for(CourseFormat format : formats){
            args = new Object[]{prevPostId, format.toString()};
            jdbcTemplate.update(query,args);
        }

        return true;
    }
}
