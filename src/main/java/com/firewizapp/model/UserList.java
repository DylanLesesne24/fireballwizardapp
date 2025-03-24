package com.firewizapp.model;

import java.util.ArrayList;

public class UserList {

    private static ArrayList<User> users;

    private static UserList userList;

    private UserList() {
        users = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(String username, String password, String email, Difficulty skillLevel) {
        users.add(new User(username, password, email, skillLevel));
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; 
    }

    public static ArrayList<User> getUsers()
    {
        return users;
    }

    public boolean saveUser() {
        
        return true;
    }
}
