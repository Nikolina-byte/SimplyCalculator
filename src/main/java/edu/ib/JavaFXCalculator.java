package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The class that creates the application window.
 * @author Nikolina Czart
 */

public class JavaFXCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/calculator.fxml"));
        Scene scene= new Scene(root,400,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
