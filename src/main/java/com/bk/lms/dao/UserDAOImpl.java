package com.bk.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bk.lms.model.User;
import com.bk.lms.util.DBUtil;
import com.bk.lms.util.PasswordUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User login(String email, String password) {

		System.out.println("LOGIN EMAIL = " + email);

		String sql = "SELECT * FROM users WHERE email=?";
		User user = null;

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("NO USER FOUND IN DB");
				return null;
			}

			String dbHash = rs.getString("password");
			System.out.println("DB HASH = " + dbHash);

			boolean ok = PasswordUtil.verify(password, dbHash);
			System.out.println("PASSWORD MATCH = " + ok);

			if (!ok)
				return null;

			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setRole(rs.getString("role"));
			user.setStatus(rs.getString("status"));

			if (!"ACTIVE".equals(rs.getString("status"))) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void saveUser(User user) {

		String sql = "INSERT INTO users\r\n" + "(username, password, role, full_name, email, phone, status)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, user.getUsername());
			ps.setString(2, PasswordUtil.hash(user.getPassword()));
			ps.setString(3, user.getRole());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getStatus());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProfile(User user) {

		String sql = " UPDATE users SET full_name=?, email=?, phone=? WHERE id=? ";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setInt(4, user.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyPassword(int userId, String plainPassword) {

		String sql = "SELECT password FROM users WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String hashed = rs.getString("password");
				return PasswordUtil.verify(plainPassword, hashed);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void changePassword(int userId, String newPassword) {

		String sql = "UPDATE users SET password=? WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, PasswordUtil.hash(newPassword));
			ps.setInt(2, userId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean resetPassword(String email, String newPassword) {

		String sql = "UPDATE users SET password=? WHERE email=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, PasswordUtil.hash(newPassword));
			ps.setString(2, email);

			return ps.executeUpdate() == 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean emailExists(String email) {

		String sql = "SELECT id FROM users WHERE email=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getAllUsers() {

		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM users";

		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setFullName(rs.getString("full_name"));
				u.setEmail(rs.getString("email"));
				u.setRole(rs.getString("role"));
				u.setStatus(rs.getString("status"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateUserStatus(int userId, String status) {

		String sql = "UPDATE users SET status=? WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, status);
			ps.setInt(2, userId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void toggleStatus(int id) {

		String sql = "UPDATE users SET status = IF(status='ACTIVE','BLOCKED','ACTIVE') WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void toggleRole(int id) {

		String sql = "UPDATE users SET role = IF(role='ADMIN','STUDENT','ADMIN') WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deactivateUser(int userId) {

		String sql = "UPDATE users SET status='DEACTIVE' WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserRole(int userId, String role) {

		String sql = "UPDATE users SET role=? WHERE id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, role);
			ps.setInt(2, userId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
