package com.firewizapp.model;

import java.util.ArrayList;

public class SongList {
    private String title;
    private String artist;
    private String difficultyLevel;
    private String genre;
    private int duration; // Duration in seconds

    /**
     *
     * @param title           The title of the song.
     * @param artist          The artist of the song.
     * @param difficultyLevel The difficulty level (e.g., "Beginner",
     *                        "Intermediate", "Advanced").
     * @param genre           The genre of the song (e.g., "Rock", "Jazz",
     *                        "Classical").
     * @param duration        The duration of the song in seconds.
     */
    public SongList(String title, String artist, String difficultyLevel, String genre, int duration) {
        this.title = title;
        this.artist = artist;
        this.difficultyLevel = difficultyLevel;
        this.genre = genre;
        this.duration = duration;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }

    public ArrayList<Song> getAllSongs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSongs'");
    }

    public void addSong(Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSong'");
    }

    public static SongList getInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
    }

    public Song getSong(int songID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSong'");
    }
}
