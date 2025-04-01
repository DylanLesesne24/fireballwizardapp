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

    /**
     * Constructs a new {@code Song} object with the specified details.
     *
     * @param id         The UUID of the song
     * @param title      The title of the song
     * @param difficulty The difficulty level (e.g., "Easy", "Medium", "Hard")
     * @param notes      An array of musical notes representing the song
     * @param tempo      The tempo (beats per minute) of the song
     */

    public Song(UUID id, String title, String difficulty, String[] notes, int tempo) {
        this.songID = id;
        this.songTitle = title;
        this.difficulty = difficulty;
        this.songNotes = notes;
        this.songTempo = tempo;
    }

    /* Returns Ttile of the Song */
    public String getTitle() {
        return this.songTitle;
    }

    /* Returns Difficulty of the Song */
    public String getDifficulty() {
        return this.difficulty;
    }

    /* Returns Tempo of the Song */
    public int getTempo() {
        return this.songTempo;
    }

    /* Returns Notes of the Song */
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
