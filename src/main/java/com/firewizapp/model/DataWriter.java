package com.firewizapp.model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends Data_Loader { //I was told that we shouldn't have any voids in data writer for testing purposes

    public static boolean saveUsers(String username, String password, String email, Difficulty skillLevel)
    {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = UserList.getUsers(); //Honestly, I'm a bit confused at this part
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i < userList.size(); i++)
        {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try(FileWriter file = new FileWriter(USER_FILE_NAME))
        {
            file.write(jsonUsers.toJSONString());
            file.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        //TODO
        return true;
    }

    public static JSONObject getUserJSON(User user)
    {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getUserID().toString()); //UUID
        userDetails.put(USERNAME, user.getUsername().toString()); //username
        userDetails.put(PASSWORD, user.getPassword().toString()); //password
        userDetails.put(FIRST_NAME, user.getFirstName().toString()); //firstName
        userDetails.put(LAST_NAME, user.getLastName().toString()); //lastName
        userDetails.put(USER_EMAIL, user.getEmail().toString()); //userEmail
        userDetails.put(SKILL_LEVEL, user.getSkillLevel().toString()); //userSkillLevel
        userDetails.put(FILTER, String.valueOf(user.getFilter())); //filter
        userDetails.put(BADGES_EARNED, String.join(", ", user.getBadgesEarned())); //badgesEarned
        //BadgesEarned and Filter are different because they are a String Array and Boolean value respectively, so they have to be treated differently

        return userDetails;
    }

    private static JSONArray convertBadgesToJSONArray(String[] badges) //Written by ChatGPT to help with the array of badges earned
    {
        JSONArray jsonArray = new JSONArray();

        for (String badge : badges)
        {
            jsonArray.add(badge);
        }

        return jsonArray;
    }

    public static boolean saveLessons()
    {
        //TODO
        return true;
    }

    public static boolean saveProgress()
    {
        //TODO
        return true;
    }

    public static boolean saveQuizzes()
    {
        //TODO
        return true;
    }

    public static void main(String[] args) {
        // Try to load users from your UserList.
        ArrayList<User> users = UserList.getUsers();
        
        // If no users are loaded, create a dummy user for testing.
        if (users == null || users.isEmpty()) {
            System.out.println("No users loaded. Creating a dummy user for testing...");
            User dummy = new User(
                UUID.randomUUID(), 
                "testUser", 
                "password123", 
                "John", 
                "Doe", 
                "john.doe@example.com", 
                "Intermediate", 
                false, 
                new String[] {"Badge1", "Badge2", "Badge3"}
            );
            users = new ArrayList<>();
            users.add(dummy);
        }
        
        // For each user, convert to JSON and print each variable.
        for (User user : users) {
            JSONObject userJSON = DataWriter.getUserJSON(user);
            System.out.println("---- User Details ----");
            System.out.println("User ID: " + userJSON.get(DataConstants.USER_ID));
            System.out.println("Username: " + userJSON.get(DataConstants.USERNAME));
            System.out.println("Password: " + userJSON.get(DataConstants.PASSWORD));
            System.out.println("First Name: " + userJSON.get(DataConstants.FIRST_NAME));
            System.out.println("Last Name: " + userJSON.get(DataConstants.LAST_NAME));
            System.out.println("Email: " + userJSON.get(DataConstants.USER_EMAIL));
            System.out.println("Skill Level: " + userJSON.get(DataConstants.SKILL_LEVEL));
            System.out.println("Filter: " + userJSON.get(DataConstants.FILTER));
            System.out.println("Badges Earned: " + userJSON.get(DataConstants.BADGES_EARNED));
            System.out.println("-----------------------\n");
        }
    }
    
}
