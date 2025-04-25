package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroToNotesController {

    @FXML
    private Button beginLessonButton;

    @FXML
    public void initialize() {
        // Optional initialization logic
    }

    @FXML
    public void handleBeginLesson() {
        System.out.println("Begin Lesson clicked! Navigating to lesson1.fxml...");
        try {
            App.setRoot("lesson1"); // Loads lesson1.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
