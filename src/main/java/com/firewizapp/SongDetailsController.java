package com.firewizapp;

import com.firewizapp.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SongDetailsController {

    public static Song selectedSong;

    @FXML
    private Label titleLabel;
    @FXML
    private Label artistLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label tempoLabel;

    @FXML
    public void initialize() {
        if (selectedSong != null) {
            titleLabel.setText(selectedSong.getTitle());
            artistLabel.setText("Artist: " + selectedSong.getArtist());
            difficultyLabel.setText("Level: " + selectedSong.getDifficulty());
            tempoLabel.setText("Tempo: " + selectedSong.getTempo() + " BPM");
        }
    }

    @FXML
    private void handlePlay() {
        if (selectedSong != null) {
            selectedSong.playNotes();
        }
    }

    @FXML
    private void handleBack() {
        try {
            App.setRoot("songlist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
