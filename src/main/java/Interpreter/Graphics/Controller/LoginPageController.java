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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public TextField username;
    public TextField password;
    public Button login;
    public Button back;

    public static int myID;
    public static int opponentID;

    public void onLoginButtons(ActionEvent event) throws IOException {
        if (event.getSource().equals(login)) {
            canEnter(username.getText(), password.getText());
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

    public void refresh() throws IOException {
        if (state) {
            Stage stage;
            Parent root;
            stage = (Stage) login.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("/WaitingPage.fxml"));
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


    boolean state = false;

    private boolean canEnter(String username, String password) {
        Thread thread = new Thread((Runnable) () -> {
            String result = getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/login.php?username=" + username + "&password=" + password);
            if (!result.equals("not found!")) {
                myID = Integer.parseInt(result);
                state = true;
            }
        });
        thread.start();

        return state;
    }

    public static String getContentOfUrlConnection(String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            return InputStreamToString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public static String InputStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
