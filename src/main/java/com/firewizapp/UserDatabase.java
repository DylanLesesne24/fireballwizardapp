package com.firewizapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, String> users = new HashMap<>();
    private static final String USER_DATA_FILE = "users.txt"; // File to store user data

    static {
        // Load users from file at startup
        loadUsersFromFile();
        // Adding the default admin user (hashed password)
        if (!users.containsKey("admin")) {
            users.put("admin", hashPassword("1234"));
            saveUsersToFile(); // Save after adding default admin
        }
    }

    // Add a new user, with hashed password
    public static void addUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        saveUsersToFile();
    }

    // Validate the user's login credentials (check username and password)
    public static boolean isValidUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        return users.containsKey(username) && users.get(username).equals(hashedPassword);
    }

    // Hash the password using SHA-256 (or any other hashing algorithm)
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Load users from the file
    private static void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // If file doesn't exist or there's an error, just continue (file will be created later)
        }
    }

    // Save users to the file
    private static void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
