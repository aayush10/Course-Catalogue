package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.services.DeleteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteCommentController {

    @Autowired
    DeleteCommentService deleteCommentService;

    @DeleteMapping("/courses/{courseName}/{postId}/deletecomment")
    public void deleteComment(@RequestBody Integer commentId){
        System.out.println(commentId);
        deleteCommentService.deleteCommentById(commentId);
    }
}
