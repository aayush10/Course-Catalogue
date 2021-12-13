package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.resultsetextractors.PostCommentsExtractor;
import com.personalproject.Course.Catalogue.resultsetextractors.UserNameFromCommentExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchPostCommentsService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Comment> getPostComments(int postId){
        String query = "SELECT * FROM coursedb.comment WHERE post_id = ?";
        List<Comment> postComments = jdbcTemplate.query(query,new PostCommentsExtractor(),postId);
        return postComments;
    }
}
