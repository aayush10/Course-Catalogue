package com.personalproject.Course.Catalogue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewCoursePostController {

    @GetMapping("/courses/{courseName}/{postId}")
    public String getCoursePost(@PathVariable("postId") int postId, Model model){

        return "course_post";
    }
}
