package com.bk.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bk.lms.model.Course;
import com.bk.lms.model.User;
import com.bk.lms.util.DBUtil;

public class EnrollmentDAOImpl implements EnrollmentDAO {

	@Override
	public void enroll(int userId, int courseId) {

		String sql = "INSERT INTO enrollments(user_id, course_id) VALUES (?, ?)";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.setInt(2, courseId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isEnrolled(int userId, int courseId) {

		String sql = "SELECT id FROM enrollments WHERE user_id=? AND course_id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.setInt(2, courseId);

			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Course> getEnrolledCourses(int userId) {

		List<Course> list = new ArrayList<>();

		String sql = "SELECT c.id, c.title, c.description FROM courses c JOIN enrollments e ON c.id = e.course_id WHERE e.user_id = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course c = new Course();
				c.setId(rs.getInt("id"));
				c.setTitle(rs.getString("title"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<User> getEnrolledStudents(int courseId) {

		List<User> list = new ArrayList<>();

		String sql = "SELECT u.id, u.username, u.role FROM users u JOIN enrollments e ON u.id = e.user_i WHERE e.course_id = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setRole(rs.getString("role"));
				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void unEnroll(int userId, int courseId) {

		String sql = "DELETE FROM enrollments WHERE user_id=? AND course_id=?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.setInt(2, courseId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
