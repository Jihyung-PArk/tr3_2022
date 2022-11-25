package Week9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import textio.TextIO;

import java.util.ArrayList;


public class RainfallVisualiser extends Application {

    /**
     *
     * Author : Jihyung Park
     * Version : 3.0
     * Description:
     *
     */

    /**
     * Draws a picture.  The parameters width and height give the size
     * of the drawing area, in pixels.
     */

    final static Integer margin = 20;
    final static Integer rotationVertical = 90;
    public void drawPicture(GraphicsContext g, int width, int height) {

        int numOfRecord = 0;
        double max = Double.NEGATIVE_INFINITY;
        double xAxisLength = width - ( 2 * margin );
        double yAxisLength = height - ( 2 * margin );
        double barStartX = margin;
        ArrayList<String> newRecords = new ArrayList<>();


        //Ignore first line
        TextIO.getln();

        while (!TextIO.eof()){

        String line = TextIO.getln().trim();
        newRecords.add(line);
        numOfRecord += 1;
        }

        double barWidth = xAxisLength / numOfRecord;

        for(String newRecord : newRecords){
            String[] record = newRecord.split(",");

            double rainAmong = Double.parseDouble(record[2]);

            if (rainAmong > max){
                max = rainAmong;
            }
        }

        g.setFont(Font.font("Times New Roman",7));

        verticalUnitLabel(g, height);
        horizontalUnitLabel(g, width, height);

        int ratioOfY= (int) ((max/yAxisLength) + 1);
        int numOfRows = (int) (yAxisLength/margin);

        horizontalLine(g, width, ratioOfY, width, height, numOfRows);
        verticalLine(g, height, barWidth, numOfRecord);

        horizontalLabel(g, newRecords, height, barWidth);
        barGraph(g, newRecords, height, barWidth, ratioOfY);

    }

    private void barGraph(GraphicsContext g, ArrayList<String> newRecords, int height, double barWidth, int ratioOfY) {

        double totalMonthlyRainfall;
        double gapBetweenBar = 0;

        gapBetweenBar += margin;


        for(String newRecord : newRecords) {

            String[] record = newRecord.split(",");

            totalMonthlyRainfall = Double.parseDouble(record[2]);
            double ratioOfTotalRainfall = totalMonthlyRainfall/ratioOfY;

            double hue = 360 * Math.random();
            g.setFill(Color.hsb(hue, 1.0, 1.0));
            g.setStroke(Color.BLACK);
            g.fillRect(gapBetweenBar, height - ratioOfTotalRainfall - margin, barWidth, ratioOfTotalRainfall);
            g.strokeRect(gapBetweenBar, height - ratioOfTotalRainfall - margin, barWidth, ratioOfTotalRainfall);
            gapBetweenBar += barWidth;
        }
    }

    private void horizontalLabel(GraphicsContext g, ArrayList<String> newRecords, int height, double barWidth) {
        String previousYear = null;
        String currentYear;
        double gapBetweenLabel = 0;

        gapBetweenLabel += margin;

        for(String newRecord : newRecords) {

            String[] record = newRecord.split(",");
            currentYear = record[0];

            if (!currentYear.equals(previousYear)) {
                String yearAndMonth = record[0] + "." + record[1];
                g.setTextAlign(TextAlignment.CENTER);
                g.setTextBaseline(VPos.TOP);
                g.setFill(Color.BLACK);
                g.fillText(yearAndMonth, gapBetweenLabel, height - margin);
            }
            previousYear = currentYear;

            gapBetweenLabel += barWidth;
        }

    }

    private void verticalLine(GraphicsContext g, int height, double barWidth, int numOfRecord) {
        for(int i = 0; i < numOfRecord+1; i++){
            g.strokeLine(margin + (barWidth*i), margin, margin + (barWidth*i), height-margin);
        }
    }

    private void horizontalLine(GraphicsContext g, int width, int ratioOfY, int width1, int height, int numOfRows) {
        for(int i = 0; i < numOfRows+1; i++){

            g.strokeLine(margin, margin + (margin*i), width-margin, margin + (margin*i));
            g.setTextAlign(TextAlignment.CENTER);
            g.setTextBaseline(VPos.TOP);

            String count = Integer.toString(margin * i * ratioOfY);
            if(i > 0){
                g.rotate(rotationVertical);
                g.fillText(count, height - margin - (margin*i), -margin);
                g.rotate(-rotationVertical);
            }
        }
    }

    private void horizontalUnitLabel(GraphicsContext g, int width, int height) {
        g.fillText(" Unit : Year.Month", (double) width/2, height- (double) (margin/4));
    }

    private void verticalUnitLabel(GraphicsContext g, int height) {
        g.rotate(rotationVertical);
        g.fillText("Unit : millimeter(mm)", (double) height/2, (double)-margin/4);
        g.rotate(-rotationVertical);
    }


    // end drawPicture()




    @Override
    public void start(Stage stage) {
        Label nameLabel = new Label("Enter File Name:");
        TextField fileName = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");

        Button applyButton = new Button("Apply");
        Button exitButton = new Button("Exit");

        applyButton.setOnAction(e -> {
            String name = fileName.getText();
            System.out.println(name);
            if (name.trim().length() == 0) {
                msg.setText("Please enter file name");
            }
            else {

                //------ Implementation details: DO NOT EDIT THIS ------
                try {
                    TextIO.readFile(name);

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
                catch (Exception a){
                    msg.setText("Please double check file name");
                }
            }
        });
        exitButton.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.setSpacing(5);
        root.getChildren().addAll(nameLabel, fileName, msg, applyButton, exitButton);
        Scene scene = new Scene(root, 350, 150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
