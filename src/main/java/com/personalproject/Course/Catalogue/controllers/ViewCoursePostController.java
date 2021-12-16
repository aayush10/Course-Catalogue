package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.models.Comment;
import com.personalproject.Course.Catalogue.models.CoursePost;
import com.personalproject.Course.Catalogue.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    FetchCourseFormatsService fetchCourseFormatsService;
    @GetMapping("/courses/{courseName}/{postId}")
    public String getCoursePost(@PathVariable("postId") int postId,@PathVariable("courseName") String courseName, Model model){
        CoursePost coursePost = fetchPostItemService.getPostItem(postId);
        List<Comment> comments = fetchPostCommentsService.getPostComments(postId);
        List<CourseFormat> courseFormats = fetchCourseFormatsService.getCourseFormats(postId);
        String userName = getUserDetailsService.getUserDetails(coursePost.getSubmittedBy().getId()).getUserName();
        Object secUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(secUser);
        String loggedInUserName;
        if(secUser instanceof String){
            System.out.println("notloggedin");
            loggedInUserName="";
        }
        else{
            User user = (User)secUser;
            loggedInUserName = user.getUsername();
        }
        coursePost.setPostComments(comments);
        coursePost.setFormats(courseFormats);
        model.addAttribute("comment",new Comment());
        model.addAttribute("userName",userName);
        model.addAttribute("loggedinUsername",loggedInUserName);

        model.addAttribute("postId",postId);
        model.addAttribute("courseName",courseName);
        model.addAttribute("coursePost",coursePost);
        model.addAttribute("postComments",coursePost.getPostComments());
        return "course_post";
    }
    @PostMapping("/courses/{courseName}/{postId}")
    public String postComment(@PathVariable("courseName") String courseName, @PathVariable("postId") int postId, @ModelAttribute Comment comment){
        org.springframework.security.core.userdetails.User secUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(comment.getCommentText().length() >0){
            comment.setPostedByUserName(secUser.getUsername());
            comment.setTimestamp(LocalDate.now());
            addCommentService.addComment(comment,postId);
        }
        else{//upvote req
            System.out.println("User upvoted");
        }
        return "redirect:/courses/"+courseName+"/"+postId;
    }

}
