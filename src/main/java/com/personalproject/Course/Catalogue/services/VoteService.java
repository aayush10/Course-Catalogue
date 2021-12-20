package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class VoteService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void     vote(Vote voteData){
        String action = voteData.getAction();
        String query,deleteQuery;
        if(action.equals("upvote")){

            query = "INSERT INTO coursedb.votes(entity_id,username,entity_type,upvoted) " +
                    "VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE upvoted = " +
                    "CASE WHEN upvoted = 1 THEN 0 ELSE 1 END,downvoted=0";

        }
        else{
            query = "INSERT INTO coursedb.votes(entity_id,username,entity_type,downvoted)" +
                    "VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE downvoted = " +
                    "CASE WHEN downvoted = 1 THEN 0 ELSE 1 END,upvoted=0";
        }
        Object[] args = {
                voteData.getEntityId(),voteData.getUsername(),voteData.getEntityType(),1
        };
        jdbcTemplate.update(query,args);
    }
}
