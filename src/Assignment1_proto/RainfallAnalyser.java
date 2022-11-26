package Assignment1_proto;

import textio.TextIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RainfallAnalyser {

    /**
     * Author : Jihyung Park
     * Version : 1.0
     * Date :
     * Description :
     *
     */

    //define constants
    private static final String OUTPUT_HEADER = "Year,Month,Max,Min,Total";

    public static void main(String[] args) {

        System.out.print("Enter a filename: ");

        String filename = TextIO.getln();
   //     System.out.println(filename);

        try {
            TextIO.readFile(filename);
            System.out.println("Reading successfully");


            //generate output file
            String outputFile = generateOutputfile(filename);

            //save monthly total, min and max to output file
            generateMonthlyStatistics(outputFile, filename);
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }

    private static void generateMonthlyStatistics(String outputFile, String filename) {


        //check number of rows (except first line)
        int lineCount = -1;
        int year = 0;
        byte month = 0;
        int day = 0;
        double totalOfNum = 0;
        double rainAmong;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        String[] record;
        String[] checkColumn;
        int rowNum = 0;
        int columnNum = 0;
        String[][] newFile;




        try{
            Scanner scanner = new Scanner(new FileReader(filename));


            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine().split(","));
                lineCount++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //check total row
        //System.out.println(lineCount);


        //read the first line and ignore it
        String line = TextIO.getln();
        checkColumn = line.split(",");
        columnNum = checkColumn.length;


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

        //make 2D array
        newFile = new String[lineCount][columnNum];



        while (!TextIO.eof()){


            //and read again
            line = TextIO.getln().trim();


            //extract info...
            record = line.split(",");

            System.out.println(Arrays.toString(record));

            //add miss data to 0
            if (record.length != columnNum && record.length < columnNum){
                String[] newRecord = Arrays.copyOf(record, record.length+3);
                for(int i = 0; i < 3; i++){
                    newRecord[record.length + i] = "0";
                }
                record = newRecord;

            //add miss data to 0
            } else if (record[6].equals("")) {
                record[6] = "0";


            }
            //copy array for add at 2D array
            System.arraycopy(record, 0, newFile[rowNum], 0, 8);
            rowNum++;



        }

        // check newFile(2D array)
//
//        for (String[] strArr : newFile) {
//            for (int j = 0; j < strArr.length; j++) {
//                System.out.print(strArr[j]);
//            }
//            System.out.println();
//        }


        // get first year, month, day value
        year = Integer.parseInt(newFile[0][2]);
        month = Byte.parseByte(newFile[0][3]);
        day = Integer.parseInt(newFile[0][4]);


        for (String[] strings : newFile) {

            // String array value to Integer or Float
            int rowOfYear = Integer.parseInt(strings[2]);
            byte rowOfMonth = Byte.parseByte(strings[3]);
            int rowOfDay = Integer.parseInt(strings[4]);
            double rowOfRain = Double.parseDouble(strings[5]);

            //Group value by year and month
            if (rowOfYear == year && rowOfMonth == month && rowOfDay == day) {

                //sum rain among
                totalOfNum += rowOfRain;

                //check min rain among
                if (rowOfRain < min) {
                    min = rowOfRain;
                }

                //check max rain among
                if (rowOfRain > max) {
                    max = rowOfRain;
                }

                day++;

                //Group value by year and month when month change
            } else if (rowOfYear == year && rowOfMonth == (month + 1) && rowOfDay != day) {

                //total rain
                rainAmong = totalOfNum;

                //Float or Integer value to String
                String rainAmongString = Double.toString(rainAmong);
                String maxString = Double.toString(max);
                String minString = Double.toString(min);
                String yearString = Integer.toString(year);
                String monthString = Integer.toString(month);

                //Make a list of row
                List<String> rowList = Arrays.asList(yearString, monthString, maxString, minString, rainAmongString);
                String rowListString = String.join(",", rowList);

                //test rowList
               // System.out.println(rowList);

                //Put row in analysed file
                TextIO.putln(rowListString);

                //reset day
                day = 2;
                //add month
                month++;
                //reset min value
                max = Double.NEGATIVE_INFINITY;
                //reset max value
                min = Double.POSITIVE_INFINITY;

                //sum rain among
                totalOfNum = rowOfRain;

                //check min rain among
                if (rowOfRain < min) {
                    min = rowOfRain;
                }

                //check max rain among
                if (rowOfRain > max) {
                    max = rowOfRain;
                }


                //Group value by year and month when year change
            } else if (rowOfYear == (year + 1) && rowOfMonth != month && rowOfDay != day) {

                //total rain
                rainAmong = totalOfNum;

                //Float or Integer value to String
                String rainAmongString = Double.toString(rainAmong);
                String maxString = Double.toString(max);
                String minString = Double.toString(min);
                String yearString = Integer.toString(year);
                String monthString = Integer.toString(month);

                //Make a list of row
                List<String> rowList = Arrays.asList(yearString, monthString, maxString, minString, rainAmongString);
                String rowListString = String.join(",", rowList);

                //test rowList
                //System.out.println(rowList);

                //Put row in analysed file
                TextIO.putln(rowListString);

                //reset day
                day = 2;
                //reset month
                month = 1;
                //add year
                year++;
                //reset min value
                max = Double.NEGATIVE_INFINITY;
                //reset max value
                min = Double.POSITIVE_INFINITY;

                //sum rain among
                totalOfNum = rowOfRain;

                //check min rain among
                if (rowOfRain < min) {
                    min = rowOfRain;
                }

                //check max rain among
                if (rowOfRain > max) {
                    max = rowOfRain;
                }
            }
        }

        //add Last row
        //total rain
        rainAmong = totalOfNum;


        //Float or Integer value to String
        String rainAmongString = Double.toString(rainAmong);
        String maxString = Double.toString(max);
        String minString = Double.toString(min);
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month);

        //Make a list of row
        List<String> rowList = Arrays.asList(yearString, monthString, maxString, minString, rainAmongString);
        String rowListString = String.join(",", rowList);

        //test rowList
        //System.out.println(rowList);

        //Put row in analysed file
        TextIO.putln(rowListString);

    }



    private static String generateOutputfile(String filename) {

        String[] fileParts = filename.split("\\.");

        //test output file name
      //  System.out.println(Arrays.toString(fileParts));

        return fileParts[0] + "_analysed.csv";
    }



}
