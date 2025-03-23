package com.firewizapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Quiz {
    private UUID quizID;
    private String title;
    private List<Questions> questions;  // Updated from Question to Questions

    public Quiz(UUID quizID, String title) {
        this.quizID = quizID;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public UUID getQuizID() {
        return quizID;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Questions question) {
        questions.add(question);
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public boolean checkAnswer(int questionIndex, String userAnswer) {
        if (questionIndex < 0 || questionIndex >= questions.size()) return false;
        return questions.get(questionIndex).isCorrect(userAnswer);
    }
}
