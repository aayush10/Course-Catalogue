package com.personalproject.Course.Catalogue.services;

import com.personalproject.Course.Catalogue.models.Course;
import com.personalproject.Course.Catalogue.models.CourseItem;
import com.personalproject.Course.Catalogue.models.LearningPath;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    public List<CourseItem> searchByCourseItem(String title){return new ArrayList<>();}
    public List<LearningPath> searchByLearningPath(String title){return new ArrayList<>();}
    public List<Course> searchByCourse(String title){return new ArrayList<>();}				//both courseItem and LP
}
