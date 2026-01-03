package com.bk.lms.service;

import java.util.List;

import com.bk.lms.dao.CourseDAO;
import com.bk.lms.dao.CourseDAOImpl;
import com.bk.lms.model.Course;

public class CourseService {

    private CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAOImpl();
    }

    public void addCourse(Course course) {

        if (course == null) return;

        if (course.getTitle() == null || course.getTitle().isEmpty()) return;

        courseDAO.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
}
