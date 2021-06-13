package Interpreter.Graphics.Controller;

import Interpreter.Core.Reader;
import Interpreter.Graphics.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class CompilePageController implements Initializable {

    public Label fileName;
    public Button chooseFile;
    public Button newFile;
    public Button compileFile;
    public Button back;
    public TextArea codingBox;
    public TextArea terminalBox;
    public TextArea errorBox;

    public void onCompileButtons(ActionEvent event) throws IOException {
        File file;
        FileChooser.ExtensionFilter suffix = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        FileChooser selectFile = new FileChooser();
        selectFile.getExtensionFilters().add(suffix);

        if (event.getSource().equals(chooseFile)) {
            selectFile.setTitle("Open File");
            file = selectFile.showOpenDialog(new Stage());
            fileName.setText("  " + file.getName() + "  ");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
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
                codingBox.setText(lines.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (event.getSource().equals(newFile)) {

            BufferedWriter writer = null;
            selectFile.setTitle("Save File");
            file = selectFile.showSaveDialog(new Stage());
            try {
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(codingBox.getText());
                writer.close();
                fileName.setText(file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (event.getSource().equals(compileFile)) {
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
        if (event.getSource().equals(chooseFile)) {
            chooseFile.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(newFile)) {
            newFile.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(compileFile)) {
            compileFile.setStyle("-fx-opacity: 1");
        }
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.9");
        }
    }

    public void mouseExit(MouseEvent event) {
        if (event.getSource().equals(chooseFile)) {
            chooseFile.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(newFile)) {
            newFile.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(compileFile)) {
            compileFile.setStyle("-fx-opacity: 0.85");
        }
        if (event.getSource().equals(back)) {
            back.setStyle("-fx-opacity: 0.55");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
