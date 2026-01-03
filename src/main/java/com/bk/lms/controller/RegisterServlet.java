package com.bk.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bk.lms.model.User;
import com.bk.lms.service.UserService;
import com.bk.lms.util.UsernameUtil;

public class RegisterServlet extends HttpServlet {

	private UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirmPassword");

		// password match check
		if (!password.equals(confirm)) {
			resp.sendRedirect("register.jsp?error=pass");
			return;
		}
		
		if (service.isEmailExists(email)) {
			resp.sendRedirect("register.jsp?error=email");
			return;
		}
		// auto-generate username
		String username = UsernameUtil.generate(fullName, phone);

		User u = new User();
		u.setFullName(fullName);
		u.setEmail(email);
		u.setPhone(phone);
		u.setUsername(username);
		u.setPassword(password);
		u.setRole("STUDENT");
		u.setStatus("ACTIVE");

		service.registerUser(u);

		resp.sendRedirect("login.jsp?registered=1");
	}
}
