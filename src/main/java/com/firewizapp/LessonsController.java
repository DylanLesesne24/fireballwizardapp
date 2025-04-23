package com.firewizapp;

import javafx.fxml.FXML;

public class LessonsController {

    // Handle "Intro to Notes" button click
    @FXML
    private void handleIntroToNotes() {
        System.out.println("Opening Intro to Notes...");
        try {
            App.setRoot("introtonotes"); // Load the introtonotes.fxml screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle "Playing Your First Song" button click
    @FXML
    private void handleFirstSong() {
        System.out.println("Opening Playing Your First Song...");
        try {
            App.setRoot("playingyourfirstsong"); // Load playingyourfirstsong.fxml
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle "Reading Sheet Music" button click
    @FXML
    private void handleSheetMusic() {
        System.out.println("Opening Reading Sheet Music...");
        try {
            App.setRoot("readingsheetmusic"); // Load readingsheetmusic.fxml
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle the "Back to Home" button click
    @FXML
    private void goBackToHome() {
        System.out.println("Going back to Home...");
        try {
            App.setRoot("home"); // Redirects back to the home screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
