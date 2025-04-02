package com.firewizapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.UUID;

public class SongTest {

    private Song song;

    @Before
    public void setUp() {
        // Sample data for the Song object
        UUID songID = UUID.randomUUID();
        String songTitle = "Test Song";
        String difficulty = "Medium";
        String[] songNotes = {"C4", "E4", "G4", "C5"};
        int songTempo = 120;

        // Initialize the Song object
        song = new Song(songID, songTitle, difficulty, songNotes, songTempo);
    }

    // Constructor Test for Song
    @Test
    public void testSongConstructor() {
        assertNotNull("Song object should be initialized", song);
    }

    // Test for getting the song title
    @Test
    public void testGetTitle() {
        assertEquals("Song title should match", "Test Song", song.getTitle());
    }

    // Test for getting the song difficulty
    @Test
    public void testGetDifficulty() {
        assertEquals("Song difficulty should match", "Medium", song.getDifficulty());
    }

    // Test for getting the song tempo
    @Test
    public void testGetTempo() {
        assertEquals("Song tempo should match", 120, song.getTempo());
    }

    // Test for getting the song notes
    @Test
    public void testGetNotes() {
        String[] expectedNotes = {"C4", "E4", "G4", "C5"};
        assertArrayEquals("Song notes should match", expectedNotes, song.getNotes());
    }

    // Test for the song's UUID
    @Test
    public void testGetSongID() {
        assertNotNull("Song ID should not be null", song.getSongID());
    }

    // Test for playNotes method (no direct output validation, can check for errors)
    @Test
    public void testPlayNotes() {
        try {
            song.playNotes();
        } catch (Exception e) {
            fail("playNotes should not throw an exception");
        }
    }

    // Test that the SONGS HashMap is initialized
    @Test
    public void testSongsHashMapInitialization() {
        assertNotNull("SONGS map should not be null", Song.SONGS);
    }

    // Test adding a song to SONGS map (by ID)
    @Test
    public void testAddSongToMap() {
        UUID songID = song.getSongID();
        Song.SONGS.put(songID, song);  // Corrected: use songID as the key
        assertTrue("SONGS map should contain the song", Song.SONGS.containsKey(songID));
    }
}
