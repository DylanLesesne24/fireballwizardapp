package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlayingYourFirstSongController {

    @FXML
    private Button backButton; // Reference to the Back Button in FXML

    @FXML
    public void initialize() {

    }

    // Handle the Back button
    @FXML
    public void handleBackToHome() {
        System.out.println("Back button clicked! Navigating back to lessons.fxml...");
        try {
            App.setRoot("lessons"); // Navigate back to lessons.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle the Begin Lesson button
    @FXML
    public void handleBeginLesson() {
        System.out.println("Begin Lesson clicked! Navigating to lesson2.fxml...");
        try {
            App.setRoot("lesson2"); // Loads lesson2.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
