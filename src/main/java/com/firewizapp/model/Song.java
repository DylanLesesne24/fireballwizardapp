package com.firewizapp.model;

import java.util.HashMap;

public class Song {

    public static HashMap<Integer, Song> SONGS = new HashMap<>();

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public static Song getSong(int num) {
        return SONGS.get(num); 
    }
}
