package Week6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class Exercise2 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private Canvas canvas;

    private double redBoxX = 20, redBoxY = 80;

    private double blueBoxX = 460, blueBoxY = 80;

    private double startX, startY;

    private boolean dragging;

    private boolean boxRed;

    private double restoreX, restoreY;

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        g.setFill(Color.RED);
        g.fillRect( redBoxX, redBoxY, 20, 20);
        g.setFill(Color.BLUE);
        g.fillRect( blueBoxX, blueBoxY, 20, 20);
    }

    public  void start(Stage stage){

        canvas =new Canvas(500, 380);
        Pane root = new Pane(canvas);
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.setTitle("Exercise 2");
        stage.setResizable(false);


        canvas.setOnMousePressed(this::pressedEvent);
        canvas.setOnMouseDragged(this::draggedEvent);
        canvas.setOnMouseReleased(this::releasedEvent);


        draw();

        scene.setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.ESCAPE){
                redBoxX = 20;
                redBoxY = 80;
                blueBoxX = 460;
                blueBoxY =80;
                draw();
            }
        });
        stage.show();
    }

    private void pressedEvent(MouseEvent evt) {

        if(dragging){
            return;
        }

        startX = evt.getX();
        startY = evt.getY();

        if(startX >= blueBoxX && startX < blueBoxX + 20 && startY >= blueBoxY && startY < blueBoxY + 20){

            dragging = true;
            boxRed = false;
            restoreX = startX - blueBoxX;
            restoreY = startY - blueBoxY;

        } else if (startX >= redBoxX && startX < redBoxX + 20 && startY >= redBoxY && startY < redBoxY + 20) {

            dragging = true;
            boxRed = true;
            restoreX = startX - redBoxX;
            restoreY = startY - redBoxY;
        }

    }

    private void draggedEvent(MouseEvent evt){

        if(!dragging){
            return;
        }

        startX = evt.getX();
        startY = evt.getY();

        if(!boxRed){
            blueBoxX = startX - restoreX;
            blueBoxY = startY - restoreY;
        } else  {
            redBoxX = startX - restoreX;
            redBoxY = startX - restoreX;

        }
        draw();
    }

    private void releasedEvent(MouseEvent evt){
        dragging = false;
    }
}


