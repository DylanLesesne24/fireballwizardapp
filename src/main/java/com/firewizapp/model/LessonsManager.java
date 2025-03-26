package com.firewizapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class LessonsManager {
    private HashMap<UUID, Lessons> lessonsMap;
    private static LessonsManager instance;

    public LessonsManager() {
        this.lessonsMap = new HashMap<>();
    }

    public void addLesson(UUID id, Lessons lesson) {
        lessonsMap.put(id, lesson);
    }

    public Lessons getLesson(UUID id) {
        return lessonsMap.get(id);
    }

    public ArrayList<Lessons> getAllLessons() {
        return new ArrayList<>(lessonsMap.values());
    }

    public boolean removeLesson(UUID id) {
        return lessonsMap.remove(id) != null;
    }

    /**
     * Returns flashcards for the lesson specified by the index.
     * This method returns the first flashcard from the lesson's flashcards list,
     * or null if there are no flashcards.
     *
     * @param lessonIndex The index of the lesson in the list obtained from getAllLessons().
     * @return A Flashcards object, or null if not available.
     */
    public Flashcards getFlashcardsForLesson(int lessonIndex) {
        ArrayList<Lessons> lessons = getAllLessons();
        if (lessonIndex >= 0 && lessonIndex < lessons.size()) {
            Lessons lesson = lessons.get(lessonIndex);
            if (lesson.getFlashcards() != null && !lesson.getFlashcards().isEmpty()) {
                return lesson.getFlashcards().get(0); // Return the first flashcard as an example
            }
        }
        return null;
    }

    /**
     * Returns the singleton instance of LessonsManager.
     *
     * @return LessonsManager instance.
     */
    public static LessonsManager getInstance() {
        if (instance == null) {
            instance = new LessonsManager();
        }
        return instance;
    }

    /**
     * Marks the lesson at the given index as completed.
     * This method assumes the index corresponds to the list from getAllLessons().
     *
     * @param lessonIndex The index of the lesson.
     */
    public void completeLesson(int lessonIndex) {
        ArrayList<Lessons> lessons = getAllLessons();
        if (lessonIndex >= 0 && lessonIndex < lessons.size()) {
            Lessons lesson = lessons.get(lessonIndex);
            lesson.completeLesson(); // Assumes Lessons has a completeLesson() method
        } else {
            System.out.println("Invalid lesson index.");
        }
    }

    /**
     * Returns all lessons.
     *
     * @return An ArrayList of Lessons.
     */
    public ArrayList<Lessons> getLessons() {
        return getAllLessons();
    }
}
