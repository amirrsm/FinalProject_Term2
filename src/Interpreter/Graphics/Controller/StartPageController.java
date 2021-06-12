package Interpreter.Graphics.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    public Button compile;
    @FXML
    public Button story;
    @FXML
    public Button setting;
    @FXML
    public Button exit;

    @FXML
    private void onStartButtons(ActionEvent event) {
        if (event.getSource().equals(compile)){

        }

        if (event.getSource().equals(story)){

        }

        if (event.getSource().equals(setting)){

        }

        if (event.getSource().equals(exit)){
            System.exit(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
