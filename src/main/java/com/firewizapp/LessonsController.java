package com.firewizapp;

import javafx.fxml.FXML;

public class LessonsController {

    // Handle "Intro to Notes"
    @FXML
    private void handleIntroToNotes() {
        System.out.println("Opening Intro to Notes...");
        try {
            App.setRoot("introtonotes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle "Playing Your First Song"
    @FXML
    private void handleFirstSong() {
        System.out.println("Opening Playing Your First Song...");
        try {
            App.setRoot("playingyourfirstsong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle "Reading Sheet Music"
    @FXML
    private void handleSheetMusic() {
        System.out.println("Opening Reading Sheet Music...");
        try {
            App.setRoot("readingsheetmusic");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle the "Back to Home" b
    @FXML
    private void goBackToHome() {
        System.out.println("Going back to Home...");
        try {
            App.setRoot("homepage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
