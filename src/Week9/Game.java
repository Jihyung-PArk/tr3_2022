package Week9;

import java.util.ArrayList;

public class Game {

    private ArrayList<Question> questions = new ArrayList<>();
    private int point;

    /**
     *
     * @param point > 0
     */

    public Game(int point) {

        questions = new ArrayList<>();
        this.point = point;
    }

    public void addQuestion(Question question){

        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
