package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.comparators.CoursePostsComparator;
import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.resultsetextractors.PostCommentsExtractor;
import com.personalproject.Course.Catalogue.resultsetextractors.UserNameFromCommentExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FetchPostCommentsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FetchVotesService fetchVotesService;
    public List<Comment> getPostComments(int postId){
        String query = "SELECT * FROM coursedb.comment WHERE post_id = ?";
        List<Comment> postComments = jdbcTemplate.query(query,new PostCommentsExtractor(),postId);
        if(postComments.size() == 0){
            return postComments;
        }
        for( Comment comment:postComments){
            int commentId = comment.getCommentId();
            HashSet<String> upvotedBy = fetchVotesService.getUpvotedBy(commentId,"comment");
            HashSet<String> downvotedBy = fetchVotesService.getDownVotedBy(commentId,"comment");
            comment.setUpvotedByUsers(upvotedBy);
            comment.setDownVotedByUsers(downvotedBy);
            comment.setUpVotes(upvotedBy.size());
            comment.setDownVotes(downvotedBy.size());
        }
        return postComments;
    }
}
