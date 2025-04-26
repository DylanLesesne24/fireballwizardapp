package com.firewizapp.model;

import java.util.List;

/**
 * Represents a quiz question with multiple answer choices and a correct answer
 * index.
 */
public class Question {
    private String questionText;
    private List<String> answerChoices;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> answerChoices, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isCorrect(int selectedIndex) {
        return selectedIndex == correctAnswerIndex;
    }
}
