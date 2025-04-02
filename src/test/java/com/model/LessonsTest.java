package com.model;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Difficulty;
import com.firewizapp.model.Flashcards;
import com.firewizapp.model.Lessons;
import com.firewizapp.model.Quiz;

public class LessonsTest {

    private Lessons lesson;
    private UUID lessonID;

    @Before
    public void setUp() {
        lessonID = UUID.randomUUID();
        lesson = new Lessons(
            lessonID,
            "Intro to Music",
            "Basic intro to reading sheet music",
            Difficulty.EASY,
            "This lesson covers the basics of note reading.",
            15
        );
    }

    // Test that all constructor values are correctly set
    //Tested by Landen Worthy Working
    @Test
    public void testConstructorAndGetters() {
        assertEquals(lessonID, lesson.getLessonID());
        assertEquals("Intro to Music", lesson.getTitle());
        assertEquals("Basic intro to reading sheet music", lesson.getLessonDescription());
        assertEquals(Difficulty.EASY, lesson.getDifficultyLevel());
        assertEquals("This lesson covers the basics of note reading.", lesson.getContent());
        assertEquals(15, lesson.getEstimatedTime());
        assertFalse(lesson.isLessonCompleted());
    }

    // Test setting a lesson as completed
    //Tested by Landen Worthy working
    @Test
    public void testSetCompleted() {
        lesson.setCompleted(true);
        assertTrue(lesson.isLessonCompleted());
    }

    // Test adding flashcards to the lesson
    //Tested by Landen Worthy Working
    @Test
    public void testAddFlashcard() {
        Flashcards flashcard = new Flashcards();
        lesson.addFlashcard(flashcard);
        assertEquals(1, lesson.getFlashcards().size());
        assertEquals(flashcard, lesson.getFlashcards().get(0));
    }

    // Test adding quizzes to the lesson
    //Tested by Landen Worthy Working
    @Test
    public void testAddQuiz() {
        Quiz quiz = new Quiz(lessonID, null); 
        lesson.addQuiz(quiz);
        assertEquals(1, lesson.getQuizzes().size());
        assertEquals(quiz, lesson.getQuizzes().get(0));
    }

    // Test lesson summary format
    //Tested by Landen Worthy Working
    @Test
    public void testGetLessonSummary() {
        String summary = lesson.getLessonSummary();
        assertTrue(summary.contains("Title: Intro to Music"));
        assertTrue(summary.contains("Difficulty: EASY"));
        assertTrue(summary.contains("Estimated Time: 15"));
        assertTrue(summary.contains("Completed: false"));
    }
}
