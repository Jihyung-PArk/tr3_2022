package Assignment;

import textio.TextIO;

public class a1 {

    /**
     * Author: Jihyung Park
     * Version:
     * Date:
     * Description:
     */
    // define constants
    private static String OUTPUT_HEADER = "year,month,total,min,max";

    public static void main(String[] args) {
        System.out.println("Enter a filename: ");
        String filename = TextIO.getln();
        try {
            TextIO.readFile(filename);
            System.out.println("reading succesfully");
            //generate output file
            String outputFile = generateOutputFile(filename);
            generateMonthlyStatistics(outputFile);
        }
        catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    private static void generateMonthlyStatistics(String outputFile){
        float min = Float.NEGATIVE_INFINITY;
        float max = Float.POSITIVE_INFINITY;
        //read the first line and ignore it
        String line = TextIO.getln();
        //System.out.println(line);
        // for testing only - it is not satisfied the requirements
        TextIO.writeFile(outputFile);
        TextIO.putln(OUTPUT_HEADER);
        //System.out.println(line);
        if (line == null){
            System.out.println(" EMpty file . Aborted.");
            return;
        }
        // start extract the records
        int year = 0;
        byte currentMonth = 1;
        byte previousMonth = 1;
        double totalMonthlyRainfall = 0.0;
        double minMonthlyRainFall = Double.MAX_VALUE;
        double maxMonthlyRainfall = Double.MIN_VALUE;

        //testing : read second line
        int numOfRecords = 0;
        String[] record ;

        while (!TextIO.eof()) {
            line = TextIO.getln().trim();
            numOfRecords++;
            //extract info ....
            //and read again
            // line = TextIO.getln().trim();
            record = line.split(",");
            //extract year, month, day, rainfall from records
            // verify that you are in a new month
            // then save the information to the output file
            saveMonthlyRecord(year,currentMonth,totalMonthlyRainfall,minMonthlyRainFall,maxMonthlyRainfall);
            // otherwise update total monthlyRainfall, min and max
            // update the current month as well

        }
        System.out.println(numOfRecords);
/*    String[] record = TextIO.getln().trim().split(",");
//    System.out.println(Arrays.toString(record));     another way of putting the for loop
    for(int i=0 ; i < record.length;i++){
        System.out.println(record[i]);
    }
*/
    }

    private static void saveMonthlyRecord(int year, byte currentMonth, double totalMonthlyRainfall, double minMonthlyRainFall, double maxMonthlyRainfall) {


    }

    private static String generateOutputFile(String filename){
        String[] fileParts = filename.trim().split("\\.");
        // testing only
        String outputFile =fileParts[0]+"_analaysed.csv";
        //System.out.println(Arrays.toString(fileParts));
        return outputFile;
    }
}

