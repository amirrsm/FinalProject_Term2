package Interpreter.Graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    static Pane startPage = null;
    static Scene scene = null;

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader firstFXML = new FXMLLoader();
        firstFXML.setLocation(App.class.getResource("CompilePage.fxml"));
        try {
            startPage = firstFXML.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (startPage != null) {
            scene = new Scene(startPage);
        }

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}