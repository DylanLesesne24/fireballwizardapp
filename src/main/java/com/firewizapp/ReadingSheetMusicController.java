package com.firewizapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ReadingSheetMusicController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Welcome to Reading Sheet Music.");
    }

    @FXML
    private void handleBeginLesson() {
        System.out.println("Begin Lesson button clicked for Reading Sheet Music.");
        try {
            App.setRoot("lesson3"); // Navigates to lesson3.fxml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBackToLessons() {
        try {
            App.setRoot("homepage"); // Go back to the home screen
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
