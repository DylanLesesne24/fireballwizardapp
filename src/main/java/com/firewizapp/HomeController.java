package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Label welcomeLabel;

    // Handles "Lessons" button click event
    @FXML
    private void handleLessons() {
        System.out.println("Redirecting to Lessons...");
        try {
            App.setRoot("lessons"); // Ensure that "lessons.fxml" is present in your resources folder
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles "Song List" button click event
    @FXML
    private void goToSongList() {
        System.out.println("Redirecting to Song List...");
        try {
            App.setRoot("songlist"); // Ensure that "songlist.fxml" exists
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Placeholder method for handling "Quiz" button click event
    @FXML
    private void handleQuiz() {
        System.out.println("Redirecting to Quiz...");
        try {
            App.setRoot("quiz-view"); // Make sure quiz-view.fxml is correctly placed inside resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles logout button click event (if used in your app)
    @FXML
    private void handleLogout() {
        System.out.println("Logging out...");
        try {
            App.setRoot("loginsignup"); // Ensure the "loginsignup.fxml" exists
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handles "Back" button click (typically to return to login screen)
    @FXML
    private void handleBack() {
        System.out.println("Going back to login/signup...");
        try {
            App.setRoot("loginsignup"); // Load the login/signup screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
