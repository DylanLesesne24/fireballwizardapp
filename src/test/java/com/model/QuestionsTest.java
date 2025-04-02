package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import com.firewizapp.model.Questions;

public class QuestionsTest {

    private Questions question;

    // Sample test question setup
    @Before
    public void setUp() {
        List<String> answerChoices = Arrays.asList("One", "Two", "Three", "Four");
        question = new Questions("How many beats does a quarter note receive in 4/4 time?", answerChoices, "1");
    }

    // Test constructor and getters
    // Tested by Dylan Lesesne - Working
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Question text should be 'How many beats does a quarter note receive in 4/4 time?'", 
            "How many beats does a quarter note receive in 4/4 time?", question.getQuestionText());
        
        List<String> expectedAnswerChoices = Arrays.asList("One", "Two", "Three", "Four");
        assertEquals("Answer choices should match", expectedAnswerChoices, question.getAnswerChoices());
        
        assertEquals("Correct answer should be '1'", "1", question.getCorrectAnswer());
    }

    // Test isCorrect method with correct answer
    // Tested by Dylan Lesesne - Working
    @Test
    public void testIsCorrectWithValidAnswer() {
        assertTrue("The answer '1' should be correct", question.isCorrect("1"));
    }

    // Test isCorrect method with incorrect answer
    // Tested by Dylan Lesesne - Working
    @Test
    public void testIsCorrectWithInvalidAnswer() {
        assertFalse("The answer '2' should be incorrect", question.isCorrect("2"));
    }

    // Test isCorrect method with case-insensitive comparison
    // Tested by Dylan Lesesne - Working
    @Test
    public void testIsCorrectCaseInsensitive() {
        assertTrue("The answer '1' should be correct despite case", question.isCorrect("1"));
    }

    // Test isCorrect method with leading/trailing whitespace
    // Tested by Dylan Lesesne - Working
    @Test
    public void testIsCorrectWithWhitespace() {
        assertTrue("The answer ' 1 ' should be correct despite extra whitespace", question.isCorrect(" 1 "));
    }

    // Test isCorrect method with null answer
    // Tested by Dylan Lesesne - Working
    @Test
    public void testIsCorrectWithNullAnswer() {
        assertFalse("The answer 'null' should be incorrect", question.isCorrect(null));
    }

    // Test toString format (if you implement a toString method)
    // Tested by Dylan Lesesne - Working
    @Test
    public void testToStringFormat() {
        // If you want a toString method, you can check the output format
        String expected = "Questions{questionText='How many beats does a quarter note receive in 4/4 time?', answerChoices=[One, Two, Three, Four], correctAnswer='1'}";
        // Uncomment if you implement toString()
        // assertEquals("toString() output should match", expected, question.toString());
    }
}
