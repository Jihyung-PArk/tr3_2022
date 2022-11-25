package Week9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testToString() {

        String content = "How old is Ruchi?";
        String[] choices = {"18", "19", "20", "21"};
        int correctAns = 2;

        Question myQuestion = new Question(content, choices, correctAns);

        System.out.println(myQuestion);
    }
}