package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {

    public void start(Stage stage) {
        //stage object represents a window on the computer’s screen
        Label message = new Label("First FX Application!");
        message.setFont( new Font(40) );

        Button helloButton = new Button("Say Hello");
        helloButton.setOnAction( evt -> {
            message.setText("Hello World!");
            System.out.println(evt.getSource());
            System.out.println(evt.getTarget());
            System.out.println(evt.getEventType());
        });
        Button goodbyeButton = new Button("Say Goodbye");
        goodbyeButton.setOnAction( evt -> message.setText("Goodbye!!") );
        Button quitButton = new Button("Quit");
        quitButton.setOnAction( evt -> Platform.exit() );

        HBox buttonBar = new HBox( 20, helloButton, goodbyeButton, quitButton );
        buttonBar.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane();
        root.setCenter(message);
        root.setBottom(buttonBar);
        //scene is a container for the GUI components
        Scene scene = new Scene(root, 450, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Test");
        stage.show();
        
    } // end start();

    public static void main(String[] args) {
        launch();  // Run this Application.
    }

} // end class HelloWorldFX