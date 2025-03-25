package com.firewizapp.model;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

        // Create a JSONObject to hold the entire file content.
        JSONObject root = new JSONObject();

        try 
        {
            // Attempt to load the existing file.
            FileReader fileReader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(fileReader);
        
            if (parsed instanceof JSONObject) 
            {
                root = (JSONObject) parsed; // Existing root with multiple keys.
            } 
            
            else
            {
                // If the file is just an array, create a new root and set default values.
                root = new JSONObject();
                root.put(USER_LIST, parsed);
            }
        } 
        catch (Exception e) 
        {
            // If the file doesn't exist or can't be parsed, create a new root with defaults.
            root = new JSONObject();
        }

        // Ensure that the root has the keys "words", "badges", and "progress".
        // If they don't exist, set them to empty arrays.
        if(!root.containsKey("words")) 
        {
            root.put("words", new JSONArray());
        }

        if(!root.containsKey("badges"))
        {
            root.put("badges", new JSONArray());
        }

        if (!root.containsKey("progress"))
        {
            root.put("progress", new JSONArray());
        }
    
        JSONArray mergedUsers = new JSONArray();
        if (root.containsKey(USER_LIST))
        {
            Object existing = root.get(USER_LIST);
            if (existing instanceof JSONArray)
            {
                mergedUsers.addAll((JSONArray) existing);
            }
        }
        mergedUsers.addAll(jsonUsers);
    
        // Update the "users" key with the merged array.
        root.put(USER_LIST, mergedUsers);
        
        String compactJson = root.toJSONString();// Convert the JSON array to a compact string (JSON-simple's default)
        String prettyJson = prettyPrintJson(compactJson); // Then pretty-print it manually

        try(FileWriter file = new FileWriter(USER_FILE_NAME))
        {
            file.write(prettyJson);
            file.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
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

    //Written by ChatGPT
    private static String prettyPrintJson(String jsonString) { //THIS IS ONLY HERE TO MAKE WRITING TO THE JSON FILE CLEANER AND EASIER TO UNDERSTAND, LEMME TELL YOU TRY READING A SINGLE LINED ENTIRE JSON FILE
        StringBuilder result = new StringBuilder();
        int indentLevel = 0;
        boolean inQuotes = false;
    
        for (int i = 0; i < jsonString.length(); i++) {
            char c = jsonString.charAt(i);
    
            // Toggle inQuotes when we see an unescaped "
            if (c == '"' && (i == 0 || jsonString.charAt(i - 1) != '\\')) {
                inQuotes = !inQuotes;
            }
    
            // If we’re inside quotes, just append the character
            if (inQuotes) {
                result.append(c);
                continue;
            }
    
            switch (c) {
                case '{':
                case '[':
                    result.append(c);
                    result.append("\n");
                    indentLevel++;
                    result.append(getIndentString(indentLevel));
                    break;
                case '}':
                case ']':
                    result.append("\n");
                    indentLevel--;
                    result.append(getIndentString(indentLevel));
                    result.append(c);
                    break;
                case ',':
                    result.append(c);
                    result.append("\n");
                    result.append(getIndentString(indentLevel));
                    break;
                case ':':
                    result.append(": ");
                    break;
                default:
                    result.append(c);
                    break;
            }
        }
        return result.toString();
    }
    
    //Written by ChatGPT, AGAIN ONLY HERE TO HELP
    private static String getIndentString(int level) {// Helper to create the indentation (e.g., 4 spaces per level)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("    "); // 4 spaces
        }
        return sb.toString();
    }

    public static void main(String[] args) 
    {
        System.out.println("Loading songs from JSON...");

        ArrayList<Song> songs = Data_Loader.loadSongs();

        if (songs.isEmpty()) {
            System.out.println("No songs were loaded.");
        } else {
            for (Song song : songs) {
                // Get song details
                String title = song.getTitle();
                String difficulty = song.getDifficulty();
                int tempo = song.getTempo(); // Assuming you added a getter for tempo
                String[] notes = song.getNotes(); // Assuming you added a getter for notes

                // Print the song details including tempo and notes
                System.out.println("Title: " + title + ", Difficulty: " + difficulty);
                System.out.println("Tempo: " + tempo);
                System.out.print("Notes: ");
                if (notes != null && notes.length > 0) {
                    for (String note : notes) {
                        System.out.print(note + " ");
                    }
                }
                System.out.println("\n"); // Adds a line break after each song
            }
        }
    }
}