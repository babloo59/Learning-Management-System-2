package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.EnrollmentService;

public class MyCoursesServlet extends HttpServlet {

    private EnrollmentService service = new EnrollmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        req.setAttribute(
            "courses",
            service.getEnrolledCourses(user.getId())
        );

        req.getRequestDispatcher("mycourses.jsp")
           .forward(req, resp);
    }
}
