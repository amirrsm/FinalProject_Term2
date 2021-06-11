package Interpreter.Graphics;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    static Pane startPage = null;
    static Scene scene = null;

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader firstFXML = new FXMLLoader();
        firstFXML.setLocation(App.class.getResource("StartPage.fxml"));
        try {
            startPage = firstFXML.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (startPage != null) {
            scene = new Scene(startPage);
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}