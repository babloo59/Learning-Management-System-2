package com.bk.lms.service;

import java.util.List;

import com.bk.lms.dao.UserDAO;
import com.bk.lms.dao.UserDAOImpl;
import com.bk.lms.model.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAOImpl();
	}

	public User login(String email, String password) {

		// Basic validation
		if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
			return null;
		}
		return userDAO.login(email, password);
	}

	public void registerUser(User user) {

		if (user == null)
			return;

		if (user.getUsername() == null || user.getPassword() == null)
			return;

		userDAO.saveUser(user);
	}

	public void updateProfile(User user) {
		userDAO.updateProfile(user);
	}

	public boolean verifyPassword(int userId, String plainPassword) {
		return userDAO.verifyPassword(userId, plainPassword);
	}

	public void changePassword(int userId, String newPassword) {
		userDAO.changePassword(userId, newPassword);
	}

	public boolean resetPassword(String email, String newPassword) {
		return userDAO.resetPassword(email, newPassword);
	}

	public boolean isEmailExists(String email) {
		return userDAO.emailExists(email);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	public void updateUserStatus(int userId, String status) {
	    userDAO.updateUserStatus(userId, status);
	}

	public void toggleStatus(int id) {
		userDAO.toggleStatus(id);
	}

	public void toggleRole(int id) {
		userDAO.toggleRole(id);
	}

	public void deactivateUser(int userId) {
	    userDAO.deactivateUser(userId);
	}

	public void updateUserRole(int userId, String role) {
		userDAO.updateUserRole(userId, role);
	}

}
