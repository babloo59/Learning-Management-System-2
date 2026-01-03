package com.bk.lms.dao;

import java.util.List;

import com.bk.lms.model.User;

public interface UserDAO {

    User login(String email, String password);

    void saveUser(User user);

	void updateProfile(User user);

	boolean verifyPassword(int userId, String plainPassword);

	void changePassword(int userId, String newPassword);

	boolean resetPassword(String email, String newPassword);
	
	boolean emailExists(String email);

	List<User> getAllUsers();

	void toggleStatus(int id);

	void toggleRole(int id);
	
	void deactivateUser(int userId);
	
	void updateUserStatus(int userId, String status);

	void updateUserRole(int userId, String role);
	
	
}
