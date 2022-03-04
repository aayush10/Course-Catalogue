package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.comparators.CoursePostsComparator;
import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.resultsetextractors.CoursePostsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
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
    @Autowired
    FetchPostCommentsService fetchPostCommentsService;
    @Autowired
    FetchCourseFormatsService fetchCourseFormatsService;
    public List<CoursePost> fetchCoursePosts(){
        String query = "SELECT * FROM `heroku_2a781f4548f803a.course_post`";
        List<CoursePost> coursePosts = jdbcTemplate.query(query,new CoursePostsExtractor());
        setPostDetails(coursePosts);
        return coursePosts;
    }
    public List<CoursePost> fetchCoursePosts(int topicId){
        String query = "SELECT * FROM `heroku_2a781f4548f803a.course_post` where topic_id = ?";
        List<CoursePost> coursePosts = jdbcTemplate.query(query,new CoursePostsExtractor(),topicId);
        setPostDetails(coursePosts);
        Collections.sort(coursePosts,new CoursePostsComparator());
        return coursePosts;
    }

    public void setPostDetails(List<CoursePost> coursePosts){
        if(coursePosts.size() == 0){
            return;
        }
        for(CoursePost cp:coursePosts){
            int postId = cp.getPost_id();
            long userId = cp.getSubmittedBy().getId();
            User user =getUserDetailsService.getUserDetails(userId);
            List<Comment> comments = fetchPostCommentsService.getPostComments(postId);
            List<CourseFormat> courseFormats = fetchCourseFormatsService.getCourseFormats(postId);
            cp.setSubmittedBy(user);
            HashSet<String> upvotedBy = fetchVotesService.getUpvotedBy(postId,"crspost");
            HashSet<String> downvotedBy = fetchVotesService.getDownVotedBy(postId,"crspost");
            cp.setUpvotedByUsers(upvotedBy);
            cp.setDownVotedByUsers(downvotedBy);
            cp.setUpVotes(upvotedBy.size());
            cp.setDownVotes(downvotedBy.size());
            cp.setPostComments(comments);
            cp.setFormats(courseFormats);
        }
    }
}
