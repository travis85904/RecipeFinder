package com.recipefinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RecipeFinderApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RecipeFinderApplication.class.getResource("/RecipeFinder-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Baskeldo's Recipe Finder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}