package com.firewizapp;

import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void handleLessons() {
        System.out.println("Navigating to Lessons...");
        // TODO: App.setRoot("lessons");
    }

    @FXML
    private void handleSongList() {
        System.out.println("Navigating to Song List...");
        // TODO: App.setRoot("songlist");
    }

    @FXML
    private void handleQuiz() {
        System.out.println("Navigating to Quiz...");
        // TODO: App.setRoot("quiz");
    }
}
