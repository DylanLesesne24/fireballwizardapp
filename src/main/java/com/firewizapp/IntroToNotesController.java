package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroToNotesController {

    @FXML
    private Button backButton; // Reference to the Back Button in FXML

    @FXML
    public void initialize() {

    }

    // Handle the Back button
    @FXML
    public void handleBackToHome() {
        System.out.println("Back button clicked! Navigating back to homepage.fxml...");
        try {
            App.setRoot("homepage"); // Navigate back to homepage.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle the Begin Lesson button
    @FXML
    public void handleBeginLesson() {
        System.out.println("Begin Lesson clicked! Navigating to lesson1.fxml...");
        try {
            App.setRoot("lesson1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
