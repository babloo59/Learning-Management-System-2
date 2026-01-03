package com.bk.lms.dao;

import java.util.List;

import com.bk.lms.model.Course;
import com.bk.lms.model.User;

public interface EnrollmentDAO {
	void enroll(int userId, int courseId);

	boolean isEnrolled(int userId, int courseId);

	List<Course> getEnrolledCourses(int userId);

	List<User> getEnrolledStudents(int courseId);

	void unEnroll(int userId, int courseId);
}
