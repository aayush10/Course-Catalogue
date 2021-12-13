package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.services.FetchPostCommentsService;
import com.personalproject.Course.Catalogue.services.FetchPostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewCoursePostController {
    @Autowired
    FetchPostItemService fetchPostItemService;
    @Autowired
    FetchPostCommentsService fetchPostCommentsService;
    @GetMapping("/courses/{courseName}/{postId}")
    public String getCoursePost(@PathVariable("postId") int postId, Model model){
        CoursePost coursePost = fetchPostItemService.getPostItem(postId);
        List<Comment> comments = fetchPostCommentsService.getPostComments(postId);
        coursePost.setPostComments(comments);
        model.addAttribute("coursePost",coursePost);
        return "course_post";
    }
}
