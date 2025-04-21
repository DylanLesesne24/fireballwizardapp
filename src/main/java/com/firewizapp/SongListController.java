package com.firewizapp;

import com.firewizapp.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.UUID;

public class SongListController {

    @FXML
    private ListView<Song> songListView;

    @FXML
    public void initialize() {
        // Create sample songs using your new Song class
        ObservableList<Song> songs = FXCollections.observableArrayList(
                new Song(UUID.randomUUID(), "Fur Elise", "Beethoven", "Intermediate",
                        new String[] { "E5", "D#5", "E5", "D#5", "E5", "B4", "D5", "C5", "A4" }, 100),

                new Song(UUID.randomUUID(), "Twinkle Twinkle Little Star", "Traditional", "Beginner",
                        new String[] { "C4", "C4", "G4", "G4", "A4", "A4", "G4" }, 80),

                new Song(UUID.randomUUID(), "Moonlight Sonata", "Beethoven", "Advanced",
                        new String[] { "C#4", "E4", "G#4", "C#5", "E5", "G#5" }, 60));

        songListView.setItems(songs);
        songListView.setFixedCellSize(80); // approximate height per song cell
        songListView.setPrefHeight(songs.size() * 80); // only show visible rows

        songListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Song song, boolean empty) {
                super.updateItem(song, empty);
                if (empty || song == null) {
                    setText(null);
                } else {
                    setText(song.getTitle() + "\n" +
                            "Artist: " + song.getArtist() + "   |   " +
                            "Level: " + song.getDifficulty());
                    setStyle(
                            "-fx-padding: 10; -fx-font-size: 14px; -fx-background-color: #ffffff; -fx-background-radius: 10; -fx-border-color: #ccc;");
                }
            }
        });
    }

    @FXML
    private void handleBack(MouseEvent event) {
        try {
            App.setRoot("homepage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
