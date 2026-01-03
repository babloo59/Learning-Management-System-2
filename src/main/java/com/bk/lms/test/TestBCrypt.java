package com.bk.lms.test;

public class TestBCrypt {
    public static void main(String[] args) {
        System.out.println(
            org.mindrot.jbcrypt.BCrypt.hashpw("admin123",
            org.mindrot.jbcrypt.BCrypt.gensalt(10))
        );
    }
}
