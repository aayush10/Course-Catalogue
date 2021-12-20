package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.enums.*;
import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.Topic;
import com.personalproject.Course.Catalogue.services.FetchTopicsService;
import com.personalproject.Course.Catalogue.services.GetUserDetailsService;
import com.personalproject.Course.Catalogue.services.SubmitCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubmitCourseController {
    @Autowired
    GetUserDetailsService getUserDetailsService;
    @Autowired
    FetchTopicsService fetchTopicsService;
    @Autowired
    SubmitCourseService submitCourseService;
    List<Topic> topicList;
    @GetMapping("/submitCourse")
    public String submitCourse(Model model) throws ClassNotFoundException {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        topicList = fetchTopicsService.fetchTopics();

        model.addAttribute("topicItem",new Topic());
        model.addAttribute("topicList",topicList);
        model.addAttribute("coursePost",new CoursePost());
        model.addAttribute("loggedinUsername",user.getUsername());
        //passing enums

        model.addAttribute("CourseLength",CourseLength.values());
        model.addAttribute("CourseCategory", CourseCategory.values());
        model.addAttribute("CourseFormat", CourseFormat.values());
        model.addAttribute("CourseLevel", CourseLevel.values());
        model.addAttribute("CourseType", CourseType.values());
        return "submit_course";
    }
    @PostMapping("/submitCourse")
    public String postCourse(@ModelAttribute CoursePost coursePostModel, Model model){
        int topicId = coursePostModel.getTopicId();
        User secUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.personalproject.Course.Catalogue.models.User user = getUserDetailsService.getUserDetails(secUser.getUsername());
        coursePostModel.setSubmittedBy(user);
        System.out.println(coursePostModel.getLevel());
        submitCourseService.submitCourse(coursePostModel);
        int topicIdSubmitted = coursePostModel.getTopicId();

        return "redirect:/courses/"+getTopicName(topicIdSubmitted);
    }
    public String getTopicName(int topicId){
        String topicName= "";
        for(Topic topic : topicList){
            if(topic.getId() == topicId){
                return topic.getCourseName();
            }
        }
        return topicName;
    }
}
