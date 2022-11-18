package Week6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Question4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {

        canvas = new Canvas (500,500);
        Pane root = new Pane(canvas);
        Scene scene = new Scene( root );
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question 4");
        primaryStage.setResizable(false);

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.RED);
        g.fillOval(50,50,400,400);
        g.setFill(Color.GREEN);
        g.fillRect(200,200,100,100);

        primaryStage.show();
    }
}
