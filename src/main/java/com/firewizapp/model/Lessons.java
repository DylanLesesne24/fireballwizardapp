package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;

public class Lessons {

    private UUID lessonID;
    private String title;
    private String lessonDescription;
    private Difficulty difficulty;
    private String content;
    private ArrayList<Flashcards> flashcards;
    private ArrayList<Quiz> quizzes;
    private int estimatedTime; // in minutes
    private boolean isCompleted;

    public Lessons(UUID lessonID, String title, String lessonDescription, Difficulty difficulty, String content,
            int estimatedTime) {
        this.lessonID = lessonID;
        this.title = title;
        this.lessonDescription = lessonDescription;
        this.difficulty = difficulty;
        this.content = content;
        this.flashcards = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.estimatedTime = estimatedTime;
        this.isCompleted = false;
    }

    // Getters
    public UUID getLessonID() {
        return lessonID;
    }

    public String getTitle() {
        return title;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public Difficulty getDifficultyLevel() {
        return difficulty;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Flashcards> getFlashcards() {
        return flashcards;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public boolean isLessonCompleted() {
        return isCompleted;
    }

    // Setters
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    // Logic
    public void addFlashcard(Flashcards flashcard) {
        flashcards.add(flashcard);
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public void startLesson() {
        System.out.println("Starting lesson: " + title);
    }

    public void completeLesson() {
        setCompleted(true);
        System.out.println("Lesson completed: " + title);
    }

    public String getLessonSummary() {
        return "Title: " + title + "\nDifficulty: " + difficulty + "\nEstimated Time: " + estimatedTime
                + " minutes\nCompleted: " + isCompleted;
    }
}
