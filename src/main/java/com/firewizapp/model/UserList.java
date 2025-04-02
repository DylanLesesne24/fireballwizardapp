package com.firewizapp.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Singleton class that manages a list of users for the application.
 * This class is responsible for loading users from persistent storage,
 * adding new users (while enforcing username uniqueness), and providing access
 * to individual users or the complete list of users.
 * The user list is initialized from a JSON file via Data_Loader.
 * 
 * Tested by Laurin Johnson, FULLY WORKING
 */
public class UserList {

    private static ArrayList<User> users;
    private static UserList userList;
    private User currentLoginAttemptUser; // Declare the variable to hold the current user during login check

    /**
     * Private constructor for the UserList singleton.
     * Initializes the internal user list by loading data from Users.json
     * using Data_Loader's loadUsers(). This constructor is only called once
     * when the singleton instance is first created via getInstance().
     */
    private UserList() {
        users = Data_Loader.loadUsers(); // This is for data loader and writer, this is creating the starting list of
                                         // users that are read from the json file
    }

    /**
     * Retrieves the singleton instance of the UserList.
     *
     * If the instance has not been created yet, it initializes the user list
     * by loading from persistent storage.
     * 
     * Tested by Laurin Johnson, WORKS
     * 
     * @return the singleton UserList instance
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    /**
     * Attempts to add a new user to the list.
     * This method checks for a case-insensitive match on the username.
     * If a matching user already exists, the method will not modify the list and will return false.
     * 
     * Tested by Laurin Johnson, WORKS
     * 
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param username the desired username (must be unique)
     * @param password the user's password
     * @param email the user's email address
     * @param skillLevel the user's skill level ("BEGINNER", "INTERMEDIATE", or "PRO")
     * @param filter whether word filtering is enabled for the user
     * @return true if the user was added; false if a user with the same username already exists
     */
    public boolean addUser(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }

        users.add(new User(UUID.randomUUID(), username, password, firstName, lastName, email, skillLevel, filter, new String[] {}));
        return true;
    }

    /**
     * Retrieves a user from the list by username (case-insensitive). For returning a single user
     * 
     * Tested by Laurin Johnson, WORKS
     * 
     * @param username the username to search for
     * @return the matching User object
     * @throws IllegalArgumentException if the input username is null
     * @throws NoSuchElementException if no matching user is found
     */
    public User getUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null.");
        }

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        throw new NoSuchElementException("User not found! Try again.");
    }

    /**
     * Retrieves the complete list of users. If the list is empty or uninitialized, it is reloaded from persistent storage.
     * For returning all users
     * 
     * Tested by Laurin Johnson, WORKS
     * 
     * @return an ArrayList containing all users
     */
    public static ArrayList<User> getUsers() {
        if (users == null || users.isEmpty()) {
            users = Data_Loader.loadUsers(); // Optionally, load users again if list is empty
        }

        return users;
    }

    // Uncommented and fixed these methods
    public boolean checkUsername(String inputUsername) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(inputUsername)) {
                currentLoginAttemptUser = user; // Store the current user for further validation
                return true;
            }
        }

        currentLoginAttemptUser = null; // Reset the current user if not found
        return false;
    }

    public boolean checkPassword(String inputPassword) {
        if (currentLoginAttemptUser == null) {
            return false; // No user has been found, so password check is invalid
        }

        return currentLoginAttemptUser.getPassword().equals(inputPassword);
    }
}
