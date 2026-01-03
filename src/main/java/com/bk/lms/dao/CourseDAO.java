package com.bk.lms.dao;

import java.util.List;
import com.bk.lms.model.Course;

public interface CourseDAO {

    void addCourse(Course course);

    List<Course> getAllCourses();
}
