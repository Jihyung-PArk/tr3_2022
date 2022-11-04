package Week6;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

public class Exercise1 extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    private Canvas canvas;

    private double startX, startY;

    private double preX, preY;

    private boolean dragging;

    public void start(Stage stage){
        canvas =new Canvas(500, 380);
        Pane root = new Pane(canvas);
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.setTitle("Exercise 1");
        stage.setResizable(false);


        canvas.setOnMousePressed(this::pressedEvent);
        canvas.setOnMouseDragged(this::draggedEvent);

        stage.show();

    }

    private void pressedEvent(MouseEvent evt) {

        if (evt.getButton() == MouseButton.SECONDARY) {
            dragging = false;
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.WHITE);
            g.fillRect(0, 0, 500, 380);
            return;
        }


        dragging = true;

        startX = evt.getX();
        startY = evt.getY();
        preX = startX;
        preY = startY;

        if (evt.isShiftDown()) {
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.BLUE);
            g.fillOval(startX - 30, startY - 15, 60, 30);
            g.strokeOval(startX - 30, startY - 15, 60, 30);

        } else {
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.RED);
            g.fillRect(startX - 30, startY - 15, 60, 30);
            g.strokeRect(startX - 30, startY - 15, 60, 30);
        }
    }

    private void draggedEvent(MouseEvent evt){

        if(!dragging){
            return;
        }

        startX = evt.getX();
        startY = evt.getY();

        if(Math.abs(startX-preX) < 5 && Math.abs(startY-preY) < 5){
            return;
        }

        preX = startX;
        preY = startY;

        if (evt.isShiftDown()) {
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.BLUE);
            g.fillOval(startX - 30, startY - 15, 60, 30);
            g.strokeOval(startX - 30, startY - 15, 60, 30);

        } else {
            GraphicsContext g = canvas.getGraphicsContext2D();
            g.setFill(Color.RED);
            g.fillRect(startX - 30, startY - 15, 60, 30);
            g.strokeRect(startX - 30, startY - 15, 60, 30);
        }



    }








}
