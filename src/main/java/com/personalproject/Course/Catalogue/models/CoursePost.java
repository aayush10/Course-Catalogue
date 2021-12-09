package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.enums.*;
import com.personalproject.Course.Catalogue.services.SubmitCourseService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CoursePost {
    int post_id;
    Course course;
    int topicId;
    String postCourseName;  // name of the course as in the website
    long upVotes;
    long downVotes;
    String about;
    String courseLink;
    LocalDate timestamp;
    List<Comment> postComments;
    Person submittedBy;
    List<CourseFormat> formats;                  // a single course can have different formats
    CourseCategory category;
    CourseLevel level;
    CourseLength duration;
    CourseType type;
    public CoursePost(){}
    public CoursePost(int post_id, String name, int user_id, java.sql.Date date_submitted, String post_text, String course_category, String course_duration, String course_type, int topic_id,String course_level) {
        this.post_id = post_id;
        this.postCourseName = name;
        this.submittedBy = new Person(user_id);
        this.timestamp = date_submitted.toLocalDate(); //todo
        this.about = post_text;
        this.category = CourseCategory.valueOf(course_category);
        this.duration = CourseLength.valueOf(course_duration);
        this.type = CourseType.valueOf(course_type);
        this.level = CourseLevel.valueOf(course_level);
//        this.submittedBy = submittedBy;
    }

    public boolean addComment(Comment comment){
        postComments.add(comment);
        return true;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPostCourseName() {
        return postCourseName;
    }

    public void setPostCourseName(String postCourseName) {
        this.postCourseName = postCourseName;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public List<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<Comment> postComments) {
        this.postComments = postComments;
    }

    public Person getSubmittedBy() {
        return this.submittedBy;
    }

    public void setSubmittedBy(Person submittedBy) {
        this.submittedBy = submittedBy;
    }

    public List<CourseFormat> getFormats() {
        return formats;
    }

    public void setFormats(List<CourseFormat> formats) {
        this.formats = formats;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public void setCategory(CourseCategory category) {
        this.category = category;
    }

    public CourseLevel getLevel() {
        return level;
    }

    public void setLevel(CourseLevel level) {
        this.level = level;
    }

    public CourseLength getDuration() {
        return duration;
    }

    public void setDuration(CourseLength duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }


}
