package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.enums.CourseCategory;
import java.util.Date;
import java.util.List;

public class Topic extends Course{

    List<CoursePost> coursePosts;
    long popularity;
    Date createdDate;
    String imageLink;
    CourseCategory topicCategory;

//    public Topic() {}
//    public Topic(int id,String topicName){
//        super(id,topicName);
//        coursePosts = new ArrayList<>();
//    }
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getCourseName() {
        return super.getCourseName();
    }

    @Override
    public void setCourseName(String courseName) {
        super.setCourseName(courseName);
    }

    public CourseCategory getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(CourseCategory topicCategory) {
        this.topicCategory = topicCategory;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean addCourse(Course course){
        return false;
    }
    public List<CoursePost> getCoursePosts() {
        return coursePosts;
    }

    public void setCoursePosts(List<CoursePost> coursePosts) {
        this.coursePosts = coursePosts;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
