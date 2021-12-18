package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.resultsetextractors.CoursePostsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
@Component
public class FetchCoursePostsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    GetUserDetailsService getUserDetailsService;
    @Autowired
    FetchVotesService fetchVotesService;
    public List<CoursePost> fetchCoursePosts(){
        String query = "SELECT * FROM coursedb.course_post";
        List<CoursePost> coursePosts = jdbcTemplate.query(query,new CoursePostsExtractor());
        if(coursePosts.size() == 0){
            return coursePosts;
        }
        for(CoursePost cp:coursePosts){
            long userId = cp.getSubmittedBy().getId();
            User user =getUserDetailsService.getUserDetails(userId);
            cp.setSubmittedBy(user);
            int postId = cp.getPost_id();
            HashSet<String> upvotedBy = fetchVotesService.getUpvotedBy(postId,"crspost");
            HashSet<String> downvotedBy = fetchVotesService.getDownVotedBy(postId,"crspost");
            cp.setUpvotedByUsers(upvotedBy);
            cp.setDownVotedByUsers(downvotedBy);
            cp.setUpVotes(upvotedBy.size());
            cp.setDownVotes(downvotedBy.size());
        }
        return coursePosts;
    }
    public List<CoursePost> fetchCoursePosts(int topicId){
        String query = "SELECT * FROM coursedb.course_post where topic_id = ?";
        List<CoursePost> coursePosts = jdbcTemplate.query(query,new CoursePostsExtractor(),topicId);
        return coursePosts;
    }
}
