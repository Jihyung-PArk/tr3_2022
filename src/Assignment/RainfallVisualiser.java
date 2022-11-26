package Assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
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
     * Date : 26/11/2022
     * Description: RainfallVisualiser converts climate information provided by The Australian Bureau of
     *              Meteorology (BOM) analyzed by RainfallAnalyser into graphs. RainfallVisualiser shows
     *              the total rainfall analyzed by RainfallAnalyser in the form of a bar graph.
     *              The x-axis is presented in time order, and the y-axis represents the total amount of rain.
     */

    //Margin 20 all direction
    final static Integer MARGIN = 20;

    //90 degree
    final static Integer ROTATION90 = 90;
    public void drawPicture(GraphicsContext g, int width, int height, String name) {

        int numOfRecord;
        double max;
        double xAxisLength = width - ( 2 * MARGIN );
        double yAxisLength = height - ( 2 * MARGIN );

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
        int numOfRows = (int) (yAxisLength/MARGIN);

        //draw horizontal and vertical line
        horizontalLine(g, width, numOfRows);
        verticalLine(g, height, barWidth, numOfRecord);

        //draw horizontal label base on vertical line
        horizontalLabel(g, name, height, barWidth);
        verticalLabel(g, height, ratioOfY, numOfRows);
        //draw bar graph
        barGraph(g, name, height, barWidth, ratioOfY);
    }
    // end drawPicture()

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
    // end numOfRecord()

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
    //end getMaxRainfall()

    private void titleLabel(GraphicsContext g, String name, int width) {

        String[] fileName;
        String barGraphName = name;

        g.setFont(Font.font("Times New Roman",14));

        //Classified only file name
        if(barGraphName.contains("/")){
            fileName = name.split("/");
            barGraphName = fileName[fileName.length-1];
        }
        if(barGraphName.contains("_analysed.csv")){
            fileName = barGraphName.split("_analysed.csv");
            barGraphName = fileName[0];
        }
        if(barGraphName.contains("_")){
            barGraphName = barGraphName.replaceAll("_", " ");

        }
        //draw title label
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText(barGraphName, (double) width/2, (double) MARGIN/2);
    }
    //end titleLabel()

    private void verticalUnitLabel(GraphicsContext g, int height) {

        g.setFont(Font.font("Times New Roman",8));

        // y axis unit label
        g.rotate(ROTATION90);
        g.fillText("Unit : millimeter(mm)", (double) height/2, (double)-MARGIN/4);
        g.rotate(-ROTATION90);
    }
    //end verticalUnitLabel()

    private void horizontalUnitLabel(GraphicsContext g, int width, int height) {

        g.setFont(Font.font("Times New Roman",9));
        g.setTextBaseline(VPos.BOTTOM);

        //x axis unit label
        g.fillText(" Unit : Year.Month", (double) width/2, height);
    }
    //end horizontalUnitLabel()

    private void verticalLine(GraphicsContext g, int height, double barWidth, int numOfRecord) {

        //draw vertical line
        for(int i = 0; i < numOfRecord+1; i++){
            g.strokeLine(MARGIN + (barWidth*i), MARGIN, MARGIN + (barWidth*i), height-MARGIN);
        }
    }
    //end verticalLine()

    private void horizontalLine(GraphicsContext g, int width, int numOfRows) {

        //draw horizontal line
        for(int i = 0; i < numOfRows+1; i++){

            g.strokeLine(MARGIN, MARGIN + (MARGIN*i), width-MARGIN, MARGIN + (MARGIN*i));
            g.setTextAlign(TextAlignment.CENTER);
            g.setTextBaseline(VPos.TOP);
        }
    }
    //end horizontalLine()

    private void horizontalLabel(GraphicsContext g, String name, int height, double barWidth) {
        String previousYear = null;
        String currentYear;
        double gapBetweenLabel = 0;

        gapBetweenLabel += MARGIN;

        g.setFont(Font.font("Times New Roman",12));

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
                g.fillText(yearAndMonth, gapBetweenLabel, height - MARGIN);
            }
            previousYear = currentYear;

            gapBetweenLabel += barWidth;
        }
    }
    //end horizontalLabel()

    private void verticalLabel(GraphicsContext g, int height, int ratioOfY, int numOfRows ) {

        for(int i = 1; i < numOfRows + 1; i++){
            // draw Y axis label
            g.setFont(Font.font("Times New Roman",10));

            String count = Integer.toString(MARGIN * i * ratioOfY);
            g.rotate(ROTATION90);
            g.fillText(count, height - MARGIN - (MARGIN*i), -MARGIN);
            g.rotate(-ROTATION90);

        }
    }
    //end verticalLabel()


    private void barGraph(GraphicsContext g, String name, int height, double barWidth, int ratioOfY) {

        double totalMonthlyRainfall;
        double gapBetweenBar = 0;

        gapBetweenBar += MARGIN;

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
            //set random colour on bar
            double hue = 360 * Math.random();

            g.setFill(Color.hsb(hue, 1.0, 1.0));
            g.setStroke(Color.BLACK);
            g.fillRect(gapBetweenBar, height - ratioOfTotalRainfall - MARGIN, barWidth, ratioOfTotalRainfall);
            g.strokeRect(gapBetweenBar, height - ratioOfTotalRainfall - MARGIN, barWidth, ratioOfTotalRainfall);
            gapBetweenBar += barWidth;
        }
    }
    //end barGraph()

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
        returnButton.setPadding(new Insets(0, 10, 5, 0));
        root.setBottom(returnButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rainfall Visualiser");
        stage.centerOnScreen();
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}
