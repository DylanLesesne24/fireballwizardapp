package com.firewizapp.model;

import java.util.HashMap;

/**
 * Represents a set of flashcards, each with a question and answer.
 */
public class Flashcards {

    private HashMap<Integer, String> questions;
    private HashMap<Integer, String> answers;

    // Constructor
    public Flashcards() {
        questions = new HashMap<>();
        answers = new HashMap<>();
    }

    // Add a new flashcard
    public void makeFlashcard(String question, String answer) {
        int id = questions.size();
        questions.put(id, question);
        answers.put(id, answer);
    }

    // Get a question by ID
    public String getFlashcard(int id) {
        return questions.get(id);
    }

    // Check the user's answer against the correct one
    public boolean checkAnswer(int id, String userAnswer) {
        String correctAnswer = answers.get(id);
        return correctAnswer != null && correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    // Display a flashcard's question and answer
    public String displayFlashcard(int id) {
        if (questions.containsKey(id) && answers.containsKey(id)) {
            return "Q: " + questions.get(id) + "\nA: " + answers.get(id);
        }
        return "Flashcard not found.";
    }

    // Returns the number of flashcards
    public int size() {
        return questions.size();
    }
}
