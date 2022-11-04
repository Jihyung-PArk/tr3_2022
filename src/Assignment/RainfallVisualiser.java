package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class RainfallVisualiser extends Application {

    /**
     *
     * Author : Jihyung Park
     * Version : 1.0
     * Description:
     *
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label message = new Label("Assignment!");
        message.setFont(new Font(50));

        //define the root container
        BorderPane root = new BorderPane();
        root.setCenter(message);

        //define the scene and set the windows size
        Scene scene = new Scene(root,800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rainfall Visualiser");
        primaryStage.show();


    }
}
