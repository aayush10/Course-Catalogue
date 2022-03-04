package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AddCommentService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addComment(Comment comment, int postId){
        String sql = "INSERT INTO `heroku_2a781f4548f803a.comment`(post_id,Comment_text,Date_Posted,username)" +
                "VALUES(?,?,?,?)";
        Object[] args = {postId,comment.getCommentText(),comment.getTimestamp(),comment.getPostedByUserName()};
        jdbcTemplate.update(sql,args);
    }
}
