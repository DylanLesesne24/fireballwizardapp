package com.model;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Song;

public class SongTest {

    private Song song;
    private UUID testID;
    private String[] notes;

    @Before
    public void setUp() {
        testID = UUID.randomUUID();
        notes = new String[]{"C", "D", "E", "F", "G"};
        song = new Song(testID, "Test Song", "Easy", notes, 120);
    }

    // Tests that the song title is returned correctly
    //By Landen & Dylan
    @Test
    public void testGetTitle() {
        assertEquals("Test Song", song.getTitle());
    }

    // Tests that the song difficulty is returned correctly
    //By Landen & Dylan
    @Test
    public void testGetDifficulty() {
        assertEquals("Easy", song.getDifficulty());
    }

    // Tests that the song tempo is returned correctly
    // By Landen & Dylan
    @Test
    public void testGetTempo() {
        assertEquals(120, song.getTempo());
    }

    // Tests that the notes array is returned correctly
    // By Landen & Dylan
    @Test
    public void testGetNotes() {
        assertEquals(5, song.getNotes().length);
        assertEquals("C", song.getNotes()[0]);
        assertEquals("G", song.getNotes()[4]);
    }

    // Tests that the song UUID is stored and returned properly
    // By Landen & Dylan
    @Test
    public void testGetSongID() {
        assertEquals(testID, song.getSongID());
        assertNotNull(song.getSongID());
    }
}
