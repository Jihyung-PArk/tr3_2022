package Week9;

public class Question {

   private String content;
   private String[] choices;
   private int correctAns = 0;

    @Override
    public String toString() {
        return "Question :\n" +
                content +"\n"+
                "Choices :\n"+
                choices[0] +"\n"+
                choices[1] +"\n"+
                choices[2] +"\n"+
                choices[3] +"\n"+
                "Answer :\n" +
                correctAns+"\n";
    }

    public Question(String content, String[] choices, int correctAns) {
        /**
         * pre-condition : choices is array of 4 strings
         */
        this.content = content;
        this.choices = choices;
        this.correctAns = correctAns;
    }

    public static void main(String[] args) {


    }

}
