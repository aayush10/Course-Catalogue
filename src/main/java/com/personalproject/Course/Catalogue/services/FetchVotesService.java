package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.resultsetextractors.VotedByExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class FetchVotesService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public HashSet<String> getUpvotedBy(int entityId,String entityType){
        String query = "SELECT * FROM coursedb.votes WHERE entity_id = ? AND upvoted = 1 AND entity_type=?";
        Object[] args = {entityId,entityType};
        return jdbcTemplate.query(query, new VotedByExtractor(),args);
    }
    public HashSet<String> getDownVotedBy(int entityId,String entityType){
        String query = "SELECT * FROM coursedb.votes WHERE entity_id = ? AND downvoted = 1 AND entity_type=?";
        Object[] args = {entityId,entityType};
        return jdbcTemplate.query(query, new VotedByExtractor(),args);
    }
}
