package com.model;

import static org.junit.Assert.*;

import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import com.firewizapp.model.LessonsManager;
import com.firewizapp.model.Lessons;
import com.firewizapp.model.Flashcards;
import com.firewizapp.model.Difficulty;

public class LessonsManagerTest {

    private LessonsManager lessonsManager;
    private UUID lessonId;
    private Lessons lesson;
    private Flashcards flashcards;

    @Before
    public void setUp() {
        // Reset singleton instance (workaround for singleton in tests)
        lessonsManager = LessonsManager.getInstance();

        // Create a lesson with sample data
        lessonId = UUID.randomUUID();
        lesson = new Lessons(lessonId, "Music Theory Basics", "Introduction to Music Theory", Difficulty.EASY, "Music theory is the study of the practices and possibilities of music.", 30);
        
        // Add flashcards to the lesson
        flashcards = new Flashcards();
        flashcards.makeFlashcard("What is a musical scale?", "A series of notes ordered by pitch.");
        lesson.addFlashcard(flashcards);
    }

    // Tests adding a lesson and retrieving it
     //Tested by Dylan Lesesne - Working
    @Test
    public void testAddAndGetLesson() {
        lessonsManager.addLesson(lessonId, lesson);
        assertEquals(lesson, lessonsManager.getLesson(lessonId));
    }

    // Tests retrieving all lessons
     //Tested by Dylan Lesesne - Working
    @Test
    public void testGetLessons() {
        lessonsManager.addLesson(lessonId, lesson);
        assertTrue(lessonsManager.getLessons().contains(lesson));
    }

    // Tests removing a lesson
     //Tested by Dylan Lesesne - Working
    @Test
    public void testRemoveLesson() {
        lessonsManager.addLesson(lessonId, lesson);
        assertTrue(lessonsManager.removeLesson(lessonId));
        assertNull(lessonsManager.getLesson(lessonId));
    }

    // Tests getting flashcards from a lesson
     //Tested by Dylan Lesesne - Working
    @Test
    public void testGetFlashcardsForLesson() {
        lessonsManager.addLesson(lessonId, lesson);
        ArrayList<Flashcards> retrievedFlashcards = lessonsManager.getFlashcardsForLesson(lessonId);
        assertFalse(retrievedFlashcards.isEmpty());
        assertEquals(flashcards, retrievedFlashcards.get(0));
    }

    // Tests completing a lesson
    //Tested by Dylan Lesesne - Working
    @Test
    public void testCompleteLesson() {
        lessonsManager.addLesson(lessonId, lesson);
        lessonsManager.completeLesson(lessonId);
        assertTrue(lesson.isLessonCompleted());
    }
}
