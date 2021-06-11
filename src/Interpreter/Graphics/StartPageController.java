package Interpreter.Graphics;

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
    private void handleStartButtons(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
