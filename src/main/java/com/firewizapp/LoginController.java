package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // TODO: Replace with actual user
        if ("admin".equals(username) && "1234".equals(password)) {
            System.out.println("Login successful!");

        } else {
            System.out.println("Invalid username or password");
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
