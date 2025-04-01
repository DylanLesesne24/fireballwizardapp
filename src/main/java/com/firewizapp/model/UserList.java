package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {

    private static ArrayList<User> users;

    private static UserList userList;

    private User currentLoginAttemptUser = null;

    private UserList()
    {
        users = Data_Loader.loadUsers(); // This is for data loader and writer, this is creating the starting list of
                                         // users that are read from the json file
    }

    public static UserList getInstance()
    {
        if (userList == null)
        {
            userList = new UserList();
        }

        return userList;
    }

    public boolean addUser(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter)
    {
        users.add(new User(UUID.randomUUID(), username, password, firstName, lastName, email, skillLevel, filter, new String[] {}));

        return true;
    }

    //For returning a single user
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    //For returning all users
    public static ArrayList<User> getUsers()
    {
        if (users == null || users.isEmpty())
        {
            users = Data_Loader.loadUsers(); // Optionally, load users again if list is empty
        }

        return users;
    }

    /* Ultimately useless, I think these are better implemented in User, just leaving them here for keeping track of all we did
    public boolean checkUsername(String inputUsername) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(inputUsername)) {
                currentLoginAttemptUser = user;
                return true;
            }
        }

        currentLoginAttemptUser = null;
        return false;
    }

    public boolean checkPassword(String inputPassword) {
        if (currentLoginAttemptUser == null) {
            return false;
        }

        return currentLoginAttemptUser.getPassword().equals(inputPassword);
    }
    */
}
