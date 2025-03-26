package com.firewizapp.model;

import java.util.ArrayList;
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
            JSONParser parser = new JSONParser(); // Parse the file as a JSONObject since your file contains multiple keys
            JSONObject root = (JSONObject)parser.parse(fileReader); // Extract the "users" array from the root object
            JSONArray peopleJSON = (JSONArray)root.get(USER_LIST);

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
                
                String filterStr = (String) personJSON.get(FILTER);
                boolean filter = Boolean.parseBoolean(filterStr);

                Object badgesObj = personJSON.get(BADGES_EARNED);
                String[] badgesEarned;
                if (badgesObj instanceof JSONArray) 
                {
                    JSONArray badgesJSON = (JSONArray) badgesObj;
                    badgesEarned = new String[badgesJSON.size()];
                    
                    for (int j = 0; j < badgesJSON.size(); j++)
                    {
                        badgesEarned[j] = (String) badgesJSON.get(j);
                    }
                }
                
                else if (badgesObj instanceof String)
                {
                    badgesEarned = ((String) badgesObj).split(",\\s*");
                }
                
                else
                {
                    badgesEarned = new String[0];
                }

                users.add(new User(id, username, password, firstName, lastName, userEmail, userSkillLevel, filter, badgesEarned));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Song> loadSongs()
    {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader fileReader = new FileReader(SONGS_FILE_NAME);
            JSONParser parser = new JSONParser(); // Parse the file as a JSONObject since your file contains multiple keys
            JSONObject root = (JSONObject)parser.parse(fileReader); // Extract the "users" array from the root object
            JSONArray songsJSON = (JSONArray)root.get(SONG_LIST);

            for(int i = 0; i < songsJSON.size(); i++)
            {
                JSONObject songJSON = (JSONObject)songsJSON.get(i);
                UUID id = UUID.fromString((String)songJSON.get(SONG_ID));
                String title = ((String)songJSON.get(SONG_TITLE));
                String difficulty = ((String)songJSON.get(SONG_DIFFICULTY));
                
                Object tempoObj = songJSON.get(SONG_TEMPO);
                int tempo;

                if(tempoObj instanceof Long)
                {
                    tempo = ((Long)tempoObj).intValue();
                }
                
                else if(tempoObj instanceof String) 
                {
                    tempo = Integer.parseInt((String) tempoObj);
                }
                
                else
                {
                    tempo = 0; // or handle error
                }

                JSONArray notesJSON = (JSONArray)songJSON.get(NOTES);
                String[] notes = new String[notesJSON.size()];
                for (int j = 0; j < notesJSON.size(); j++)
                {
                    notes[j] = (String)notesJSON.get(j);
                }

                songs.add(new Song(id, title, difficulty, notes, tempo));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}