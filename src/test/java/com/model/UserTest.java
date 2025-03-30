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
     Accessor Tests, real simple

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUsername()
    {
        assertEquals(TEST_USERNAME, testUser.getUsername());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetPassword()
    {
        assertEquals(TEST_PASSWORD, testUser.getPassword());
    }
    
    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetFirstName()
    {
        assertEquals(TEST_FIRSTNAME, testUser.getFirstName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetLastName()
    {
        assertEquals(TEST_LASTNAME, testUser.getLastName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetEmail()
    {
        assertEquals(TEST_EMAIL, testUser.getEmail());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetSkillLevel()
    {
        assertEquals(TEST_SKILLLEVEL, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testIsFilterEnabled()
    {
        assertTrue(testUser.isFilterEnabled());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetBadgesEarned()
    {
        assertArrayEquals(TEST_BADGES_EARNED, testUser.getBadgesEarned());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserID()
    {
        assertEquals(ID, testUser.getUserID());
    }

    */

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     * Testing for:
     * public boolean checkUsername(String inputUsername)
        {
            if (inputUsername == null || inputUsername.isEmpty() || inputUsername.contains(" "))
            {
                return false;
            }

            return this.username.equalsIgnoreCase(inputUsername);
        }
    

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameMatch()
    {
        assertTrue(testUser.checkUsername("testUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameMatchAllCaps()
    {
        assertTrue(testUser.checkUsername("TESTUSER"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameMatchMixed()
    {
        assertTrue(testUser.checkUsername("TestUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameLeadingSpace()
    {
        assertFalse(testUser.checkUsername(" testUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameTrailingSpace()
    {
        assertFalse(testUser.checkUsername("testUser "));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameInternalSpace()
    {
        assertFalse(testUser.checkUsername("te stUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameMatchFromList()
    {
        UserList userList = UserList.getInstance();

        // Manually add the testUser if not already present
        userList.addUser(TEST_FIRSTNAME, TEST_LASTNAME, TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_SKILLLEVEL, TEST_FILTER);

        assertTrue("Username 'TESTUSER' should match existing user ignoring case", userList.checkUsername("TESTUSER"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testNullUsername()
    {
        assertFalse("Null input should return false", testUser.checkUsername(null));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testEmptyUsername()
    {
        assertFalse("Empty input should return false", testUser.checkUsername(""));
    }
    */

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     * Testing for:
     *  public boolean checkPassword(String inputPassword)
        {
            if (inputPassword == null || inputPassword.isEmpty() || inputPassword.contains(" "))
            {
                return false;
            }

            return this.password.equals(inputPassword);
        }
    */

    @Test
    public void testPasswordAfterUsernameMatch()
    {
        UserList userList = UserList.getInstance();

        userList.checkUsername("testUser");
        assertTrue("Password 'testPassword' should match current login attempt user", userList.checkPassword("testPassword"));
    }
        
}
