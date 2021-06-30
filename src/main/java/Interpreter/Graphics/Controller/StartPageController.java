package Interpreter.Graphics.Controller;

import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    public Button compile;
    @FXML
    public Button story;
    @FXML
    public Button online;
    @FXML
    public Button exit;

    @FXML
    private void onStartButtons(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource().equals(compile)) {
            stage = (Stage) compile.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/CompilePage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(story)) {
            stage = (Stage) story.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/StoryPage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        if (event.getSource().equals(online)) {
            stage = (Stage) story.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/OnlinePage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(exit)) {
            System.exit(0);
        }
    }

    @FXML
    public void mouseEnter(MouseEvent event) {
        if (event.getSource().equals(compile)) {
            compile.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(story)) {
            story.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(online)) {
            online.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(exit)) {
            exit.setStyle("-fx-opacity: 0.9");
        }
    }

    @FXML
    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(compile)) {
            compile.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(story)) {
            story.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(online)) {
            online.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(exit)) {
            exit.setStyle("-fx-opacity: 0.65");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
