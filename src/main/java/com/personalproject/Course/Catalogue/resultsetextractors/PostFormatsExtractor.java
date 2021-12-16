package com.personalproject.Course.Catalogue.resultsetextractors;

import com.personalproject.Course.Catalogue.enums.CourseFormat;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostFormatsExtractor implements ResultSetExtractor<List<CourseFormat>> {

    @Override
    public List<CourseFormat> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CourseFormat> courseFormats = new ArrayList<>();

        while(rs.next()){
            String format = rs.getString("Course_format");
            courseFormats.add(CourseFormat.valueOf(format));
        }
        return courseFormats;
    }
}
