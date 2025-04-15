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

        if (UserDatabase.isValidUser(username, password)) {
            System.out.println("Login successful!");

            try {
                App.setRoot("home"); // This should match your home screen FXML
            } catch (Exception e) {
                e.printStackTrace();
            }
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
