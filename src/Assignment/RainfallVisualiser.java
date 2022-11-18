package Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import textio.TextIO;


public class RainfallVisualiser extends Application {

    /**
     *
     * Author : Jihyung Park
     * Version : 1.0
     * Description:
     *
     */

    /**
     * Draws a picture.  The parameters width and height give the size
     * of the drawing area, in pixels.
     */
    public void drawPicture(GraphicsContext g, int width, int height) {

        double totalMonthlyRainfall;
        double barWidth = 6;
        double barStartX = 40;
        double barStartY = 50;
        double barEndY = 50;
        double verticalGap = 50;
        String[] vertical = {"0", "50", "100", "150", "200", "250","300","350","400"};
        String previousYear = null;
        String currentYear;


        //testing file input
        String line = TextIO.getln();
        //System.out.println(line);




        // TODO: draw the x-axis and y-axis

        g.strokeText("Total rainfall per month",570, 25);

        for(int i = 0; i < 9; i++){
            g.strokeLine(barStartX, barEndY + (verticalGap*i), width, barEndY + (verticalGap*i));
            g.strokeText(vertical[i], 5, height - barEndY - (verticalGap*i));
        }

        for(int i = 0; i < 218; i++){
            g.strokeLine(barStartX + (barWidth*i), barStartY, barStartX + (barWidth*i), height-barEndY);
        }

        while (!TextIO.eof()){

            String[] record = TextIO.getln().trim().split(",");
            totalMonthlyRainfall= Double.parseDouble(record[4]);


            currentYear = record[0];

            if(!currentYear.equals(previousYear)){
                String yearAndMonth = record[0] + "." + record[1];
                Font.font(0.5);
                g.strokeText(yearAndMonth, barStartX-20, height - barEndY + 20);

            }
            previousYear = currentYear;


        // TODO: draw the monthly totals as a bar chart

            double hue = 360*Math.random();
            g.setFill(Color.hsb(hue, 1.0, 1.0));
            g.setStroke(Color.BLACK);
            g.fillRect(barStartX ,height -totalMonthlyRainfall-barEndY, barWidth, totalMonthlyRainfall);
            g.strokeRect(barStartX , height -totalMonthlyRainfall-barEndY, barWidth, totalMonthlyRainfall);
            barStartX += barWidth;

        }

    } // end drawPicture()


    @Override
    //------ Implementation details: DO NOT EDIT THIS ------
    public void start(Stage stage) {
        int width = 218 * 6 + 40;
        int height = 500;
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rainfall Visualiser");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
//        System.out.print("Enter path: ");
//        var path = TextIO.getln();

        var path = "resources/sample_analysed.csv";
        TextIO.readFile(path);
        launch();
    }

}
