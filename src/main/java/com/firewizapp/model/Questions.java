package com.firewizapp.model;

import java.util.List;

public class Questions {
    private String questionText;
    private List<String> answerChoices;
    private String correctAnswer;

    public Questions(String questionText, List<String> answerChoices, String correctAnswer) {
        this.questionText = questionText;
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
