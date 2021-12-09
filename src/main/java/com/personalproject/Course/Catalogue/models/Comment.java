package com.personalproject.Course.Catalogue.models;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    int commentId;
    User commentBy;
    LocalDateTime timestamp;
    long upVotes;
    long downVotes;
    List<Comment> replies;
    //Constructor
    public Comment(User commentBy, LocalDateTime timestamp) {
        this.commentBy = commentBy;
        this.timestamp = timestamp;
        replies = new ArrayList<>();
    }
}
