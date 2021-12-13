package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.models.Comment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCommentsExtractor implements ResultSetExtractor<List<Comment>> {

    @Override
    public List<Comment> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Comment> postComments = new ArrayList<>();
        while(rs.next()){
            String commentText = rs.getString("Comment_text");
            Date datePosted = rs.getDate("Date_posted");
            int postedBy = rs.getInt("User_id");
            postComments.add(new Comment(commentText,datePosted,postedBy));
        }
        return postComments;
    }
}
