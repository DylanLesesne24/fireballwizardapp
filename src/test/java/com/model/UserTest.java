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

    private void ensureTestUserIsInUserList() //Forgot to use this on multiple methods, not gonna refactor everything, will start using in meetsUsernameRequirements and onward
    {
        UserList.getInstance().addUser(TEST_FIRSTNAME, TEST_LASTNAME, TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_SKILLLEVEL, TEST_FILTER);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Accessor Tests (getUsername, getPassword, getFirstName, getLastName, getEmail, getSkillLevel, isFilterEnabled, getBadgesEarned, getUserID)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
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
// Tests for: public boolean checkUsername(String inputUsername)
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
    */

    /*
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

    *The methods in the above comment were useless, keeping them for the sake of tracking what's been done
    */

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public boolean checkPassword(String inputPassword)
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
    

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordMatch()
    {
        assertTrue(testUser.checkPassword("testPassword"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordMatchMixed()
    {
        assertFalse(testUser.checkPassword("TestPassword")); // capital T
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordMatchAllCaps()
    {
        assertFalse(testUser.checkPassword("TESTPASSWORD"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordMatchNoCaps()
    {
        assertFalse(testUser.checkPassword("testpassword")); // correct except lowercase P
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordLeadingSpace()
    {
        assertFalse(testUser.checkPassword(" testPassword"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordTrailingSpace()
    {
        assertFalse(testUser.checkPassword("testPassword "));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordInternalSpace()
    {
        assertFalse(testUser.checkPassword("test Pass"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordAfterUsernameMatch()
    {
        UserList userList = UserList.getInstance();
        userList.addUser(TEST_FIRSTNAME, TEST_LASTNAME, TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_SKILLLEVEL, TEST_FILTER);

        userList.checkUsername("testUser");
        assertTrue("Password 'testPassword' should match current login attempt user", userList.checkPassword("testPassword"));
    }
    */

    /*
    //Tested by Laurin Johnson, WORKS
    @Test
    public void testNullPassword()
    {
        assertFalse(testUser.checkPassword(null));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testEmptyPassword()
    {
        assertFalse(testUser.checkPassword(""));
    }

    *The methods in the above comment were useless, keeping them for the sake of tracking what's been done
    */



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public boolean meetsUsernameRequirements(String inputUsername)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for: 
     * 
     *  public boolean meetsUsernameRequirements(String inputUsername)
        {
            if(inputUsername == null)
            {
                return false;
            }

            if(inputUsername == "")
            {
                return false;
            }

            if(inputUsername.contains(" "))
            {
                return false;
            }

            return true;
        }
    
    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameIsValid()
    {
        assertTrue(testUser.meetsUsernameRequirements("newUser123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithSpecialChar()
    {
        assertFalse(testUser.meetsUsernameRequirements("new@User"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithSpace()
    {
        assertFalse(testUser.meetsUsernameRequirements("new User"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameIsNull()
    {
        assertFalse(testUser.meetsUsernameRequirements(null));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameIsEmpty()
    {
        assertFalse(testUser.meetsUsernameRequirements(""));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameAlreadyExistsExact()
    {
        ensureTestUserIsInUserList();

        assertFalse(testUser.meetsUsernameRequirements("testUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameAlreadyExistsDifferentCase()
    {
        ensureTestUserIsInUserList();

        assertTrue(testUser.meetsUsernameRequirements("TestUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithNumbers()
    {
        assertTrue(testUser.meetsUsernameRequirements("user123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameAllCaps()
    {
        assertTrue(testUser.meetsUsernameRequirements("TESTUSERNAME"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameNoCaps()
    {
        assertTrue(testUser.meetsUsernameRequirements("testusername"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithTabCharacter()
    {
        assertFalse(testUser.meetsUsernameRequirements("user\tname"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithNewlineCharacter()
    {
        assertFalse(testUser.meetsUsernameRequirements("user\nname"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithEmoji()
    {
        assertFalse(testUser.meetsUsernameRequirements("user💀"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithUnicode()
    {
        assertFalse(testUser.meetsUsernameRequirements("ユーザー"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameTooLong()
    {
        String longUsername = "thisusernameiswaytoolonggggggg"; //30 characters, just so we know length
        assertFalse(testUser.meetsUsernameRequirements(longUsername));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameOnlyDigits()
    {
        assertTrue(testUser.meetsUsernameRequirements("1234567890"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameOnlySpecialCharacters()
    {
        assertFalse(testUser.meetsUsernameRequirements("!!!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithUnderscore()
    {
        assertFalse(testUser.meetsUsernameRequirements("user_name"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithUnicodeSpace()
    {
        // Unicode EN SPACE (U+2002) between "user" and "name"
        String username = "user\u2002name";
        assertFalse(testUser.meetsUsernameRequirements(username));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithInvisibleCharacter()
    {
        // Includes a Right-to-Left Mark (U+200F) — invisible but disruptive
        String username = "user\u200Fname";
        assertFalse(testUser.meetsUsernameRequirements(username));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUsernameWithEnDash()
    {
        // EN DASH (–), not a regular hyphen
        String username = "user–name";
        assertFalse(testUser.meetsUsernameRequirements(username));
    }
    */
}