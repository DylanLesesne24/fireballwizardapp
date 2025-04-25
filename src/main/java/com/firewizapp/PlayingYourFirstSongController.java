package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlayingYourFirstSongController {

    @FXML
    private Button backButton;  // Reference to the Back Button in FXML

    @FXML
    public void initialize() {
        // Optional initialization logic if needed
    }

    // Handle the Back button click to navigate back to homepage.fxml
    @FXML
    public void handleBackToHome() {
        System.out.println("Back button clicked! Navigating back to homepage.fxml...");
        try {
            App.setRoot("homepage");  // Navigate back to homepage.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle the Begin Lesson button if it's needed
    @FXML
    public void handleBeginLesson() {
        System.out.println("Begin Lesson clicked! Navigating to lesson2.fxml...");
        try {
            App.setRoot("lesson2");  // Loads lesson2.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
