package com.example.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        // Load the first scene (welcome-view.fxml)
        loadScene("welcome-view.fxml");

        stage.setTitle("Student Management System");
        stage.setResizable(false);
        stage.show();
    }

    // Load and switch scenes dynamically
    public void loadScene(String fxmlFile) throws IOException {
        loader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load(), 600, 400);
        primaryStage.setScene(scene);

        // Get the controller and initialize accordingly
        HelloController controller = loader.getController();

        // Decide which scene you are loading and initialize the right one
        if (fxmlFile.equals("hello-view.fxml")) {
            controller.initializeStudentTable();
        } else if (fxmlFile.equals("welcome-view.fxml")) {
            return;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
