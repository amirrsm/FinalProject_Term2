package Interpreter.Graphics.Controller;

import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.Blend;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import static Interpreter.Graphics.Controller.LoginPageController.getContentOfUrlConnection;

public class WaitingPageController implements Initializable {
    public ProgressIndicator progress;
    Timer timer = new Timer();
    public Button back;

    public void onBackButton(ActionEvent event) throws IOException {

        if (event.getSource().equals(back)) {
            Stage stage;
            Parent root;
            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/StartPage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            timer.cancel();
        }
    }


    public void mouseEnter(MouseEvent event) {
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.9");
        }
    }

    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.55");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String result = getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/search.php?myID=" + LoginPageController.myID);
                if (!result.equals("wait")) {
                    LoginPageController.opponentID = Integer.parseInt(result);
                    Stage stage;
                    Parent root;
                    stage = (Stage) back.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(App.class.getResource("/QuestionPage.fxml"));
                    try {
                        root = fxmlLoader.load();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    timer.cancel();
                }
            }
        }, 2000, 1000);
    }
}