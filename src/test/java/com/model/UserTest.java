package com.model;

import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.firewizapp.model.*;

public class UserTest {

    //For testing purposes
    private User testUser;
    private static final UUID ID = UUID.fromString("c3b9f5a4-91df-4c90-a3cc-f6415e6c1670");
    private static final String TEST_USERNAME = "testUser";
    private static final String TEST_PASSWORD = "testPassword";
    private static final String TEST_FIRSTNAME = "First";
    private static final String TEST_LASTNAME = "Last";
    private static final String TEST_EMAIL = "test@gmail.com";
    private static final String TEST_SKILLLEVEL = "BEGINNER";
    private static final boolean TEST_FILTER = true;
    private static final String[] TEST_BADGES_EARNED = {"Starting Guitar"};

    @Before
    public void setUp()
    {
        testUser = new User(ID,   //Giving each variable its own line is just for better legibility
                            TEST_USERNAME, 
                            TEST_PASSWORD, 
                            TEST_FIRSTNAME, 
                            TEST_LASTNAME,
                            TEST_EMAIL, 
                            TEST_SKILLLEVEL, 
                            TEST_FILTER, 
                            TEST_BADGES_EARNED);
    }

    /*

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUsername()
    {
        assertEquals(TEST_USERNAME, testUser.getUsername());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetPassword()
    {
        assertEquals(TEST_PASSWORD, testUser.getPassword());
    }
    
    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetFirstName()
    {
        assertEquals(TEST_FIRSTNAME, testUser.getFirstName());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetLastName()
    {
        assertEquals(TEST_LASTNAME, testUser.getLastName());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetEmail()
    {
        assertEquals(TEST_EMAIL, testUser.getEmail());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetSkillLevel()
    {
        assertEquals(TEST_SKILLLEVEL, testUser.getSkillLevel());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testIsFilterEnabled()
    {
        assertTrue(testUser.isFilterEnabled());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetBadgesEarned()
    {
        assertArrayEquals(TEST_BADGES_EARNED, testUser.getBadgesEarned());
    }

    *Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserID()
    {
        assertEquals(ID, testUser.getUserID());
    }
    */
}
