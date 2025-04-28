package com.firewizapp;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class PracticeController {

    @FXML
    private void handleC() {
        System.out.println("C key clicked!");
    }

    @FXML
    private void handleD() {
        System.out.println("D key clicked!");
    }

    @FXML
    private void handleE() {
        System.out.println("E key clicked!");
    }

    @FXML
    private void handleF() {
        System.out.println("F key clicked!");
    }

    @FXML
    private void handleG() {
        System.out.println("G key clicked!");
    }

    @FXML
    private void handleA() {
        System.out.println("A key clicked!");
    }

    @FXML
    private void handleB() {
        System.out.println("B key clicked!");
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/firewizapp/homepage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
