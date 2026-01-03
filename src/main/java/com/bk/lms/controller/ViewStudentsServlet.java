package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.EnrollmentService;

public class ViewStudentsServlet extends HttpServlet {

    private EnrollmentService service = new EnrollmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int courseId = Integer.parseInt(req.getParameter("courseId"));

        req.setAttribute(
            "students",
            service.getEnrolledStudents(courseId)
        );

        req.getRequestDispatcher("students.jsp")
           .forward(req, resp);
    }
}
