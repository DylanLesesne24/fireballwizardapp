package com.firewizapp.model;

import java.util.List;

/**
 * Represents a quiz question with multiple answer choices and a correct answer.
 * Used in the FireballWizardApp for practice quizzes and learning assessments.
 */
public class Questions {
    private String questionText;
    private List<String> answerChoices;
    private String correctAnswer;

    /**
     * Constructs a new {@code Questions} object with the specified question text,
     * answer choices, and correct answer.
     *
     * @param questionText  the text of the question
     * @param answerChoices a list of possible answer choices
     * @param correctAnswer the correct answer for the question
     */
    public Questions(String questionText, List<String> answerChoices, String correctAnswer) {
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the text of the question.
     *
     * @return the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns the list of possible answer choices.
     *
     * @return a list of answer choices
     */
    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    /**
     * Checks whether the provided user answer is correct.
     * Comparison is case-insensitive and ignores leading/trailing whitespace.
     *
     * @param userAnswer the answer provided by the user
     * @return {@code true} if the user's answer matches the correct answer,
     *         otherwise {@code false}
     */
    public boolean isCorrect(String userAnswer) {
        return userAnswer != null && correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    /**
     * Returns the correct answer for this question.
     *
     * @return the correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
