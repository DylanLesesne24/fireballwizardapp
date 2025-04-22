package com.firewizapp;

import javafx.fxml.FXML;

public class LessonsController {

    // Handle "Intro to Notes" button click
    @FXML
    private void handleIntroToNotes() {
        System.out.println("Opening Intro to Notes...");
        // Implement logic to show the Intro to Notes content
        // You can load another screen, display a pop-up, or anything else
    }

    // Handle "Playing Your First Song" button click
    @FXML
    private void handleFirstSong() {
        System.out.println("Opening Playing Your First Song...");
        // Implement logic to show Playing Your First Song content
    }

    // Handle "Reading Sheet Music" button click
    @FXML
    private void handleSheetMusic() {
        System.out.println("Opening Reading Sheet Music...");
        // Implement logic to show Reading Sheet Music content
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
