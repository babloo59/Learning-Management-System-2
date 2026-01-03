package com.bk.lms.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.*;

import com.bk.lms.model.User;
import com.bk.lms.service.UserService;

@WebServlet(name="deactivateAccount", urlPatterns="/deactivateAccount")
public class DeactivateAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        
        if ("ADMIN".equals(user.getRole())) {
            resp.sendRedirect("profile.jsp?error=admin");
            return;
        }

        UserService service = new UserService();
        service.deactivateUser(user.getId());

        session.invalidate();

        resp.sendRedirect("login.jsp?deactivated=1");
    }
}
