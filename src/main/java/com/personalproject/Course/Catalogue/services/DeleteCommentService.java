package com.personalproject.Course.Catalogue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void deleteCommentById(long id){
        String sql = "DELETE FROM coursedb.comment WHERE comment_id = ?";
        deleteCommentUpvotes(id);
        jdbcTemplate.update(sql,id);
    }
    public void deleteCommentUpvotes(long id){
        String sql = "DELETE FROM coursedb.votes WHERE entity_id = ? AND entity_type = 'comment'";
        jdbcTemplate.update(sql,id);
    }
}
