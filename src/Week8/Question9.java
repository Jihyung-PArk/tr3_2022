package Week8;

import java.io.IOException;

public class Question9 {

    static void processData() throws IOException{}

    public static void main(String[] args) {

        try{
            processData();
        }catch (IOException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
        

}
