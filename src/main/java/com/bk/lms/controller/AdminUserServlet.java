package com.bk.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.UserService;

public class AdminUserServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	UserService service = new UserService();
        List<User> users = service.getAllUsers();

        req.setAttribute("users", users);
        req.getRequestDispatcher("admin/users.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        String action = req.getParameter("action");

        if ("status".equals(action)) {
            String currentStatus = req.getParameter("currentStatus");
            String newStatus =
                    "ACTIVE".equals(currentStatus) ? "DEACTIVE" : "ACTIVE";

            service.updateUserStatus(userId, newStatus);

        } else if ("role".equals(action)) {
            String currentRole = req.getParameter("currentRole");
            String newRole =
                    "ADMIN".equals(currentRole) ? "STUDENT" : "ADMIN";

            service.updateUserRole(userId, newRole);
        }

        resp.sendRedirect("adminUsers");
    }
}
