package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.models.User;
import com.personalproject.Course.Catalogue.services.FetchCoursePostsService;
import com.personalproject.Course.Catalogue.services.SubmitCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewCourseController {
    @Autowired
    FetchCoursePostsService fetchCoursePostsService;
    @GetMapping("/courses")
    public String getCourseList(Model model){
//        model.addAttribute();
        List<CoursePost> coursePosts = fetchCoursePostsService.fetchCoursePosts();
        model.addAttribute("coursePosts",coursePosts);
        return "course_list";
    }

}
