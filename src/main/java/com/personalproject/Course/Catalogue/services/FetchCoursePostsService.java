package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.resultsetextractors.CoursePostsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Component
public class FetchCoursePostsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    GetUserDetailsService getUserDetailsService;
    public List<CoursePost> fetchCoursePosts(){
        String query = "SELECT * FROM coursedb.course_post";
        List<CoursePost> coursePosts = jdbcTemplate.query(query,new CoursePostsExtractor());
        for(CoursePost cp:coursePosts){
            long userId = cp.getSubmittedBy().getId();
            User user =getUserDetailsService.getUserDetails(userId);
            cp.setSubmittedBy(user);
            System.out.println(cp.getSubmittedBy());
        }
        return coursePosts;
    }

}
