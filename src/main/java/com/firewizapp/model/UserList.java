package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {

    private static ArrayList<User> users;

    private static UserList userList;

    private UserList() {
        users = Data_Loader.loadUsers(); // This is for data loader and writer, this is creating the starting list of
                                         // users that are read from the json file
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public boolean addUser(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter)
    {
        users.add(new User(UUID.randomUUID(), username, password, firstName, lastName, email, skillLevel, filter, new String[]{}));
        return true;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        if (users == null || users.isEmpty()) {
            users = Data_Loader.loadUsers(); // Optionally, load users again if list is empty
        }

        return users;
    }

    public boolean saveUser() {

        return true;
    }
}
