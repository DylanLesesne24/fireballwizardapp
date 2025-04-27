package com.firewizapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (UserDatabase.isValidUser(username, password)) {
            // Login successful
            System.out.println("Login successful!");
            try {
                App.setRoot("homepage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Invalid credentials
            showAlert("Invalid username or password", AlertType.ERROR);
        }
    }

    @FXML
    private void handleBack() {
        try {
            App.setRoot("loginsignup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to show alerts
    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
