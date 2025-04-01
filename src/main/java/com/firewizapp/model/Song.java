package com.firewizapp.model;

import java.util.HashMap;
import java.util.UUID;

import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class Song {

    public static HashMap<Integer, Song> SONGS = new HashMap<>();

    private UUID songID;
    private String songTitle;
    private String difficulty;
    private String[] songNotes;
    private int songTempo;

    public Song(UUID id, String title, String difficulty, String[] notes, int tempo) {
        this.songID = id;
        this.songTitle = title;
        this.difficulty = difficulty;
        this.songNotes = notes;
        this.songTempo = tempo;
    }

    public String getTitle() {
        return this.songTitle;
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

    public void playNotes() {
        Player player = new Player();
        StringBuilder pattern = new StringBuilder();

        // Add tempo to pattern (e.g., T120)
        pattern.append("T").append(songTempo).append(" ");

        // Add each note with a duration
        for (String note : songNotes) {
            pattern.append(note).append("q "); // quarter note duration
        }

        try {
            System.out.println("Pattern: " + pattern);
            player.play(new Pattern(pattern.toString().trim()));
        } catch (Exception e) {
            System.out.println("Error playing song.");
            e.printStackTrace();
        }
    }

    /*
     * Commenting out for simplicity sake
     * public static Song getSong(int num) //TODO ??????????
     * {
     * return SONGS.get(num);
     * }
     * 
     * public String[] getChords() {
     * // TODO Auto-generated method stub
     * throw new UnsupportedOperationException("Unimplemented method 'getChords'");
     * }
     */
}
