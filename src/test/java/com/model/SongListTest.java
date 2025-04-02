package com.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.SongList;

public class SongListTest {

    private SongList song;

    @Before
    public void setUp() {
        song = new SongList("Test Title", "Test Artist", "Beginner", "Pop", 180);
    }

    // Test constructor and getters
    //Tested by Landen Worthy Working
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Title should be 'Test Title'", "Test Title", song.getTitle());
        assertEquals("Artist should be 'Test Artist'", "Test Artist", song.getArtist());
        assertEquals("Difficulty should be 'Beginner'", "Beginner", song.getDifficultyLevel());
        assertEquals("Genre should be 'Pop'", "Pop", song.getGenre());
        assertEquals("Duration should be 180 seconds", 180, song.getDuration());
    }

    // Test setters
    //Tested by Landen Worthy Working
    @Test
    public void testSettersUpdateFields() {
        song.setTitle("New Title");
        song.setArtist("New Artist");
        song.setDifficultyLevel("Intermediate");
        song.setGenre("Rock");
        song.setDuration(240);

        assertEquals("Title should be updated", "New Title", song.getTitle());
        assertEquals("Artist should be updated", "New Artist", song.getArtist());
        assertEquals("Difficulty should be updated", "Intermediate", song.getDifficultyLevel());
        assertEquals("Genre should be updated", "Rock", song.getGenre());
        assertEquals("Duration should be updated", 240, song.getDuration());
    }

    // Test toString format
    //Tested by Landen Worthy Working
    @Test
    public void testToStringFormat() {
        String expected = "Song{title='Test Title', artist='Test Artist', difficultyLevel='Beginner', genre='Pop', duration=180}";
        assertEquals("toString() output should match", expected, song.toString());
    }

    // Test getAllSongs throws exception
    //Tested by Landen Worthy Working
    @Test(expected = UnsupportedOperationException.class)
    public void testGetAllSongsThrows() {
        song.getAllSongs();
    }

    // Test addSong throws exception
    //Tested by Landen Worthy Working
    @Test(expected = UnsupportedOperationException.class)
    public void testAddSongThrows() {
        song.addSong(null);
    }

    // Test getSong (by ID) throws exception
    //Tested by Landen Worthy Working
    @Test(expected = UnsupportedOperationException.class)
    public void testGetSongByIdThrows() {
        song.getSong(1);
    }
}
