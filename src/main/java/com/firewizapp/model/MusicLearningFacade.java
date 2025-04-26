package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class MusicLearningFacade {

    private static MusicLearningFacade instance;
    private ArrayList<Quiz> quizzes;

    private MusicLearningFacade() {
        quizzes = new ArrayList<>();
        loadDefaultQuizzes(); // <<-- ADDED HERE
    }

    public static MusicLearningFacade getInstance() {
        if (instance == null) {
            instance = new MusicLearningFacade();
        }
        return instance;
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public ArrayList<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Quiz getQuizById(UUID quizID) {
        for (Quiz q : quizzes) {
            if (q.getQuizID().equals(quizID)) {
                return q;
            }
        }
        return null;
    }

    // NEW: Load a default quiz if none exist
    private void loadDefaultQuizzes() {
        Quiz sampleQuiz = new Quiz(UUID.randomUUID(), "Music Basics");

        sampleQuiz.addQuestion(new Question(
                "What is the symbol for a sharp note?",
                List.of("♯", "♭", "♮", "𝄐"),
                0));

        sampleQuiz.addQuestion(new Question(
                "How many lines are there in a musical staff?",
                List.of("4", "5", "6", "7"),
                1));

        quizzes.add(sampleQuiz);
    }
}
