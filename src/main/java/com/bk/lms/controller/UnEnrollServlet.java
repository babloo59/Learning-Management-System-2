package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.EnrollmentService;

public class UnEnrollServlet extends HttpServlet {

    private EnrollmentService service = new EnrollmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        int courseId = Integer.parseInt(req.getParameter("courseId"));

        service.unEnroll(user.getId(), courseId);

        resp.sendRedirect("mycourses");
    }
}
