package com.firewizapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController {

    @FXML
    private Label welcomeLabel;

    // Handles "Lessons" button click event
    @FXML
    private void handleLessons() {
        System.out.println("Redirecting to Lessons...");
        try {
            App.setRoot("lessons");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles "Song List" button
    @FXML
    private void goToSongList() {
        System.out.println("Redirecting to Song List...");
        try {
            App.setRoot("songlist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Placeholder method for handling "Quiz"
    @FXML
    private void handleQuiz() {
        System.out.println("Redirecting to Quiz...");
        try {
            App.setRoot("quiz-view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles logout button
    @FXML
    private void handleLogout() {
        System.out.println("Logging out...");
        try {
            App.setRoot("loginsignup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handles "Back" button
    @FXML
    private void handleBack() {
        System.out.println("Going back to login/signup...");
        try {
            App.setRoot("loginsignup"); // Load the login/signup screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePractice(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/firewizapp/practice.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
