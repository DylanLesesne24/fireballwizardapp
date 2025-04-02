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
        List<String> answerChoices = Arrays.asList("Paris", "London", "Rome", "Berlin");
        question = new Questions("What is the capital of France?", answerChoices, "Paris");
    }

    // Test constructor and getters
    // Tested by [Your Name] Working
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Question text should be 'What is the capital of France?'", "What is the capital of France?", question.getQuestionText());
        
        List<String> expectedAnswerChoices = Arrays.asList("Paris", "London", "Rome", "Berlin");
        assertEquals("Answer choices should match", expectedAnswerChoices, question.getAnswerChoices());
        
        assertEquals("Correct answer should be 'Paris'", "Paris", question.getCorrectAnswer());
    }

    // Test isCorrect method with correct answer
    // Tested by [Your Name] Working
    @Test
    public void testIsCorrectWithValidAnswer() {
        assertTrue("The answer 'Paris' should be correct", question.isCorrect("Paris"));
    }

    // Test isCorrect method with incorrect answer
    // Tested by [Your Name] Working
    @Test
    public void testIsCorrectWithInvalidAnswer() {
        assertFalse("The answer 'London' should be incorrect", question.isCorrect("London"));
    }

    // Test isCorrect method with case-insensitive comparison
    // Tested by [Your Name] Working
    @Test
    public void testIsCorrectCaseInsensitive() {
        assertTrue("The answer 'paris' should be correct despite case", question.isCorrect("paris"));
    }

    // Test isCorrect method with leading/trailing whitespace
    // Tested by [Your Name] Working
    @Test
    public void testIsCorrectWithWhitespace() {
        assertTrue("The answer '  Paris  ' should be correct despite extra whitespace", question.isCorrect("  Paris  "));
    }

    // Test isCorrect method with null answer
    // Tested by [Your Name] Working
    @Test
    public void testIsCorrectWithNullAnswer() {
        assertFalse("The answer 'null' should be incorrect", question.isCorrect(null));
    }

    // Test toString format (if you implement a toString method)
    // Tested by [Your Name] Working
    @Test
    public void testToStringFormat() {
        // If you want a toString method, you can check the output format
        String expected = "Questions{questionText='What is the capital of France?', answerChoices=[Paris, London, Rome, Berlin], correctAnswer='Paris'}";
        // Uncomment if you implement toString()
        // assertEquals("toString() output should match", expected, question.toString());
    }
}
