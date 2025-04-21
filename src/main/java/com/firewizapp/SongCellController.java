package com.firewizapp;

import com.firewizapp.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SongCellController {

    @FXML
    private Label titleLabel;
    @FXML
    private Label subtitleLabel;
    @FXML
    private Button playButton;

    public void setSong(Song song) {
        titleLabel.setText(song.getTitle());
        subtitleLabel.setText("Artist: " + song.getArtist() + " | Level: " + song.getDifficulty());

        playButton.setOnAction(e -> song.playNotes());
    }
}
