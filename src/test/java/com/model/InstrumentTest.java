package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import com.firewizapp.model.Instrument;

public class InstrumentTest {

    private Instrument instrument;

    @Before
    public void setUp() {
        instrument = new Instrument("Guitar", "String", 50, true);
    }

    // Test constructor and getters
    // Tested by Dylan Lesesne Working
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Name should be 'Guitar'", "Guitar", instrument.getName());
        assertEquals("Type should be 'String'", "String", instrument.getType());
        assertEquals("Volume should be 50", 50, instrument.getVolume());
        assertEquals("Should be electric", true, instrument.isElectric());
    }

    // Test setters update fields correctly
    // Tested by Dylan Lesesne Working
    @Test
    public void testSettersUpdateFields() {
        instrument.setName("Piano");
        instrument.setType("Keyboard");
        instrument.setVolume(75);
        instrument.setElectric(false);

        assertEquals("Name should be updated", "Piano", instrument.getName());
        assertEquals("Type should be updated", "Keyboard", instrument.getType());
        assertEquals("Volume should be updated", 75, instrument.getVolume());
        assertEquals("Should be non-electric", false, instrument.isElectric());
    }

    // Test getDetails method returns expected format
    // Tested by Dylan Lesesne Working
    @Test
    public void testGetDetailsFormat() {
        String expected = "Instrument: Guitar\nType: String\nVolume: 50\nElectric: true";
        assertEquals("getDetails output should match", expected, instrument.getDetails());
    }

    // Test play method (no return value, check for exceptions)
    // Tested by Dylan Lesesne Working
    @Test
    public void testPlayDoesNotThrowException() {
        try {
            instrument.play();
        } catch (Exception e) {
            // If an exception occurs, the test will fail
            throw new AssertionError("play() should not throw an exception", e);
        }
    }

    // Test tune method (no return value, check for exceptions)
    // Tested by Dylan Lesesne Working
    @Test
    public void testTuneDoesNotThrowException() {
        try {
            instrument.tune();
        } catch (Exception e) {
            // If an exception occurs, the test will fail
            throw new AssertionError("tune() should not throw an exception", e);
        }
    }

    // Test stopPlaying method (no return value, check for exceptions)
    // Tested by Dylan Lesesne Working
    @Test
    public void testStopPlayingDoesNotThrowException() {
        try {
            instrument.stopPlaying();
        } catch (Exception e) {
            // If an exception occurs, the test will fail
            throw new AssertionError("stopPlaying() should not throw an exception", e);
        }
    }

    // Add a test for boundary testing with extreme values
    // Tested by Dylan Lesesne Working
    @Test
    public void testSetVolumeBoundary() {
        instrument.setVolume(0);  // Testing lower bound
        assertEquals("Volume should be set to 0", 0, instrument.getVolume());

        instrument.setVolume(100);  // Testing upper bound
        assertEquals("Volume should be set to 100", 100, instrument.getVolume());
    }

    // Add a test for null or invalid inputs (if your class could handle such cases)
    // Tested by Dylan Lesesne Working
    @Test
    public void testNullInputs() {
        try {
            Instrument invalidInstrument = new Instrument(null, null, -1, false);
            assertNotNull("Instrument should not be null", invalidInstrument);
            assertEquals("Instrument name should be null", null, invalidInstrument.getName());
            assertEquals("Instrument type should be null", null, invalidInstrument.getType());
            assertEquals("Volume should be -1", -1, invalidInstrument.getVolume());
            assertEquals("Electric should be false", false, invalidInstrument.isElectric());
        } catch (Exception e) {
            // Catch any error if null or invalid inputs are not allowed
            assertEquals("Exception should not be thrown with invalid values", null, e);
        }
    }

    // Add a test for checking a non-electric instrument's behavior
    @Test
    public void testNonElectricInstrument() {
        Instrument nonElectricInstrument = new Instrument("Violin", "String", 60, false);
        assertEquals("Instrument should be non-electric", false, nonElectricInstrument.isElectric());
        nonElectricInstrument.play();  // Should work for non-electric too
    }
}
