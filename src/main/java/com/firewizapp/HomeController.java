package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Label welcomeLabel; // Optional: you can remove this if not in your FXML

    @FXML
    private void handleLessons() {
        System.out.println("Redirecting to Lessons...");
        // TODO: Load lessons screen if needed later
    }

    @FXML
    private void handleSongList() {
        System.out.println("Redirecting to SongList...");
        // TODO: Load song list screen if needed later
    }

    @FXML
    private void handleQuiz() {
        System.out.println("Redirecting to Quiz...");
        // TODO: Load quiz screen if needed later
    }

    // You can optionally add a logout button too, if your UI will use it
    @FXML
    private void handleLogout() {
        try {
            App.setRoot("loginsignup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
