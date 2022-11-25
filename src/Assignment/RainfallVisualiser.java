package Assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import textio.TextIO;


public class RainfallVisualiser extends Application {

    /**
     *
     * Author : Jihyung Park
     * Version : 4.0
     * Description:
     *
     */

    //Margin 20 all direction
    final static Integer margin = 20;

    //90 degree
    final static Integer rotationVertical = 90;
    public void drawPicture(GraphicsContext g, int width, int height, String name) {

        int numOfRecord;
        double max;
        double xAxisLength = width - ( 2 * margin );
        double yAxisLength = height - ( 2 * margin );

        //Check how many record the file has
        numOfRecord = numOfRecord(name);
        //Check max rainfall among
        max = getMaxRainfall(name);

        //each bar width is total graph width divide by number of record in file
        double barWidth = xAxisLength / numOfRecord;

        //Label for title, vertical axis, horizontal axis
        titleLabel(g, name, width);
        verticalUnitLabel(g, height);
        horizontalUnitLabel(g, width, height);

        //Reduce size of bar graph base on max rain among
        int ratioOfY= (int) ((max/yAxisLength) + 1);
        //Check how many horizontal line in it
        int numOfRows = (int) (yAxisLength/margin);

        //draw horizontal and vertical line
        horizontalLine(g, width, ratioOfY, height, numOfRows);
        verticalLine(g, height, barWidth, numOfRecord);

        //draw horizontal label base on vertical line
        horizontalLabel(g, name, height, barWidth);
        //draw bar graph
        barGraph(g, name, height, barWidth, ratioOfY);

    }

    private double getMaxRainfall(String name) {
        double max = Double.NEGATIVE_INFINITY;

        //read file and ignore first line
        TextIO.readFile(name);
        TextIO.getln();

        //check max value of total rainfall among
        while (!TextIO.eof()){

            //and read again
            String line = TextIO.getln().trim();
            //extract info...
            String[] record = line.split(",");

            double rainAmong = Double.parseDouble(record[2]);

            if (rainAmong > max){
                max = rainAmong;
            }
        }
        return max;
    }

    private int numOfRecord(String name) {
        int numOfRecord = 0;

        //read file and ignore first line
        TextIO.readFile(name);
        TextIO.getln();

        //check how many row this file has
        while (!TextIO.eof()){

            TextIO.getln();
            numOfRecord += 1;
        }

        return numOfRecord;
    }

    private void titleLabel(GraphicsContext g, String name, int width) {

        String[] fileName;
        String barGraphName = name;

        g.setFont(Font.font("Times New Roman",14));

        //Classified only file name
        if(barGraphName.contains("/")){
            fileName = name.split("/");
            barGraphName = fileName[1];
        }
        if(barGraphName.contains("_")){
            fileName = barGraphName.split("_");
            barGraphName = fileName[0];
        }

        //draw title label
        g.fillText(barGraphName, (double) width/2, (double) margin/2);
    }

    private void barGraph(GraphicsContext g, String name, int height, double barWidth, int ratioOfY) {

        double totalMonthlyRainfall;
        double gapBetweenBar = 0;


        gapBetweenBar += margin;

        //read file and ignore first line
        TextIO.readFile(name);
        TextIO.getln();


        while (!TextIO.eof()){

            //and read again
            String line = TextIO.getln().trim();

            //extract info...
            String[] record = line.split(",");

            totalMonthlyRainfall = Double.parseDouble(record[2]);
            //reduce total rainfall base on ratio
            double ratioOfTotalRainfall = totalMonthlyRainfall/ratioOfY;

            double hue = 360 * Math.random();

            g.setFill(Color.hsb(hue, 1.0, 1.0));
            g.setStroke(Color.BLACK);
            g.fillRect(gapBetweenBar, height - ratioOfTotalRainfall - margin, barWidth, ratioOfTotalRainfall);
            g.strokeRect(gapBetweenBar, height - ratioOfTotalRainfall - margin, barWidth, ratioOfTotalRainfall);
            gapBetweenBar += barWidth;
        }
    }

    private void horizontalLabel(GraphicsContext g, String name, int height, double barWidth) {
        String previousYear = null;
        String currentYear;
        double gapBetweenLabel = 0;

        gapBetweenLabel += margin;

        g.setFont(Font.font("Times New Roman",8));

        //read file and ignore first line
        TextIO.readFile(name);
        TextIO.getln();

        while (!TextIO.eof()){

            //and read again
            String line = TextIO.getln().trim();

            //extract info...
            String[] record = line.split(",");

            currentYear = record[0];

            //draw X axis label (YY/01)
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

        //draw vertical line
        for(int i = 0; i < numOfRecord+1; i++){
            g.strokeLine(margin + (barWidth*i), margin, margin + (barWidth*i), height-margin);
        }
    }

    private void horizontalLine(GraphicsContext g, int width, int ratioOfY, int height, int numOfRows) {

        //draw horizontal line
        for(int i = 0; i < numOfRows+1; i++){

            g.strokeLine(margin, margin + (margin*i), width-margin, margin + (margin*i));
            g.setTextAlign(TextAlignment.CENTER);
            g.setTextBaseline(VPos.TOP);

            // draw Y axis label
            String count = Integer.toString(margin * i * ratioOfY);
            if(i > 0){
                g.rotate(rotationVertical);
                g.fillText(count, height - margin - (margin*i), -margin);
                g.rotate(-rotationVertical);
            }
        }
    }

    private void horizontalUnitLabel(GraphicsContext g, int width, int height) {

        g.setFont(Font.font("Times New Roman",8));

        //x axis unit label
        g.fillText(" Unit : Year.Month", (double) width/2, height- (double) (margin/4));
    }

    private void verticalUnitLabel(GraphicsContext g, int height) {

        g.setFont(Font.font("Times New Roman",8));

        // y axis unit label
        g.rotate(rotationVertical);
        g.fillText("Unit : millimeter(mm)", (double) height/2, (double)-margin/4);
        g.rotate(-rotationVertical);
    }
    // end drawPicture()

    @Override
    public void start(Stage stage) {
        Label nameLabel = new Label("Enter File Name: (e.g. resources/sample_analysed.csv)");
        TextField fileName = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");

        Button applyButton = new Button("Apply");
        Button exitButton = new Button("Exit");

        applyButton.setPrefWidth(180);
        applyButton.setStyle("-fx-text-fill: #0000ff");
        exitButton.setPrefWidth(180);
        exitButton.setStyle("-fx-text-fill: #0000ff");

        HBox optionButton = new HBox(applyButton, exitButton);

        applyButton.setOnAction(e -> { String name = fileName.getText();
            if (name.trim().length() == 0) {
                msg.setText("Please enter file name");
            } else {
                try {
                    TextIO.readFile(name);
                    graphWindow(stage, name);
                }
                catch (Exception a){
                    msg.setText("Please double check file name");
                }
            }
        });
        exitButton.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.setSpacing(5);
        root.getChildren().addAll(nameLabel, fileName, msg, optionButton);
        Scene scene = new Scene(root, 350, 100);
        stage.setScene(scene);
        stage.setTitle("Rainfall Visualiser");
        stage.show();
    }

    private void graphWindow(Stage stage, String name) {
        int width = 218 * 6 + 40;
        int height = 500;
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height, name);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");

        Button startOverButton = new Button("Return Main");
        startOverButton.setOnAction( e -> {
            stage.close();
            start(new Stage());
        } );
        startOverButton.setPrefWidth(100);
        startOverButton.setStyle("-fx-text-fill: #0000ff");
        HBox returnButton = new HBox(startOverButton);
        returnButton.setAlignment(Pos.CENTER_RIGHT);
        root.setBottom(returnButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rainfall Visualiser");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}
