package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.Vote;
import com.personalproject.Course.Catalogue.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {
    @Autowired
    VoteService voteService;
    @PostMapping("/courses/{courseName}/{postId}/voted")
    public ResponseEntity<Object> voted(@RequestBody Vote voteData){
        System.out.println(voteData);

        voteService.vote(voteData);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
