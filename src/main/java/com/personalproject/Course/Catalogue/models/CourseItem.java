package com.personalproject.Course.Catalogue.models;

import com.personalproject.Course.Catalogue.enums.CourseCategory;
import com.personalproject.Course.Catalogue.enums.CourseFormat;
import com.personalproject.Course.Catalogue.enums.CourseLevel;

public class CourseItem extends Course{
    Topic topic;
    CourseLevel courseLevel;
    CourseCategory courseCategory;
    CourseFormat courseFormat;
}
