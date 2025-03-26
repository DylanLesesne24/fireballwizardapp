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

    public static boolean saveUsers(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter)
    {
        UserList users = UserList.getInstance();

        users.addUser(firstName, lastName, username, password, email, skillLevel, filter);

        ArrayList<User> userList = UserList.getUsers();
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
    
        // Preserve existing keys from the loaded root
        Object words = root.get("words");
        Object badges = root.get("badges");
        Object progress = root.get("progress");

        // Update the users array
        root.put(USER_LIST, jsonUsers);

        // Put back the preserved keys if they exist
        if (words != null)
        {
            root.put("words", words);
        }

        if (badges != null)
        {
            root.put("badges", badges);
        }

        if (progress != null)
        {
            root.put("progress", progress);
        }

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
        userDetails.put(SKILL_LEVEL, user.getSkillLevel()); //userSkillLevel
        userDetails.put(FILTER, String.valueOf(user.getFilter())); //filter
        userDetails.put(BADGES_EARNED, convertBadgesToJSONArray(user.getBadgesEarned())); //badgesEarned
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

    public static boolean saveSongs(UUID id, String title, String difficulty, int tempo, String[] notes)
    {
        JSONArray jsonSongs = new JSONArray();

        JSONObject newSong = new JSONObject();
        newSong.put(SONG_ID, id.toString()); //id
        newSong.put(SONG_TITLE, title); //title
        newSong.put(SONG_DIFFICULTY, difficulty); //difficulty
        newSong.put(SONG_TEMPO, tempo); //tempo
        newSong.put(NOTES, new JSONArray()); //notes
    
        if (notes != null && notes.length > 0) //Add notes if they exist
        {
            JSONArray notesJSON = new JSONArray();

            for (String note : notes)
            {
                notesJSON.add(note);
            }

            newSong.put(NOTES, notesJSON);
        }
    
        JSONObject root = new JSONObject(); //Create the root JSON object that holds the "songs" key
    
        try
        {
            FileReader fileReader = new FileReader(SONGS_FILE_NAME);
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(fileReader);
    
            if (parsed instanceof JSONObject)
            {
                root = (JSONObject) parsed;
            }
            
            else
            {
                root = new JSONObject();
                root.put(SONG_LIST, parsed);
            }
        }
        catch (Exception e) 
        {
            root = new JSONObject(); //If the file doesn't exist or can't be parsed, create a new root with defaults
        }

        if (!root.containsKey(SONG_LIST)) //Ensure the root contains the "songs" array if not present
        {
            root.put(SONG_LIST, new JSONArray());
        }

        JSONArray songsArray = (JSONArray) root.get(SONG_LIST);
        songsArray.add(newSong);
    
        root.put(SONG_LIST, songsArray);
    
        //Write the updated data back to the JSON file
        String compactJson = root.toJSONString(); //Convert to string
        String prettyJson = prettyPrintJson(compactJson); //Pretty-print JSON
    
        try (FileWriter file = new FileWriter(SONGS_FILE_NAME))
        {
            file.write(prettyJson);
            file.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    
        return true;
    }
    

    /* Just commenting this out for cleanliness sake
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
    */

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

    public static void main(String[] args) {
        System.out.println("----- USER OPERATIONS -----");
        System.out.println("Loading users from JSON...");
        
        // Step 1: Load existing users from JSON
        ArrayList<User> users = Data_Loader.loadUsers();
        
        // Step 2: Print loaded users with every detail
        if (users.isEmpty()) {
            System.out.println("No users were loaded.");
        } else {
            System.out.println("Existing users in the system:");
            for (User user : users) {
                System.out.println("----- User Details -----");
                System.out.println("UserID: " + user.getUserID());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + user.getPassword());
                System.out.println("First Name: " + user.getFirstName());
                System.out.println("Last Name: " + user.getLastName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Skill Level: " + user.getSkillLevel());
                System.out.println("Filter: " + user.getFilter());
                System.out.println("Badges Earned: " + String.join(", ", user.getBadgesEarned()));
                System.out.println();
            }
        }
        
        // Step 3: Add a new dummy user with no badges initially
        System.out.println("Saving a new user...");
        String newFirstName = "John";
        String newLastName = "Doe";
        String newUsername = "NewUser123";
        String newPassword = "newPassword123";
        String newEmail = "newuser@example.com";
        String newSkillLevel = "BEGINNER"; // Example skill level/difficulty
        boolean newFilter = true;           // Set the filter option for the new user
        
        boolean userSuccess = saveUsers(newFirstName, newLastName, newUsername, newPassword, newEmail, newSkillLevel, newFilter);
        if (userSuccess) {
            System.out.println("New user saved successfully.");
        } else {
            System.out.println("Error saving the new user.");
        }
        
        // Step 4: Reload the users to verify the new user is added
        System.out.println("Reloading users after adding the new one...");
        users = Data_Loader.loadUsers();
        
        // Step 5: For testing, update John Doe's badges in the JSON file if they are empty.
        try {
            // Read the current JSON file
            FileReader fileReader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(fileReader);
            fileReader.close();
            
            // Get the "users" array
            JSONArray usersArray = (JSONArray) root.get(USER_LIST);
            for (Object obj : usersArray) {
                JSONObject userObj = (JSONObject) obj;
                String username = (String) userObj.get(USERNAME);
                if (username.equals("NewUser123")) {
                    // Check if badgesEarned is empty
                    Object badgesObj = userObj.get(BADGES_EARNED);
                    boolean empty = false;
                    if (badgesObj instanceof JSONArray) {
                        empty = ((JSONArray) badgesObj).isEmpty();
                    } else if (badgesObj instanceof String) {
                        empty = ((String) badgesObj).trim().isEmpty();
                    }
                    // If empty, update with the test badge
                    if (empty) {
                        JSONArray newBadges = new JSONArray();
                        newBadges.add("First Lesson Completed!");
                        userObj.put(BADGES_EARNED, newBadges);
                    }
                }
            }
            
            // Preserve other keys if they exist
            Object words = root.get("words");
            Object rootBadges = root.get("badges");
            Object progress = root.get("progress");
            
            // Put the preserved keys back
            if (words != null) {
                root.put("words", words);
            }
            if (rootBadges != null) {
                root.put("badges", rootBadges);
            }
            if (progress != null) {
                root.put("progress", progress);
            }
            
            // Write back the updated JSON
            FileWriter writer = new FileWriter(USER_FILE_NAME);
            writer.write(prettyPrintJson(root.toJSONString()));
            writer.flush();
            writer.close();
            
            System.out.println("Updated John Doe's badges in the JSON file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Step 6: Reload and print the final user list to verify the badge update
        System.out.println("Reloading users after updating dummy user's badges...");
        users = Data_Loader.loadUsers();
        if (users.isEmpty()) {
            System.out.println("No users were loaded.");
        } else {
            System.out.println("Final updated user list:");
            for (User user : users) {
                System.out.println("----- User Details -----");
                System.out.println("UserID: " + user.getUserID());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + user.getPassword());
                System.out.println("First Name: " + user.getFirstName());
                System.out.println("Last Name: " + user.getLastName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Skill Level: " + user.getSkillLevel());
                System.out.println("Filter: " + user.getFilter());
                System.out.println("Badges Earned: " + String.join(", ", user.getBadgesEarned()));
                System.out.println();
            }
        }
        
        // ***** SONG OPERATIONS *****
        System.out.println("----- SONG OPERATIONS -----");
        System.out.println("Loading songs from JSON...");
        
        // Step 7: Load existing songs from JSON
        ArrayList<Song> songs = Data_Loader.loadSongs();
        if (songs.isEmpty()) {
            System.out.println("No songs were loaded.");
        } else {
            System.out.println("Existing songs in the system:");
            for (Song song : songs) {
                System.out.println("----- Song Details -----");
                System.out.println("SongID: " + song.getSongID());
                System.out.println("Title: " + song.getTitle());
                System.out.println("Difficulty: " + song.getDifficulty());
                System.out.println("Tempo: " + song.getTempo());
                System.out.println("Notes: " + String.join(", ", song.getNotes()));
                System.out.println();
            }
        }
        
        // Step 8: Add a dummy song
        System.out.println("Saving a new song...");
        UUID dummySongID = UUID.randomUUID();
        String dummyTitle = "Test Song";
        String dummyDifficulty = "EASY";
        int dummyTempo = 120;
        String[] dummyNotes = new String[] { "C", "D", "E", "F" };
        
        boolean songSuccess = saveSongs(dummySongID, dummyTitle, dummyDifficulty, dummyTempo, dummyNotes);
        if (songSuccess) {
            System.out.println("Dummy song saved successfully.");
        } else {
            System.out.println("Error saving dummy song.");
        }
        
        // Step 9: Reload songs and print the final updated list
        System.out.println("Reloading songs after adding the dummy song...");
        songs = Data_Loader.loadSongs();
        if (songs.isEmpty()) {
            System.out.println("No songs were loaded.");
        } else {
            System.out.println("Final updated song list:");
            for (Song song : songs) {
                System.out.println("----- Song Details -----");
                System.out.println("SongID: " + song.getSongID());
                System.out.println("Title: " + song.getTitle());
                System.out.println("Difficulty: " + song.getDifficulty());
                System.out.println("Tempo: " + song.getTempo());
                System.out.println("Notes: " + String.join(", ", song.getNotes()));
                System.out.println();
            }
        }
    }                           
}