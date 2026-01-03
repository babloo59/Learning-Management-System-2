package com.bk.lms.test;

import java.sql.Connection;

import com.bk.lms.util.DBUtil;

public class TestDB {
	public static void main(String[] args) {

        Connection con = DBUtil.getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully");
        } else {
            System.out.println("Database Connection Failed");
        }
    }
}
