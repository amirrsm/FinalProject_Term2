package Interpreter.Graphics.Controller;

import Interpreter.Core.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ChallengePageController implements Initializable {
    public Pane challengeQ;
    public TextArea codingBox;
    public TextArea terminalBox;
    public Button run;
    public MediaView mediaView;
    public TextArea chatBox;
    public TextArea chatText;
    public Button send;
    public static boolean chatting;

    public void onChallengeButtons(ActionEvent event) {
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


            if (terminalBox.getText().equals("1\n")) {
                String path = "src/main/java/Interpreter/Graphics/Pictures/WinClip.mp4";
                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaView.setVisible(true);
                mediaPlayer.setAutoPlay(true);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mediaView.setVisible(false);
                        if (!mediaView.isVisible())
                            timer.cancel();

                    }
                }, 8000);
            } else {
                String path = "src/main/java/Interpreter/Graphics/Pictures/LoseClip.mp4";
                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaView.setVisible(true);
                mediaPlayer.setAutoPlay(true);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mediaView.setVisible(false);
                        if (!mediaView.isVisible())
                            timer.cancel();
                    }
                }, 6000);
            }
        }
        if (event.getSource().equals(send)) {
            chatting = true;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        challengeQ.setStyle("-fx-background-image: url('file: src/main/java/Interpreter/Graphics/Pictures/Onlinepage/challenge1.png'); " +
                "-fx-background-size: 100% 100%");
/*
        Thread thread = new Thread(() -> {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(chatting){
                        getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/chat.php?myID=" + LoginPageController.myID + "&chat=" + chatText);
                        chatText.setText(null);
                        chatting = false;
                    }
                    String result = getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/check.php?myID=" + LoginPageController.myID);
                    int state = -1;
                    if (result.length() == 1)
                        state = Integer.parseInt(result);
                    if (state == 0) {
                        falseDialog = true;
                        t.cancel();
                        playDialog(false);
                    } else if (state != 0 && !result.equals("")) {
                        chat.append("opponent: " + result + "\n");
                    } else if (ok)
                        getContentOfUrlConnection("https://sajjad8080.000webhostapp.com/winner.php?myID=" + LoginPageController.myID + "&opponentID=" + LoginPageController.opponentID);
                }
            }, 0, 1000);
        });
        thread.start();
        */
    }
    //todo complete challenge page
    //todo chat box
    //todo we have one page for challenge
}
