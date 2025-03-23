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
}

