package com.firewizapp;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, String> users = new HashMap<>();

    static {
        // Default user for testing
        users.put("admin", "1234");
    }

    public static void addUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
