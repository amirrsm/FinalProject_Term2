package Interpreter.Graphics.Controller;

import static Interpreter.Database.ProjectDB.*;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public TextField username;
    public TextField password;
    public Button login;
    public Button back;

    public void onLoginButtons(ActionEvent event) throws IOException, SQLException {
        if (event.getSource().equals(login)) {


            String user = username.getText();
            String pass = password.getText();

            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM players where username like '%s' and password like '%s'", user, pass);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                if (result.getString("on_game").equals("1")) {
                    Stage stage;
                    Parent root;
                    stage = (Stage) back.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(App.class.getResource("/WaitingPage.fxml"));
                    root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else if (result.getString("on_game").equals("0")) {
                    sql = String.format("UPDATE players SET on_game = '1' WHERE username like '%s' and password like '%s'", user, pass);
                    statement.executeUpdate(sql);
                    Stage stage;
                    Parent root;
                    stage = (Stage) back.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(App.class.getResource("/QuestionPage.fxml"));
                    root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
            }
        }
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
    }
}
