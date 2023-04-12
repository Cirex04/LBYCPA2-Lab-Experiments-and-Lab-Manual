package quiz.queue.labact3;

import java.util.Arrays;

/**
 * @brief Blueprint for Question class to simulate pseudo-quiz
 */

public class Questions implements QuestionnaireInteface {
    /**
     * properties
     */
    private String question;
    private String[] answers;
    private int correctAnswer;

    /**
     * constructors
     */
    public Questions(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    /**
     * behaviors
     */
    @Override
    public String question() {
        return question;
    }

    @Override
    public String[] multipleChoiceLabel() {
        return answers;
    }

    @Override
    public int correctAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return question + "\n" + Arrays.toString(answers) + "\n" + correctAnswer;
    }
}
