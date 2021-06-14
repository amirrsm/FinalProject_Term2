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
    public ImageView questionBox;
    public TextArea terminalBox;
    public Button run;
    public Button back;
    public boolean setQuiz = false;

    public void onQuestionButtons(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
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

            stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("Fxml/StoryPage.fxml"));
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

    public void setQuestionBox() {
        if (!setQuiz) {
            switch (StoryPageController.stageSelected) {
                case 1:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q1.png')");
                    setQuiz = true;
                    break;
                case 2:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q2.png')");
                    setQuiz = true;
                    break;
                case 3:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q3.png')");
                    setQuiz = true;
                    break;
                case 4:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q4.png')");
                    setQuiz = true;
                    break;
                case 5:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q5.png')");
                    setQuiz = true;
                    break;
                case 6:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q6.png')");
                    setQuiz = true;
                    break;
                case 7:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q7.png')");
                    setQuiz = true;
                    break;
                case 8:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q8.png')");
                    setQuiz = true;
                    break;
                case 9:
                    questionBox.setStyle("-fx-image: url('file:src/Interpreter/Graphics/Pictures/Questions/Q9.png')");
                    setQuiz = true;
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}