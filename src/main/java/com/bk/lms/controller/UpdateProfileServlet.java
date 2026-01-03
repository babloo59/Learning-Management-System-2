package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.UserService;

public class UpdateProfileServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhone(phone);

        service.updateProfile(user);

        session.setAttribute("user", user); // refresh session

        resp.sendRedirect("profile.jsp?updated=1");
    }
}
