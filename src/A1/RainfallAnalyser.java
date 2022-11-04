package A1;

import textio.TextIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RainfallAnalyser {

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
        int year ;
        int month;
        int day;
        int countNumOfRain = 0;
        float totalOfNum = 0;
        float rainAmong;
        float max = Float.NEGATIVE_INFINITY;
        float min = Float.POSITIVE_INFINITY;
        float average;
        String[] record;
        int rowNum = 0;
        String[][] newFile;




        try{
            Scanner scanner = new Scanner(new FileReader(filename));


            while (scanner.hasNextLine()){
                scanner.nextLine();
                lineCount++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //check total row
        //System.out.println(lineCount);


        //read the first line and ignore it
        String line = TextIO.getln();

        //for testing only = it is not satisfied the required
        TextIO.writeFile(outputFile);


        //first row of new file
        TextIO.putln("Year,Month,Total,Average,Min,Max");

        //testing
        //System.out.println(line);



        if(TextIO.eof()){
            System.out.println("Empty file. Aborted");
            return;
        }

        //make 2D array
        newFile = new String[lineCount][8];



        while (!TextIO.eof()){


            //and read again
            line = TextIO.getln().trim();


            //extract info...
            record = line.split(",");

            //add miss data to 0
            if (record.length == 5){
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
        month = Integer.parseInt(newFile[0][3]);
        day = Integer.parseInt(newFile[0][4]);


        for (String[] strings : newFile) {

            // String array value to Integer or Float
            int rowOfYear = Integer.parseInt(strings[2]);
            int rowOfMonth = Integer.parseInt(strings[3]);
            int rowOfDay = Integer.parseInt(strings[4]);
            float rowOfRain = Float.parseFloat(strings[5]);

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

                //check rain
                if (rowOfRain != 0) {
                    countNumOfRain++;
                }
                day++;

                //Group value by year and month when month change
            } else if (rowOfYear == year && rowOfMonth == (month + 1) && rowOfDay != day) {

                //total rain
                rainAmong = totalOfNum;
                //average rain among
                average = totalOfNum / countNumOfRain;

                //Float or Integer value to String
                String rainAmongString = Float.toString(rainAmong);
                String averageString = Float.toString(average);
                String maxString = Float.toString(max);
                String minString = Float.toString(min);
                String yearString = Integer.toString(year);
                String monthString = Integer.toString(month);

                //Make a list of row
                List<String> rowList = Arrays.asList(yearString, monthString, rainAmongString, averageString, minString, maxString);
                String rowListString = String.join(",", rowList);

                //test rowList
                System.out.println(rowList);

                //Put row in analysed file
                TextIO.putln(rowListString);

                //reset count rain day
                countNumOfRain = 0;
                //reset day
                day = 2;
                //add month
                month++;
                //reset min value
                max = Float.NEGATIVE_INFINITY;
                //reset max value
                min = Float.POSITIVE_INFINITY;

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

                //check rain
                if (rowOfRain != 0) {
                    countNumOfRain++;
                }

                //Group value by year and month when year change
            } else if (rowOfYear == (year + 1) && rowOfMonth != month && rowOfDay != day) {

                //total rain
                rainAmong = totalOfNum;
                //average rain among
                average = totalOfNum / countNumOfRain;

                //Float or Integer value to String
                String rainAmongString = Float.toString(rainAmong);
                String averageString = Float.toString(average);
                String maxString = Float.toString(max);
                String minString = Float.toString(min);
                String yearString = Integer.toString(year);
                String monthString = Integer.toString(month);

                //Make a list of row
                List<String> rowList = Arrays.asList(yearString, monthString, rainAmongString, averageString, minString, maxString);
                String rowListString = String.join(",", rowList);

                //test rowList
                System.out.println(rowList);

                //Put row in analysed file
                TextIO.putln(rowListString);

                //reset count rain day
                countNumOfRain = 0;
                //reset day
                day = 2;
                //reset month
                month = 1;
                //add year
                year++;
                //reset min value
                max = Float.NEGATIVE_INFINITY;
                //reset max value
                min = Float.POSITIVE_INFINITY;

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

                //check rain
                if (rowOfRain != 0) {
                    countNumOfRain++;
                }
            }
        }

        //add Last row
        //total rain
        rainAmong = totalOfNum;
        //average rain among
        average = totalOfNum / countNumOfRain;

        //Float or Integer value to String
        String rainAmongString = Float.toString(rainAmong);
        String averageString = Float.toString(average);
        String maxString = Float.toString(max);
        String minString = Float.toString(min);
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month);

        //Make a list of row
        List<String> rowList = Arrays.asList(yearString, monthString, rainAmongString, averageString, minString, maxString);
        String rowListString = String.join(",", rowList);

        //test rowList
        System.out.println(rowList);

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
