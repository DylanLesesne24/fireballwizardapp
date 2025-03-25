package com.firewizapp.music;

import com.firewizapp.model.Song;
import org.jfugue.player.Player;

public class MusicPlayer {

    private Player player;

    public MusicPlayer() {
        // Create a single JFugue Player instance for playback.
        player = new Player();
    }

    /**
     * Plays the given song by iterating through its chord sequence.
     *
     * @param song The Song object containing the chords.
     */
    public void playSong(Song song) {
        String[] chords = song.getChords();
        if (chords == null || chords.length == 0) {
            System.out.println("No chords available to play for this song.");
            return;
        }
        System.out.println("Now playing: " + song.getTitle() + " by " + song.getArtist());
        for (String chord : chords) {
            System.out.println("Playing chord: " + chord);
            player.play(chord);  // JFugue plays the chord
            try {
                Thread.sleep(500); // Delay between chords for clarity (adjust as needed)
            } catch (InterruptedException e) {
                System.err.println("Playback interrupted: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Sample usage: create a sample song and play it.
        String[] sampleChords = {"Cmaj", "Gmaj", "Am", "Fmaj"};
        Song sampleSong = new Song("Sample Song", "Sample Artist", sampleChords);
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playSong(sampleSong);
    }
}

