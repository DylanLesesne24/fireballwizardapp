package com.firewizapp;

import com.firewizapp.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.UUID;

public class SongListController {

    @FXML
    private ListView<Song> songListView;

    @FXML
    private ImageView backArrow;

    private ObservableList<Song> songs;

    @FXML
    public void initialize() {
        // Sample data
        songs = FXCollections.observableArrayList(
                new Song(UUID.randomUUID(), "Fur Elise", "Beethoven", "Intermediate",
                        new String[] { "E5", "D#5", "E5", "D#5", "E5", "B4", "D5", "C5", "A4" }, 100),
                new Song(UUID.randomUUID(), "Twinkle Twinkle Little Star", "Traditional", "Beginner",
                        new String[] { "C4", "C4", "G4", "G4", "A4", "A4", "G4" }, 80),
                new Song(UUID.randomUUID(), "Moonlight Sonata", "Beethoven", "Advanced",
                        new String[] { "C#4", "E4", "G#4", "C#5", "E5", "G#5" }, 60));

        // Populate the ListView
        songListView.setItems(songs);
        songListView.setFixedCellSize(90);
        songListView.setPrefHeight(songs.size() * 90);

        songListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Song song, boolean empty) {
                super.updateItem(song, empty);
                if (empty || song == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("SongCell.fxml"));
                        HBox cellRoot = loader.load();

                        SongCellController controller = loader.getController();
                        controller.setSong(song);

                        setGraphic(cellRoot);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        songListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Song selected = songListView.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    try {
                        SongDetailsController.selectedSong = selected;
                        App.setRoot("songdetails");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
