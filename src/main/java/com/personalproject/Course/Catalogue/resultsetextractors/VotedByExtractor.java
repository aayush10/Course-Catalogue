package com.personalproject.Course.Catalogue.resultsetextractors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VotedByExtractor implements ResultSetExtractor<HashSet<String>> {
    @Override
    public HashSet<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
        HashSet<String> votedBy = new HashSet<>();
        while(rs.next()){
            votedBy.add(rs.getString("username"));
        }
        return votedBy;
    }
}
