package com.personalproject.Course.Catalogue.models;

import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    int commentId;
    int postedById;
    LocalDate timestamp;
    long upVotes;
    long downVotes;
    String commentText;
    List<Comment> replies;
    //Constructor
    public Comment(String commentText, Date timestamp,int postedById) {
        this.commentText = commentText;
        this.timestamp = timestamp.toLocalDate();
        this.postedById = postedById;
    }
}
