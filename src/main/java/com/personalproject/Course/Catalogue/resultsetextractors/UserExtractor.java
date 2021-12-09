package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtractor implements ResultSetExtractor<User> {

    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        User resultUser = new User();
        rs.next();
        resultUser.setRole(rs.getString("role"));
        resultUser.setUserName(rs.getString("userName"));
        resultUser.setId(Long.parseLong(rs.getString("userId")));
        return resultUser;
    }
}
