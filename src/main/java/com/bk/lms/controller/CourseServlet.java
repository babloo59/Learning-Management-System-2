package com.bk.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bk.lms.model.Course;
import com.bk.lms.service.CourseService;

public class CourseServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Course> courses = courseService.getAllCourses();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);

        courseService.addCourse(course);

        resp.sendRedirect("courses");
    }
}
