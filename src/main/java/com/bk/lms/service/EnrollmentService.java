package com.bk.lms.service;

import java.util.List;

import com.bk.lms.dao.EnrollmentDAO;
import com.bk.lms.dao.EnrollmentDAOImpl;
import com.bk.lms.model.Course;
import com.bk.lms.model.User;

public class EnrollmentService {

    private EnrollmentDAO dao = new EnrollmentDAOImpl();

    public void enroll(int userId, int courseId) {
        if (!dao.isEnrolled(userId, courseId)) {
            dao.enroll(userId, courseId);
        }
    }

    public boolean isEnrolled(int userId, int courseId) {
        return dao.isEnrolled(userId, courseId);
    }
    
    public List<Course> getEnrolledCourses(int userId) {
        return dao.getEnrolledCourses(userId);
    }
    
    public List<User> getEnrolledStudents(int courseId) {
        return dao.getEnrolledStudents(courseId);
    }
    
    public void unEnroll(int userId, int courseId) {
        dao.unEnroll(userId, courseId);
    }

}
