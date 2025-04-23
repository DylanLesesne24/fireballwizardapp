package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroToNotesController {

    @FXML
    private Button beginLessonButton;  // Referenced from FXML for handling button clicks

    // No need to modify any labels during initialization now
    @FXML
    public void initialize() {
        // You can use this space for future setup logic if needed
    }

    // Handle the Begin Lesson button click
    @FXML
    public void handleBeginLesson() {
        System.out.println("Begin Lesson clicked!");
        // Add logic here to transition to the actual lesson content when ready
    }
}
