package com.bk.lms.controller;

import com.bk.lms.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateUserStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        String status = req.getParameter("status");

        UserService service = new UserService();
        service.updateUserStatus(userId, status);

        resp.sendRedirect("adminUsers");
    }
}
