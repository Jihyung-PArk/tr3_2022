package week6;

import textio.TextIO;

import java.util.Arrays;

public class RainfallAnalyser {

    public static void main(String[] args) {

        System.out.print("Enter a filename: ");

        String filename = TextIO.getln();
        System.out.println(filename);

        try {
            TextIO.readFile(filename);
            System.out.println("Reading successfully");

            //generate output file
            String outputFile = generateOutputfile(filename);

            //save monthly total, min and max to output file
            generateMonthlyStatistics(outputFile);
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }

    private static void generateMonthlyStatistics(String outputFile) {


        //read the first line and ignore it
        String line = TextIO.getln();

        //for testing only = it is not satisfied the required
        TextIO.writeFile(outputFile);

        //TextIO.writeFile(generateOutputfile(filename));

        TextIO.putln("Year,Month,Total,Min,Max");

        //testing
        System.out.println(line);



        if(TextIO.eof()){
            System.out.println("Empty file. Aborted");
            return;
        }

        //start extract the records

        //testing : read second line

        int numOfRecords = 0;
        String[] record;


        if(!TextIO.eof()){
            line = TextIO.getln().trim();
            numOfRecords ++;
            //extract info...
            record = line.split(",");
            //...
        }

        while (!TextIO.eof()){

            //and read again
            line = TextIO.getln().trim();
            numOfRecords ++;
            //extract info...
            record = line.split(",");
            //

        }

        System.out.println(numOfRecords);

        /*
        System.out.println(Arrays.toString(record));

        for(int i = 0; i < record.length; i++){
            System.out.println(record[i]);
            }
         */
    }

    private static String generateOutputfile(String filename) {

        String[] fileParts = filename.split("\\.");

        System.out.println(Arrays.toString(fileParts));
        String outputFile = fileParts[0] + "_analyed.csv";

        return outputFile;
    }

}
