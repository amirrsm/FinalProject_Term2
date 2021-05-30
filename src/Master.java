import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Master extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        Circle circle = new Circle(150, 150, 100);
        root.getChildren().add(circle);
        Scene scene = new Scene(root, 600, 600, Color.DARKCYAN);




        primaryStage.setTitle("Amir");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}