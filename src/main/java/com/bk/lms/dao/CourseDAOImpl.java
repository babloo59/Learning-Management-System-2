package com.bk.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bk.lms.model.Course;
import com.bk.lms.util.DBUtil;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void addCourse(Course course) {

        String sql = "INSERT INTO courses(title,description) VALUES(?,?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getTitle());
            ps.setString(2, course.getDescription());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {

        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
}
