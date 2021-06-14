package Interpreter.Graphics.Controller;

import Interpreter.Core.Reader;
import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class QuestionPageController implements Initializable {
    public TextArea codingBox;
    public ImageView QuestionBox;
    public TextArea terminalBox;
    public Button run;
    public Button back;

    public void onRunButton(ActionEvent event) throws IOException {
        if (event.getSource().equals(run)) {
            BufferedReader reader = null;
            try {
                PrintStream stream = Reader.read(codingBox.getText());
                reader = new BufferedReader(new FileReader("compile.txt"));
                StringBuilder lines = new StringBuilder();
                while (true) {
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    else {
                        lines.append(line);
                        lines.append("\n");
                    }
                }
                reader.close();
                stream.close();
                terminalBox.setText(lines.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Files.delete(Path.of("compile.txt"));
        }
        if (event.getSource().equals(back)) {
            Stage stage;
            Parent root;
            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/StartPage.fxml"));
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
