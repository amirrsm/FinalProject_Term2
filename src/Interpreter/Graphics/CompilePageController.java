package Interpreter.Graphics;

import Interpreter.Core.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CompilePageController implements Initializable {
    public Label fileName;
    public Button chooseFile;
    public Button newFile;
    public Button saveFile;
    public Button compileFile;
    public TextArea codingBox;
    public TextArea terminalBox;
    public TextArea errorBox;

    public void onCompileButtons(ActionEvent event) {

        File file;

        if (event.getSource().equals(chooseFile)) {
            FileChooser.ExtensionFilter suffix = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
            FileChooser selectFile = new FileChooser();
            selectFile.getExtensionFilters().add(suffix);
            selectFile.setTitle("Open File");
            file = selectFile.showOpenDialog(new Stage());
            fileName.setText(file.getName());

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
            }


        }
        if (event.getSource().equals(newFile)) {

        }
        if (event.getSource().equals(saveFile)) {

        }
        if (event.getSource().equals(compileFile)) {
            try {
                Reader.read(codingBox.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
