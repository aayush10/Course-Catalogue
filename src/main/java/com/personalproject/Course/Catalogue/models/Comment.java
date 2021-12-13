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
    String postedByUserName;
    LocalDate timestamp;
    long upVotes;
    long downVotes;
    String commentText;
    List<Comment> replies;
    //Constructor
    public Comment(){}
    public Comment(String commentText, Date timestamp,String userName) {
        this.commentText = commentText;
        this.timestamp = timestamp.toLocalDate();
        this.postedById = postedById;
        this.postedByUserName = userName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostedById() {
        return postedById;
    }

    public void setPostedById(int postedById) {
        this.postedById = postedById;
    }

    public String getPostedByUserName() {
        return postedByUserName;
    }

    public void setPostedByUserName(String postedByUserName) {
        this.postedByUserName = postedByUserName;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(long upVotes) {
        this.upVotes = upVotes;
    }

    public long getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(long downVotes) {
        this.downVotes = downVotes;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
}
