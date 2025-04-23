package com.firewizapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ReadingSheetMusicController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Welcome to Reading Sheet Music.");
    }

    @FXML
    private void goBackToLessons() {
        try {
            App.setRoot("lessons"); // Go back to the lessons screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
