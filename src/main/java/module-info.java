module com.example.recipefinder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.recipefinder to javafx.fxml;
    exports com.recipefinder;

}