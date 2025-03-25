package com.firewizapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class LessonsManager {
    private HashMap<UUID, Lessons> lessonsMap;

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

    public Flashcards getFlashcardsForLesson(int lessonID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlashcardsForLesson'");
    }

    public static LessonsManager getInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
    }

    public void completeLesson(int lessonID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'completeLesson'");
    }

    public ArrayList<Lessons> getLessons() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLessons'");
    }
}
