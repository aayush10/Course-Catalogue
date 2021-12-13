package com.personalproject.Course.Catalogue.resultsetextractors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserNameFromCommentExtractor implements ResultSetExtractor<String> {

    @Override
    public String extractData(ResultSet rs) throws SQLException, DataAccessException {
        return rs.getString("userName");
    }
}
