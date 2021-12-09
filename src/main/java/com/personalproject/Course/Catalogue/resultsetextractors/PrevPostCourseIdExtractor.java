package com.personalproject.Course.Catalogue.resultsetextractors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrevPostCourseIdExtractor implements ResultSetExtractor<Integer> {
    @Override
    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
        Integer previousPostId;
        rs.next();
        return rs.getInt(1);
    }
}
