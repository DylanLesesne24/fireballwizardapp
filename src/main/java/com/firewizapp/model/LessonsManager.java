package com.firewizapp.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Singleton class for managing lessons.
 */
public class LessonsManager {
    private static LessonsManager instance;
    private HashMap<UUID, Lessons> lessons;

    // Private constructor for singleton pattern
    private LessonsManager() {
        lessons = new HashMap<>();
    }

    // Get the singleton instance
    public static LessonsManager getInstance() {
        if (instance == null) {
            instance = new LessonsManager();
        }
        return instance;
    }

    // Add a lesson
    public void addLesson(UUID lessonId, Lessons lesson) {
        lessons.put(lessonId, lesson);
    }

    // Get a lesson by ID
    public Lessons getLesson(UUID lessonId) {
        return lessons.get(lessonId);
    }

    // Get all lessons
    public ArrayList<Lessons> getLessons() {
        return new ArrayList<>(lessons.values());
    }

    // Remove a lesson by ID
    public boolean removeLesson(UUID lessonId) {
        return lessons.remove(lessonId) != null;
    }

    // Get flashcards for a given lesson
    public ArrayList<Flashcards> getFlashcardsForLesson(UUID lessonId) {
        Lessons lesson = lessons.get(lessonId);
        if (lesson != null) {
            return lesson.getFlashcards();
        }
        return new ArrayList<>();
    }

    // Complete a lesson
    public void completeLesson(UUID lessonId) {
        Lessons lesson = lessons.get(lessonId);
        if (lesson != null) {
            lesson.setCompleted(true);
        }
    }
}
