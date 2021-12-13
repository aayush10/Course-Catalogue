package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.services.AddCommentService;
import com.personalproject.Course.Catalogue.services.FetchPostCommentsService;
import com.personalproject.Course.Catalogue.services.FetchPostItemService;
import com.personalproject.Course.Catalogue.services.GetUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ViewCoursePostController {
    @Autowired
    FetchPostItemService fetchPostItemService;
    @Autowired
    FetchPostCommentsService fetchPostCommentsService;
    @Autowired
    AddCommentService addCommentService;
    @Autowired
    GetUserDetailsService getUserDetailsService;

    @GetMapping("/courses/{courseName}/{postId}")
    public String getCoursePost(@PathVariable("postId") int postId,@PathVariable("courseName") String courseName, Model model){
        CoursePost coursePost = fetchPostItemService.getPostItem(postId);
        List<Comment> comments = fetchPostCommentsService.getPostComments(postId);
        String userName = getUserDetailsService.getUserDetails(coursePost.getSubmittedBy().getId()).getUserName();
        coursePost.setPostComments(comments);

        model.addAttribute("comment",new Comment());
        model.addAttribute("userName",userName);
        model.addAttribute("postId",postId);
        model.addAttribute("courseName",courseName);
        model.addAttribute("coursePost",coursePost);
        model.addAttribute("postComments",coursePost.getPostComments());
        return "course_post";
    }
    @PostMapping("/courses/{courseName}/{postId}")
    public String postComment(@PathVariable("courseName") String courseName, @PathVariable("postId") int postId, @ModelAttribute Comment comment){
        org.springframework.security.core.userdetails.User secUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setPostedByUserName(secUser.getUsername());
        comment.setTimestamp(LocalDate.now());
        addCommentService.addComment(comment,postId);

        return "redirect:/courses/"+courseName+"/"+postId;
    }

}
