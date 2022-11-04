package Week6;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise4 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private int die1 = (int)(Math.random()*6) + 1;

    private int die2 = (int)(Math.random()*6) + 1;

    private Canvas canvas;

    private Button button;

    private long startTime;

    private final AnimationTimer animationTimer = new AnimationTimer() {
        public void handle(long l) {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            draw();
            if(l - startTime >= 1000000000){
                animationTimer.stop();
                button.setDisable(false);
            }
        }
    };

    public void start(Stage stage){

        canvas = new Canvas (100,100);
        button = new Button("Rolling");
        button.setMaxWidth(1000);
        button.setOnAction(e -> roll());
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);
        borderPane.setBottom(button);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Exercise 4");
        stage.setResizable(false);


        draw();

        stage.show();

    }

    private void roll(){
        button.setDisable(true);
        startTime = System.nanoTime();
        animationTimer.start();
    }

    private void draw(){

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.LIGHTBLUE);
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        g.setStroke(Color.BLUE);
        g.strokeRect(1,1,98,98);
        drawDie(g, die1, 10, 10);
        drawDie(g, die2, 55, 55);
    }

    private void drawDie(GraphicsContext g, int num, int x, int y){
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 35, 35);
        g.setStroke(Color.BLACK);
        g.strokeRect(x + 0.5, y + 0.5, 34, 34);
        g.setFill(Color.BLACK);

        if(num > 1){
            g.fillOval(x+3, y+3, 9, 9);
        } if(num > 3){
            g.fillOval(x + 23, y + 3, 9, 9);
        } if(num == 6){
            g.fillOval(x + 3, y + 13, 9, 9);
        } if (num%2 == 1){
            g.fillOval(x + 13, y + 13, 9,9);
        } if (num == 6){
            g.fillOval(x + 23, y + 13, 9, 9);
        } if (num > 3){
            g.fillOval(x + 3, y + 23, 9, 9);
        } if ( num > 1){
            g.fillOval( x+ 23, y+ 23, 9, 9);
        }
    }
}

