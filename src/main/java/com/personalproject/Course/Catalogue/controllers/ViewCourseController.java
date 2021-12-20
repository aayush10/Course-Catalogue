package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.services.FetchCoursePostsService;
import com.personalproject.Course.Catalogue.services.FetchTopicsService;
import com.personalproject.Course.Catalogue.services.GetUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class ViewCourseController {
    @Autowired
    FetchCoursePostsService fetchCoursePostsService;
    @Autowired
    FetchTopicsService fetchTopicsService;
    @GetMapping("/courses/{courseName}")
    public String getCourseList(@PathVariable("courseName") String topicName, Model model){
        List<CoursePost> coursePosts;
        int topicId = fetchTopicsService.getTopic(topicName);

        if(topicId == -1){
            //No such topicName
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        coursePosts = fetchCoursePostsService.fetchCoursePosts(topicId);
        model.addAttribute("coursePosts",coursePosts);
        model.addAttribute("topicName",topicName);
        model.addAttribute("loggedinUsername",getLoggedInUserName());
        return "course_list";
    }
    public String getLoggedInUserName(){
        Object secUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUserName;
        if(secUser instanceof String){              //user is not logged in
            loggedInUserName="";
        }
        else{
            User user = (User)secUser;
            loggedInUserName = user.getUsername();
        }
        return loggedInUserName;
    }
}
