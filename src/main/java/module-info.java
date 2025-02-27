module com.firewizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;

    opens com.firewizapp to javafx.fxml;
    exports com.firewizapp;

    opens com.firewizapp.model to javafx.fxml;
    exports com.firewizapp.model;
}
