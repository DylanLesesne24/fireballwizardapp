package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void handleSignup() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirm = confirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            System.out.println("Please fill out all fields.");
            return;
        }

        if (!password.equals(confirm)) {
            System.out.println("Passwords do not match.");
            return;
        }

        // Add user to in-memory database
        UserDatabase.addUser(username, password);
        System.out.println("Sign-up successful for user: " + username);

        try {
            App.setRoot("loginsignup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack() {
        try {
            App.setRoot("loginsignup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
