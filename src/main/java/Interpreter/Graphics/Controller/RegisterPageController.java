package Interpreter.Graphics.Controller;

import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Interpreter.Graphics.Controller.LoginPageController.getContentOfUrlConnection;

public class RegisterPageController implements Initializable {
    public TextField username;
    public TextField password;
    public TextField email;
    public Button register;
    public Button back;
    String result = "";
    boolean tryRegister = false;

    public void onRegisterButtons(ActionEvent event) throws IOException {

        if (event.getSource().equals(register)) {

            //todo testing register (turn on VPN)
            Thread thread = new Thread((Runnable) () -> {
                result = getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/register.php?username=" + username.getText()
                        + "&password=" + password.getText() + "&email=" + email.getText());
            });
            thread.start();
            tryRegister = true;
        }

        if (event.getSource().equals(back)) {
            Stage stage;
            Parent root;
            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/OnlinePage.fxml"));
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void refresh() {

        if (tryRegister && result.equals("registered successfully")) {
            Stage stage;
            Parent root;
            stage = (Stage) register.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/SuccessRegisterPage.fxml"));
            try {
                root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo else (dialog box)
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
        int x = 12;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
