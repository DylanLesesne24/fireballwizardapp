package com.firewizapp.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class LessonsManagerTest {

    private LessonsManager lessonsManager;
    private UUID lessonId1;
    private Lessons musicLesson1;

    @Before
    public void setUp() {
        // Initialize the LessonsManager before each test
        lessonsManager = LessonsManager.getInstance();
        
        // Creating a test lesson related to music learning
        lessonId1 = UUID.randomUUID();
        musicLesson1 = new Lessons(lessonId1, "Music Theory Basics", "Learn about musical notes, scales, and intervals", Difficulty.EASY, "Content for Music Theory basics", 60);
    }

    // Test the Singleton pattern - Ensure there's only one instance of LessonsManager
    // Tested by Dylan Lesesne - Working
    @Test
    public void testSingleton() {
        LessonsManager anotherInstance = LessonsManager.getInstance();
        assertSame("LessonsManager should be a singleton, both instances should be the same", lessonsManager, anotherInstance);
    }

    // Test adding a music lesson
    // Tested by Dylan Lesesne - Working
    @Test
    public void testAddLesson() {
        lessonsManager.addLesson(lessonId1, musicLesson1);
        Lessons retrievedLesson = lessonsManager.getLesson(lessonId1);
        assertNotNull("Lesson should be added", retrievedLesson);
        assertEquals("Lesson title should be 'Music Theory Basics'", "Music Theory Basics", retrievedLesson.getTitle());
    }

    // Test retrieving a music lesson by ID
    // Tested by Dylan Lesesne - Working
    @Test
    public void testGetLesson() {
        lessonsManager.addLesson(lessonId1, musicLesson1);
        Lessons retrievedLesson = lessonsManager.getLesson(lessonId1);
        assertNotNull("Lesson should be found", retrievedLesson);
        assertEquals("Lesson title should be 'Music Theory Basics'", "Music Theory Basics", retrievedLesson.getTitle());
    }

    // Test getting all lessons related to music
    // Tested by Dylan Lesesne - Working
    @Test
    public void testGetLessons() {
        lessonsManager.addLesson(lessonId1, musicLesson1);
        assertEquals("There should be one lesson", 1, lessonsManager.getLessons().size());
    }

    // Test removing a music lesson by ID
    // Tested by Dylan Lesesne - Working
    @Test
    public void testRemoveLesson() {
        lessonsManager.addLesson(lessonId1, musicLesson1);
        boolean removed = lessonsManager.removeLesson(lessonId1);
        assertTrue("Lesson should be removed", removed);
        Lessons retrievedLesson = lessonsManager.getLesson(lessonId1);
        assertNull("Lesson should no longer exist", retrievedLesson);
    }

    // Test completing a music lesson
    // Tested by Dylan Lesesne - Working
    @Test
    public void testCompleteLesson() {
        lessonsManager.addLesson(lessonId1, musicLesson1);
        lessonsManager.completeLesson(lessonId1);
        Lessons retrievedLesson = lessonsManager.getLesson(lessonId1);
        assertTrue("Lesson should be marked as completed", retrievedLesson.isLessonCompleted());
    }

    // Test getting flashcards related to music theory for a lesson
    // Tested by Dylan Lesesne - Working
    @Test
    public void testGetFlashcardsForLesson() {
        Flashcards musicFlashcards = new Flashcards();
        musicFlashcards.makeFlashcard("What is a C major scale?", "C, D, E, F, G, A, B, C");
        musicLesson1.addFlashcard(musicFlashcards);

        lessonsManager.addLesson(lessonId1, musicLesson1);

        assertEquals("Flashcards should be returned for the lesson", 1, lessonsManager.getFlashcardsForLesson(lessonId1).size());
        assertEquals("The flashcard question should be 'What is a C major scale?'", "What is a C major scale?", lessonsManager.getFlashcardsForLesson(lessonId1).get(0).getFlashcard(0));
    }

    // Test handling of non-existent lesson ID for music lessons
    // Tested by Dylan Lesesne - Working
    @Test
    public void testGetLessonWithNonExistentID() {
        Lessons retrievedLesson = lessonsManager.getLesson(UUID.randomUUID());
        assertNull("Non-existent lesson should return null", retrievedLesson);
    }

    // Test adding flashcards related to music theory and retrieving them
    // Tested by Dylan Lesesne - Working
    @Test
    public void testAddFlashcards() {
        Flashcards musicFlashcards = new Flashcards();
        musicFlashcards.makeFlashcard("What is a musical interval?", "The difference in pitch between two notes");
        musicLesson1.addFlashcard(musicFlashcards);
        lessonsManager.addLesson(lessonId1, musicLesson1);

        assertEquals("Flashcards should be added", 1, lessonsManager.getFlashcardsForLesson(lessonId1).size());
    }

    // Test checking the answer to a flashcard related to music theory
    // Tested by Dylan Lesesne - Working
    @Test
    public void testCheckFlashcardAnswer() {
        Flashcards musicFlashcards = new Flashcards();
        musicFlashcards.makeFlashcard("What is a musical note?", "A sound with a specific pitch");
        musicLesson1.addFlashcard(musicFlashcards);
        lessonsManager.addLesson(lessonId1, musicLesson1);

        boolean isCorrect = lessonsManager.getFlashcardsForLesson(lessonId1).get(0).checkAnswer(0, "A sound with a specific pitch");
        assertTrue("The answer should be correct", isCorrect);
    }

    // Test completing a non-existent music lesson
    // Tested by Dylan Lesesne - Working
    @Test
    public void testCompleteNonExistentLesson() {
        boolean completed = lessonsManager.completeLesson(UUID.randomUUID());
        assertFalse("Completing a non-existent lesson should return false", completed);
    }
}
