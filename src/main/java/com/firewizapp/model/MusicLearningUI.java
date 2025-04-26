package com.firewizapp.model;

import com.firewizapp.model.MusicLearningFacade;
import com.firewizapp.model.Question;
import com.firewizapp.model.Quiz;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

/**
 * Simple console UI to interact with the Music Learning App.
 */
public class MusicLearningUI {

    private static MusicLearningFacade facade = MusicLearningFacade.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupSampleQuiz();
        startQuiz();
    }

    private static void setupSampleQuiz() {
        Quiz sampleQuiz = new Quiz(UUID.randomUUID(), "Basic Music Quiz");

        sampleQuiz.addQuestion(new Question(
                "What note gets 4 beats?",
                Arrays.asList("Quarter Note", "Half Note", "Whole Note", "Eighth Note"),
                2));
        sampleQuiz.addQuestion(new Question(
                "What symbol represents a rest?",
                Arrays.asList("♩", "𝄽", "♪", "♬"),
                1));
        sampleQuiz.addQuestion(new Question(
                "What is the meaning of 'forte' in music?",
                Arrays.asList("Soft", "Fast", "Slow", "Loud"),
                3));

        facade.addQuiz(sampleQuiz);
    }

    private static void startQuiz() {
        Quiz quiz = facade.getAllQuizzes().get(0);
        int score = 0;

        System.out.println("Starting Quiz: " + quiz.getTitle());

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question q = quiz.getQuestions().get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());

            for (int j = 0; j < q.getAnswerChoices().size(); j++) {
                System.out.println(j + ": " + q.getAnswerChoices().get(j));
            }

            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();

            if (quiz.checkAnswer(i, userChoice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer: " + q.getAnswerChoices().get(q.getCorrectAnswerIndex()));
            }
        }

        System.out.println("\nQuiz finished! Your score: " + score + "/" + quiz.getQuestions().size());
    }
}
