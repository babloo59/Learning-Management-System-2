package com.bk.lms.util;

public class UsernameUtil {

    public static String generate(String fullName, String phone) {

        String name = fullName.toLowerCase().replaceAll("\\s+", "");
        String last4 = phone.substring(phone.length() - 4);

        return name + last4;   // e.g. rahulkumar8456
    }
}
