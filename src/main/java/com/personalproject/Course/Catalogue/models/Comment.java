package com.personalproject.Course.Catalogue.models;

import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Comment {
    int commentId;
    int postedById;
    String postedByUserName;
    LocalDate timestamp;
    long upVotes;
    long downVotes;
    HashSet<String> upvotedByUsers;
    HashSet<String> downVotedByUsers;
    String commentText;
    List<Comment> replies;
    //Constructor
    public Comment(){}
    public Comment(int commentId,String commentText, Date timestamp,String userName) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.timestamp = timestamp.toLocalDate();
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

    public HashSet<String> getUpvotedByUsers() {
        return upvotedByUsers;
    }

    public void setUpvotedByUsers(HashSet<String> upvotedByUsers) {
        this.upvotedByUsers = upvotedByUsers;
    }

    public HashSet<String> getDownVotedByUsers() {
        return downVotedByUsers;
    }

    public void setDownVotedByUsers(HashSet<String> downVotedByUsers) {
        this.downVotedByUsers = downVotedByUsers;
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
