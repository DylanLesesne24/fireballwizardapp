package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IntroToNotesController {

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        messageLabel.setText("Welcome to IntroToNotes.");
    }
}
