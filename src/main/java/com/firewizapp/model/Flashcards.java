package com.firewizapp.model;

import java.util.HashMap;

/**
 * Represents a set of flashcards, each with a question and answer.
 */
public class Flashcards {
    private HashMap<Integer, String> questions;
    private HashMap<Integer, String> answers;

    /**
     * Constructs an empty Flashcards set.
     */
    public Flashcards() {
        questions = new HashMap<>();
        answers = new HashMap<>();
    }

    /**
     * Adds a new flashcard to the set.
     * 
     * @param question The question string
     * @param answer   The corresponding answer
     */
    public void makeFlashcard(String question, String answer) {
        int id = questions.size(); // simple ID based on count
        questions.put(id, question);
        answers.put(id, answer);
    }

    /**
     * Gets the flashcard question at the specified ID.
     * 
     * @param id The flashcard ID
     * @return The question string, or null if not found
     */
    public String getFlashcard(int id) {
        return questions.get(id);
    }

    /**
     * Checks if a user's answer is correct for the given flashcard ID.
     * 
     * @param id         The flashcard ID
     * @param userAnswer The user's answer input
     * @return true if correct, false otherwise
     */
    public boolean checkAnswer(int id, String userAnswer) {
        String correct = answers.get(id);
        return correct != null && correct.equalsIgnoreCase(userAnswer.trim());
    }

    /**
     * Returns the number of flashcards in this set.
     * 
     * @return number of flashcards
     */
    public int size() {
        return questions.size();
    }

    /**
     * Returns a formatted string of a flashcard (question + answer) for debugging.
     * 
     * @param id The flashcard ID
     * @return Formatted string or "Not found"
     */
    public String displayFlashcard(int id) {
        if (questions.containsKey(id) && answers.containsKey(id)) {
            return "Q: " + questions.get(id) + "\nA: " + answers.get(id);
        } else {
            return "Flashcard not found.";
        }
    }
}
