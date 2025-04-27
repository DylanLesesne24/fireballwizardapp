package com.firewizapp;

import java.io.IOException;
import java.net.URL;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Load the login/signup screen first
        scene = new Scene(loadFXML("loginsignup"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Fireball Wizard Music");
        stage.show();
    }

    // Used to switch between screens like "login" or "home"
    public static void setRoot(String fxml) throws IOException {
        Parent root = loadFXML(fxml);

        // Create a fade-out transition on the current scene root
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), scene.getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(event -> {
            // After fading out, switch root
            scene.setRoot(root);

            // Then fade in the new scene
            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), root);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        fadeOut.play();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String fxmlFile = fxml + ".fxml";
        URL resource = App.class.getResource(fxmlFile);
        System.out.println("Attempting to load FXML: " + fxmlFile + " from URL: " + resource);

        if (resource == null) {
            throw new IOException(
                    "FXML file not found: " + fxmlFile + ". Make sure it is in the resources/com/firewizapp/ folder.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
