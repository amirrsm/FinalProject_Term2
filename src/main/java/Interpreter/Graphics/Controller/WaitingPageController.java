package Interpreter.Graphics.Controller;

import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
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
    String result = "0";
    Stage stage;
    Parent root;

    public void onBackButton(ActionEvent event) throws IOException {

        if (event.getSource().equals(back)) {

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

    public void refresh() {

        if (!result.equals("wait")) {
            LoginPageController.opponentID = Integer.parseInt(result);

            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            //todo change page to ChallengePage.
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
            //todo ask about myID and opponentID
            @Override
            public void run() {
                result = getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/search.php?myID=" + LoginPageController.myID);
            }
        }, 2000, 1000);
    }
}