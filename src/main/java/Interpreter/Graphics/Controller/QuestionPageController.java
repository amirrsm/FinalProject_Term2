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

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static Interpreter.Database.ProjectDB.connection;

public class QuestionPageController implements Initializable {
    public TextArea codingBox;
    public ImageView questionBox;
    public TextArea terminalBox;
    public Button run;
    public Button back;
    public boolean setQuiz = false;

    public void onQuestionButtons(ActionEvent event) throws IOException, SQLException {
        Stage stage;
        Parent root;
        if (event.getSource().equals(run)) {
            StringBuilder lines = null;
            try {
                lines = Reader.read(codingBox.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (lines != null) {
                terminalBox.setText(lines.toString());
                Reader.stream.delete(0, Reader.stream.length());
            }
        }
        if (event.getSource().equals(back)) {

            Statement statement = connection.createStatement();
            String sql = "UPDATE players SET on_game = '0' WHERE on_game = '1' ";
            statement.executeUpdate(sql);

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

    public void setQuestionBox() {
        if (!setQuiz) {
            switch (StoryPageController.stageSelected) {
                case 1:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q1.png')");
                    setQuiz = true;
                    break;
                case 2:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q2.png')");
                    setQuiz = true;
                    break;
                case 3:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q3.png')");
                    setQuiz = true;
                    break;
                case 4:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q4.png')");
                    setQuiz = true;
                    break;
                case 5:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q5.png')");
                    setQuiz = true;
                    break;
                case 6:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q6.png')");
                    setQuiz = true;
                    break;
                case 7:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q7.png')");
                    setQuiz = true;
                    break;
                case 8:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q8.png')");
                    setQuiz = true;
                    break;
                case 9:
                    questionBox.setStyle("-fx-image: url('file:src/main/java/Interpreter/Graphics/Pictures/Questions/Q9.png')");
                    setQuiz = true;
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
