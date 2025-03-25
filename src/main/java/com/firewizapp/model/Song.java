package com.firewizapp.model;

import java.util.HashMap;

public class Song {

    // A static repository of songs (could be populated from JSON)
    public static HashMap<Integer, Song> SONGS = new HashMap<>();

    private String title;
    private String artist;
    private String[] chords;  // New field for the chord sequence

    /**
     * Constructor that accepts title, artist, and a sequence of chords.
     *
     * @param title  The title of the song.
     * @param artist The artist of the song.
     * @param chords An array of chords representing the song.
     */
    public Song(String title, String artist, String[] chords) {
        this.title = title;
        this.artist = artist;
        this.chords = chords;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    /**
     * Returns the stored chords for the song.
     *
     * @return an array of chord strings.
     */
    public String[] getChords() {
        return chords;
    }

    public static Song getSong(int num) {
        return SONGS.get(num);
    }
}
