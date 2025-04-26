package com.firewizapp.model;

import java.util.HashMap;
import java.util.UUID;

import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class Song {

    // Static map to store all songs by UUID
    public static HashMap<UUID, Song> SONGS = new HashMap<>();

    private UUID songID;
    private String songTitle;
    private String artist;
    private String difficulty;
    private String[] songNotes;
    private int songTempo;

    /**
     * Constructs a new {@code Song} object with the specified details.
     *
     * @param id         The UUID of the song
     * @param title      The title of the song
     * @param artist     The artist/composer of the song
     * @param difficulty The difficulty level (e.g., "Easy", "Medium", "Hard")
     * @param notes      An array of musical notes representing the song
     * @param tempo      The tempo (beats per minute) of the song
     */
    public Song(UUID id, String title, String artist, String difficulty, String[] notes, int tempo) {
        this.songID = id;
        this.songTitle = title;
        this.artist = artist;
        this.difficulty = difficulty;
        this.songNotes = notes;
        this.songTempo = tempo;
    }

    /**
     * Alternative constructor without difficulty for loading simple song data.
     *
     * @param id     The UUID of the song
     * @param title  The title of the song
     * @param artist The artist/composer of the song
     * @param notes  An array of musical notes
     * @param tempo  The tempo (beats per minute) of the song
     */
    public Song(UUID id, String title, String artist, String[] notes, int tempo) {
        this.songID = id;
        this.songTitle = title;
        this.artist = artist;
        this.songNotes = notes;
        this.songTempo = tempo;
        this.difficulty = "Unknown"; // Default if not specified
    }

    public String getTitle() {
        return this.songTitle;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public int getTempo() {
        return this.songTempo;
    }

    public String[] getNotes() {
        return this.songNotes;
    }

    public UUID getSongID() {
        return this.songID;
    }

    /**
     * Plays the song's notes using JFugue.
     */
    public void playNotes() {
        Player player = new Player();
        StringBuilder pattern = new StringBuilder();

        // Add tempo to pattern (e.g., T120)
        pattern.append("T").append(songTempo).append(" ");

        // Add each note with a duration
        for (String note : songNotes) {
            pattern.append(note).append("q "); // quarter note
        }

        try {
            System.out.println("Playing pattern: " + pattern);
            player.play(new Pattern(pattern.toString().trim()));
        } catch (Exception e) {
            System.out.println("Error playing song.");
            e.printStackTrace();
        }
    }
}
