package Week7;

import java.util.ArrayList;

public class Question7 {

    public static void main(String[] args) {

        String nextLetter;

        ArrayList<String> strlst = new ArrayList<String>();


        String firstLexicographic = strlst.get(0);

        for( int i = 0; i < strlst.size(); i++){
            nextLetter = strlst.get(i);
            if(nextLetter.compareTo(firstLexicographic) < 0){
                firstLexicographic = nextLetter;
            }
        }

        System.out.println(firstLexicographic);
    }

}
