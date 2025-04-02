package com.model;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Data_Loader;
import com.firewizapp.model.Song;
import com.firewizapp.model.User;

public class Data_LoaderTest {

    
    private ArrayList<User> users;
    private ArrayList<Song> songs;

    @Before
    public void setUp() {
        users = Data_Loader.loadUsers();
        songs = Data_Loader.loadSongs();
    }

    // Test that user list loads without being null or empty
    //Test by Landen Worthy, Working
    @Test
    public void testLoadUsersNotEmpty() {
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    // Test that first user contains expected non-null fields
    //Test by Landen Worthy, Working
    @Test
    public void testFirstUserFields() {
        User user = users.get(0);
        assertNotNull(user.getUserID());
        assertNotNull(user.getUsername());
        assertNotNull(user.getPassword());
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getEmail());
        assertNotNull(user.getSkillLevel());
        assertNotNull(user.getBadgesEarned());
    }

    // Test that song list loads without being null or empty
    //Tested by Landen Worthy, Working
    @Test
    public void testLoadSongsNotEmpty() {
        assertNotNull(songs);
        assertTrue(songs.size() > 0);
    }

    // Test that first song contains valid fields
    //Tested by Landen Worthy, Working
    @Test
    public void testFirstSongFields() {
        Song song = songs.get(0);
        assertNotNull(song.getSongID());
        assertNotNull(song.getTitle());
        assertNotNull(song.getDifficulty());
        assertTrue(song.getTempo() > 0);
        assertNotNull(song.getNotes());
        assertTrue(song.getNotes().length > 0);
    }
}
    
