package com.firewizapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Data_Loader extends DataConstants{

    public static ArrayList<User> loadUsers()
    {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader fileReader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(fileReader);

            for(int i = 0; i < peopleJSON.size(); i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String username = ((String)personJSON.get(USERNAME));
                String password = ((String)personJSON.get(PASSWORD));
                String firstName = ((String)personJSON.get(FIRST_NAME));
                String lastName = ((String)personJSON.get(LAST_NAME));
                String userEmail = ((String)personJSON.get(USER_EMAIL));
                String userSkillLevel = ((String)personJSON.get(SKILL_LEVEL));
                boolean filter = ((boolean)personJSON.get(FILTER));
                String[] badgesEarned = ((String[])personJSON.get(BADGES_EARNED));

                users.add(new User(id, username, password, firstName, lastName, userEmail, userSkillLevel, filter, badgesEarned));

            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // TODO
    }

    public static HashMap<UUID, Lessons> loadLessons()
    {
        return new HashMap<>(); // TODO
    }

    public static HashMap<UUID, ProgressTracker> loadProgress()
    {
        return new HashMap<>(); // TODO
    }

    public staticHashMap<UUID, Quiz> loadQuizzes() {
        return new HashMap<>(); // TODO
    }
}
