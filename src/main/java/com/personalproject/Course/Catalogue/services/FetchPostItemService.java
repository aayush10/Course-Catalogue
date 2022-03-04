package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.resultsetextractors.PostItemExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class FetchPostItemService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FetchVotesService fetchVotesService;
    public CoursePost getPostItem(int postId){
        String query = "SELECT * FROM heroku_2a781f4548f803a.course_post WHERE post_id = ?";
        CoursePost coursePost = jdbcTemplate.query(query,new PostItemExtractor(),postId);
        HashSet<String> upvotedBy = fetchVotesService.getUpvotedBy(postId,"crspost");
        HashSet<String> downVotedBy = fetchVotesService.getDownVotedBy(postId,"crspost");
        coursePost.setUpvotedByUsers(upvotedBy);
        coursePost.setDownVotedByUsers(downVotedBy);
        coursePost.setUpVotes(upvotedBy.size());
        coursePost.setDownVotes(downVotedBy.size());
        return coursePost;
    }
}
