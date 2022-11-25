package Week9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void addQuestion() {

        Game ourGame = new Game(10);

        String content = "How old is Ruchi?";
        String[] choices = {"18", "19", "20", "21"};
        int correctAns = 2;

        Question myQuestion = new Question(content, choices, 2);
        ourGame.addQuestion(myQuestion);

        String content1 = "How old is Park?";
        String[] choices1 = {"18", "19", "20", "21"};
        int correctAns1 = 3;

        Question myQuestion1 = new Question(content1, choices1, 3);
        ourGame.addQuestion(myQuestion1);

        for(Question q: ourGame.getQuestions()){
            System.out.println(q);
        }

        for(int i = 0; i<ourGame.getQuestions().size(); i ++){
            System.out.println(ourGame.getQuestions().get(i));
        }
    }
}