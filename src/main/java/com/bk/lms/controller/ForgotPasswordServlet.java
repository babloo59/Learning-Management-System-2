package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.bk.lms.service.UserService;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	private UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FORGOT PASSWORD SERVLET HIT");

		String email = req.getParameter("email");
		String newPass = req.getParameter("newPassword");
		String confirm = req.getParameter("confirmPassword");

		if (!newPass.equals(confirm)) {
			resp.sendRedirect("forgot-password.jsp?error=match");
			return;
		}

		boolean ok = service.resetPassword(email, newPass);
		System.out.println("reset: "+ok);

		if (!ok) {
			resp.sendRedirect("forgot-password.jsp?error=user");
			return;
		}

		resp.sendRedirect("login.jsp?reset=1");
	}
}
