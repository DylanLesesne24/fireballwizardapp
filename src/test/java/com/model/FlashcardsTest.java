package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Flashcards;

public class FlashcardsTest {

    private Flashcards flashcards;

    @Before
    public void setUp() {
        flashcards = new Flashcards();
    }

    // Tests that flashcards are added correctly and size returns the correct count
    //Tested by Landen Worthy Working
    @Test
    public void testMakeFlashcardAndSize() {
        flashcards.makeFlashcard("What is Java?", "A programming language");
        flashcards.makeFlashcard("What is 2 + 2?", "4");

        assertEquals(2, flashcards.size());
    }

    // Tests retrieving a question by ID after adding it
    //Tested by Landen Worthy Working
    @Test
    public void testGetFlashcard() {
        flashcards.makeFlashcard("What is Java?", "A programming language");

        assertEquals("What is Java?", flashcards.getFlashcard(0));
        assertNull(flashcards.getFlashcard(1)); // No flashcard at ID 1
    }

    // Tests that correct answers (even with spaces or different casing) are recognized
    //Tested by Landen Worthy Working
    @Test
    public void testCheckAnswerCorrect() {
        flashcards.makeFlashcard("Capital of France?", "Paris");

        assertTrue(flashcards.checkAnswer(0, "Paris"));
        assertTrue(flashcards.checkAnswer(0, "  paris  ")); 
    }

    // Tests that incorrect answers return false
    //Tested by Landen Worthy Working
    @Test
    public void testCheckAnswerIncorrect() {
        flashcards.makeFlashcard("Capital of France?", "Paris");

        assertFalse(flashcards.checkAnswer(0, "London"));
    }

    // Tests that the displayFlashcard method returns the correct formatted output
    //Tested by Landen Worthy Working
    @Test
    public void testDisplayFlashcard() {
        flashcards.makeFlashcard("Sun rises in the?", "East");

        String expected = "Q: Sun rises in the?\nA: East";
        assertEquals(expected, flashcards.displayFlashcard(0));
    }

    // Tests displayFlashcard for an ID that doesn't exist
    //Tested by Landen Worthy Working
    @Test
    public void testDisplayFlashcardNotFound() {
        assertEquals("Flashcard not found.", flashcards.displayFlashcard(99));
    }
}
