package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Facade class that simplifies access to the core components of the music
 * learning app.
 */
public class MusicLearningFacade {

    private static MusicLearningFacade instance;
    private ArrayList<Quiz> quizzes;

    private MusicLearningFacade() {
        quizzes = new ArrayList<>();
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
}
