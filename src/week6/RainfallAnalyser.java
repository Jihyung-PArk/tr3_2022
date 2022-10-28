package week6;

import textio.TextIO;

public class RainfallAnalyser {

    public static void main(String[] args) {

        System.out.println("Enter a filename: ");

        String filename = TextIO.getln();
        System.out.println(filename);

        try {
            TextIO.readFile(filename);
            System.out.println("Reading successfully");
            generateMonthlyStatistics(filename);
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }

    private static void generateMonthlyStatistics(String filename) {
        String outputFile = generateOutputfile(filename);

        //read the first line and ignore it
        

    }

    private static String generateOutputfile(String filename) {

        String outputFile = "abc_analysed.csv";

        return outputFile;
    }

}
