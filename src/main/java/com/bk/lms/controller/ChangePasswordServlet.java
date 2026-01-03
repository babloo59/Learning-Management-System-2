package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.UserService;
import com.bk.lms.util.PasswordUtil;

public class ChangePasswordServlet extends HttpServlet {

	private UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");

		String oldPass = req.getParameter("oldPassword");
		String newPass = req.getParameter("newPassword");
		String confirm = req.getParameter("confirmPassword");

		// new password match check
		if (!newPass.equals(confirm)) {
			resp.sendRedirect("change-password.jsp?error=match");
			return;
		}

		// old password verify
		if (!service.verifyPassword(user.getId(), oldPass)) {
			resp.sendRedirect("change-password.jsp?error=old");
			return;
		}

		service.changePassword(user.getId(), newPass);

		resp.sendRedirect("change-password.jsp?success=1");
	}
}
