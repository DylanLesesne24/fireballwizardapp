package com.firewizapp;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage currentStage;

    @Override
    public void start(Stage stage) throws IOException {
        currentStage = stage;  // Store the main stage for future reference (e.g., for fullscreen)
        
        // Load the login/signup screen first
        scene = new Scene(loadFXML("loginsignup"), 640, 480); // Start screen (login/signup)
        stage.setScene(scene);
        stage.setTitle("Fireball Wizard Music");
        stage.show();
    }

    // Used to switch between screens (e.g., "home", "lessons", "loginsignup")
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml)); // Load the FXML file corresponding to the screen
    }

    // Additional method to manage full-screen view (if needed)
    public static void setFullScreen(boolean isFullScreen) {
        currentStage.setFullScreen(isFullScreen);
    }

    // Used to load FXML files dynamically based on the provided file name
    private static Parent loadFXML(String fxml) throws IOException {
        String fxmlFile = fxml + ".fxml";
        URL resource = App.class.getResource(fxmlFile); // Get the resource URL for the FXML

        System.out.println("Attempting to load FXML: " + fxmlFile + " from URL: " + resource);

        if (resource == null) {
            throw new IOException("FXML file not found: " + fxmlFile + ". Make sure it is in the resources/com/firewizapp/ folder.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(resource); // Load the FXML
        return fxmlLoader.load();
    }

    // This method can be used to load the home screen
    public static void loadHomeScreen() throws IOException {
        setRoot("home");
    }

    // This method can be used to load the lessons screen
    public static void loadLessonsScreen() throws IOException {
        setRoot("lessons");
    }

    // You can call this method to navigate back to the login/signup screen
    public static void loadLoginSignupScreen() throws IOException {
        setRoot("loginsignup");
    }

    // Main entry point for the application
    public static void main(String[] args) {
        launch(); // Launch the application
    }
}
