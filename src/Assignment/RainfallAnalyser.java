package Assignment;

import textio.TextIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RainfallAnalyser {

    /**
     * Author : Jihyung Park
     * Version : 2.0
     * Date : 11/11/2022
     * Description :
     *
     */

    //define constants
    private static final String OUTPUT_HEADER = "Year,Month,Max,Min,Total";

    public static void main(String[] args) {

        System.out.print("Enter a filename: ");

        String filename = TextIO.getln();

        try {
            TextIO.readFile(filename);
            System.out.println("Reading successfully");

            //generate output file
            String outputFile = generateOutputFile(filename);

            //save monthly total, min and max to output file
            generateMonthlyStatistics(outputFile, filename);
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }

    private static void generateMonthlyStatistics(String outputFile, String filename) {

        //check number of rows (except first line)
        String[] record;
        //check number of colum
        int checkColumn;
        int year;
        byte currentMonth;
        byte previousMonth = 1;
        double rainAmong;
        double totalMonthlyRainfall = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        try{
            Scanner scanner = new Scanner(new FileReader(filename));

            while (scanner.hasNextLine()){
                scanner.nextLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //read the first line and ignore it
        String line = TextIO.getln();
        checkColumn = line.split(",").length;

        //for testing only = it is not satisfied the required
        TextIO.writeFile(outputFile);

        //first row of new file
        TextIO.putln(OUTPUT_HEADER);

        //testing
        //System.out.println(line);

        if(TextIO.eof()){
            System.out.println("Empty file. Aborted");
            return;
        }

        while (!TextIO.eof()){

            //and read again
            line = TextIO.getln().trim();

            //extract info...
            record = line.split(",");

            //add miss data to 0
            String[] newRecord = Arrays.copyOf(record, checkColumn);
            for (int i = 0; i < checkColumn; i++){
                if(newRecord[i] == null || newRecord[i].equals("")){
                    newRecord[i] = "0";
                }
            }
            record = newRecord;

            //update year, month, rain among
            year = Integer.parseInt(record[2]);
            currentMonth = Byte.parseByte(record[3]);
            rainAmong = Double.parseDouble(record[5]);

            //add rain among to total rain among
            totalMonthlyRainfall += rainAmong;

            //check min rain among
            if (rainAmong < min) {
                min = rainAmong;
            }

            //check max rain among
            if (rainAmong > max) {
                max = rainAmong;
            }

            //save each month data and reset max, min
            if (currentMonth != previousMonth){
                saveMonthlyRecord(year, previousMonth, max, min, totalMonthlyRainfall);

                previousMonth = currentMonth;
                totalMonthlyRainfall = rainAmong;
                max = Double.NEGATIVE_INFINITY;
                min = Double.POSITIVE_INFINITY;

                if (rainAmong < min) {
                    min = rainAmong;
                }

                //check max rain among
                if (rainAmong > max) {
                    max = rainAmong;
                }
            }
        }
    }

    private static void saveMonthlyRecord(int year, byte previousMonth, double max, double min, double totalMonthlyRainfall) {

        //convert different value to string
        String yearString = Integer.toString(year);
        String monthString = Byte.toString(previousMonth);
        String maxString = String.format("%.02f", max);
        String minString = String.format("%.02f", min);
        String totalString = String.format("%.02f", totalMonthlyRainfall);

        //make one string
        String row = yearString + "," + monthString + "," + maxString + "," + minString + "," + totalString;

        //add row to _analysed file
        TextIO.putln(row);
    }

    private static String generateOutputFile(String filename) {

        String[] fileParts = filename.split("\\.");

        //test output file name
      //  System.out.println(Arrays.toString(fileParts));

        return fileParts[0] + "_analysed.csv";
    }
}
