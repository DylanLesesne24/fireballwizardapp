package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Quiz;
import com.firewizapp.model.Questions;

import java.util.UUID;
import java.util.List;

public class QuizTest {

    private Quiz quiz;
    private Questions mockQuestion;

    @Before
    public void setUp() {
        quiz = new Quiz(UUID.randomUUID(), "Sample Quiz");
        mockQuestion = new Questions("What is the name of the musical note that lasts for two beats in 4/4 time?", "half note");
    }

    // Tested by Dylan Lesesne - Working
    @Test
    public void testConstructorAndGetters() {
        assertNotNull("Quiz ID should not be null", quiz.getQuizID());
        assertEquals("Title should be 'Sample Quiz'", "Sample Quiz", quiz.getTitle());
        assertTrue("Questions list should be empty initially", quiz.getQuestions().isEmpty());
    }

    // Tested by Dylan Lesesne - Working
    @Test
    public void testAddQuestion() {
        quiz.addQuestion(mockQuestion);
        assertEquals("Quiz should contain 1 question", 1, quiz.getQuestions().size());
        assertEquals("Added question should match", mockQuestion, quiz.getQuestions().get(0));
    }

    // Tested by Dylan Lesesne - Working
    @Test
    public void testCheckAnswerCorrect() {
        quiz.addQuestion(mockQuestion);
        assertTrue("Answer should be correct", quiz.checkAnswer(0, "half note"));
    }

    // Closing the class properly
}
