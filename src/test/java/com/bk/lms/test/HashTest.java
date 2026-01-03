package com.bk.lms.test;

import org.mindrot.jbcrypt.BCrypt;

public class HashTest {
    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("admin123", BCrypt.gensalt()));
    }
}
