package com.firewizapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Represents a music learning quiz consisting of multiple-choice questions.
 */
public class Quiz {
    private UUID quizID;
    private String title;
    private List<Question> questions;

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

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public boolean checkAnswer(int questionIndex, int selectedChoiceIndex) {
        if (questionIndex < 0 || questionIndex >= questions.size())
            return false;
        return questions.get(questionIndex).isCorrect(selectedChoiceIndex);
    }
}
