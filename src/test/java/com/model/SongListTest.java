package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import module.Song;
import module.SongList;

public class SongListTest {

    private SongList songList;
    private Song sampleSong;

    @Before
    public void setUp() {
        songList = new SongList();
        sampleSong = new Song(UUID.randomUUID(), "Test Song", "Test Artist", "Test User", "C D E F G",
                "Sheet Music Content");
    }

    @Test
    public void testAddSong() {
        songList.addSong(sampleSong);
        assertEquals(1, songList.getSongs().size());
        assertTrue(songList.getSongs().contains(sampleSong));
    }

    @Test
    public void testRemoveSong() {
        songList.addSong(sampleSong);
        songList.removeSong(sampleSong);
        assertEquals(0, songList.getSongs().size());
    }

    @Test
    public void testGetSongByTitle() {
        songList.addSong(sampleSong);
        Song found = songList.getSongByTitle("Test Song");
        assertNotNull(found);
        assertEquals("Test Artist", found.getArtist());
    }

    @Test
    public void testSearchByArtist() {
        songList.addSong(sampleSong);
        Song found = songList.searchByArtist("Test Artist").get(0);
        assertNotNull(found);
        assertEquals("Test Song", found.getTitle());
    }

    @Test
    public void testRemoveNonExistentSong() {
        // This should not throw or affect the list
        songList.removeSong(sampleSong);
        assertEquals(0, songList.getSongs().size());
    }

    @Test
    public void testGetSongByTitleNotFound() {
        Song result = songList.getSongByTitle("Nonexistent");
        assertNull(result);
    }
}