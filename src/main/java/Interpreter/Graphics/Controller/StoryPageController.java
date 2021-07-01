package Interpreter.Graphics.Controller;

import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoryPageController implements Initializable {
    public Button stage1;
    public Button stage2;
    public Button stage3;
    public Button stage4;
    public Button stage5;
    public Button stage6;
    public Button stage7;
    public Button stage8;
    public Button stage9;
    public Button back;
    public static int stageSelected = 1;

    public void onStoryButtons(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (!event.getSource().equals(back)) {
            if (event.getSource().equals(stage1)) {
                stageSelected = 1;
            }
            if (event.getSource().equals(stage2)) {
                stageSelected = 2;
            }
            if (event.getSource().equals(stage3)) {
                stageSelected = 3;
            }
            if (event.getSource().equals(stage4)) {
                stageSelected = 4;
            }
            if (event.getSource().equals(stage5)) {
                stageSelected = 5;
            }
            if (event.getSource().equals(stage6)) {
                stageSelected = 6;
            }
            if (event.getSource().equals(stage7)) {
                stageSelected = 7;
            }
            if (event.getSource().equals(stage8)) {
                stageSelected = 8;
            }
            if (event.getSource().equals(stage9)) {
                stageSelected = 9;
            }
            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/QuestionPage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource().equals(back)) {
            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/StartPage.fxml"));
            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void mouseEnter(MouseEvent event) {
        if (event.getSource().equals(stage1)) {
            stage1.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage2)) {
            stage2.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage3)) {
            stage3.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage4)) {
            stage4.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage5)) {
            stage5.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage6)) {
            stage6.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage7)) {
            stage7.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage8)) {
            stage8.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(stage9)) {
            stage9.setStyle("-fx-opacity: 0.9");
        }
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.9");
        }
    }

    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(stage1)) {
            stage1.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage2)) {
            stage2.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage3)) {
            stage3.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage4)) {
            stage4.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage5)) {
            stage5.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage6)) {
            stage6.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage7)) {
            stage7.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage8)) {
            stage8.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(stage9)) {
            stage9.setStyle("-fx-opacity: 0.65");
        }
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.55");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
