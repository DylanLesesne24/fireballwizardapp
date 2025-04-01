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
// Accessor Tests (getUsername, getPassword, getFirstName, getLastName, getEmail, getSkillLevel, getFilter, getBadgesEarned, getUserID)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

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
    public void testgetFilter()
    {
        assertTrue(testUser.getFilter());
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
    */

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
    */

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
    */
    
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
    

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public boolean meetsPassRequirements(String inputPassword)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for: 
     * 
     *  public boolean meetsPassRequirements(String inputPassword) 
        {
            if(inputPassword == null) //Null Pointer Check
            {
                return false;
            }

            if(inputPassword == "")
            {
                return false;
            }

            if(inputPassword.length() < 8 || inputPassword.length() > 26) // Length Check
            {
                return false;
            }

            if(!inputPassword.matches(".*\\d.*")) //Number check, this is a representation of 0-9
            {
                return false;
            }

            if(!inputPassword.matches(".*[\\p{Punct}].*"))//Special Character check
            {                                                                                                 //This includes special characters like: ! " # $ % & ' ( ) * + , - . / : ; < = > ? @ [ \ ] ^ _ ` { | } ~ but not spaces
                return false;
            }

            return true;
        }
    */
    

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordIsValid()
    {
        assertTrue(testUser.meetsPassRequirements("ValidPass123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithSpecialChar()
    {
        assertTrue(testUser.meetsPassRequirements("pass@word123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithInternalSpace()
    {
        assertFalse(testUser.meetsPassRequirements("pass word123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithLeadingSpace()
    {
        assertFalse(testUser.meetsPassRequirements(" password123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithTrailingSpace()
    {
        assertFalse(testUser.meetsPassRequirements("password123! "));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordIsNull()
    {
        assertFalse(testUser.meetsPassRequirements(null));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordIsEmpty()
    {
        assertFalse(testUser.meetsPassRequirements(""));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithNumbers()
    {
        assertTrue(testUser.meetsPassRequirements("1234pass!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordAllCaps()
    {
        assertTrue(testUser.meetsPassRequirements("PASSWORD123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordNoCaps()
    {
        assertTrue(testUser.meetsPassRequirements("password123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithTabCharacter()
    {
        assertFalse(testUser.meetsPassRequirements("pass\tword123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithNewlineCharacter()
    {
        assertFalse(testUser.meetsPassRequirements("pass\nword123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithEmoji()
    {
        assertFalse(testUser.meetsPassRequirements("pass💀word123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithUnicode()
    {
        assertFalse(testUser.meetsPassRequirements("パスワード123!"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordTooShort()
    {
        String shortPassword = "tosht1!";
        assertFalse(testUser.meetsPassRequirements(shortPassword));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordTooLong()
    {
        String longPassword = "thispasswordiswaytoolongtoaccept!";
        assertFalse(testUser.meetsPassRequirements(longPassword));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordOnlyDigits()
    {
        assertFalse(testUser.meetsPassRequirements("12345678"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordOnlySpecialCharacters()
    {
        assertFalse(testUser.meetsPassRequirements("!@#$%^&*"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithUnderscore()
    {
        assertTrue(testUser.meetsPassRequirements("pass_word123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithUnicodeSpace()
    {
        String password = "pass\u2002word123!";
        assertFalse(testUser.meetsPassRequirements(password));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithInvisibleCharacter()
    {
        String password = "pass\u200Fword123!";
        assertFalse(testUser.meetsPassRequirements(password));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testPasswordWithEnDash()
    {
        String password = "pass–word123!";
        assertFalse(testUser.meetsPassRequirements(password));
    }
    

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public void setSkillLevel(String SkillLevel)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for: 
     * 
     *  public void setSkillLevel(String SkillLevel)
        {
            if (SkillLevel == null || SkillLevel.trim().isEmpty())
            {
                return;
            }
    
            String input = SkillLevel.trim().toUpperCase();
    
            if (input.contains("PRO"))
            {
                this.skillLevel = "PRO";
            }

            else if (input.contains("INTER"))
            {
                this.skillLevel = "INTERMEDIATE";
            }

            else if (input.contains("BEGIN"))
            {
                this.skillLevel = "BEGINNER";
            }
        }
    */
    

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelToBeginner()
    {
        testUser.setSkillLevel("BEGINNER");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelToIntermediate()
    {
        testUser.setSkillLevel("INTERMEDIATE");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelToPro()
    {
        testUser.setSkillLevel("PRO");
        assertEquals("PRO", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelLowercase()
    {
        testUser.setSkillLevel("beginner");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelMixedCase()
    {
        testUser.setSkillLevel("InTeRmeDiaTe");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithLeadingSpaces()
    {
        testUser.setSkillLevel("   pro");
        assertEquals("PRO", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithTrailingSpaces()
    {
        testUser.setSkillLevel("beginner   ");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithInternalSpace()
    {
        testUser.setSkillLevel("Pro fessional");
        assertEquals("PRO", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithTabCharacter()
    {
        testUser.setSkillLevel("pro\t");
        assertEquals("PRO", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithNewlineCharacter()
    {
        testUser.setSkillLevel("inter\nmediate");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithEmoji()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("BEGINNER💀");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithUnicodeCharacters()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("初級");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithEnDash()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("BE–GINNER"); // EN DASH
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithInvisibleCharacter()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("PRO\u200F");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWithInternalTypos()
    {
        testUser.setSkillLevel("intermidiat");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelToUnknownValue()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("wizard");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelNullInput()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel(null);
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelEmptyInput()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelWhitespaceOnly()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("    ");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //
    // BEGINNER
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithSpace()
    {
        testUser.setSkillLevel("Beg inner");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithTab()
    {
        testUser.setSkillLevel("Beg\tinner");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithNewline()
    {
        testUser.setSkillLevel("Beg\ninner");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithInvisibleCharacter()
    {
        testUser.setSkillLevel("Beginner\u200F");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithEnDash()
    {
        testUser.setSkillLevel("BE–GINNER");
        assertEquals("BEGINNER", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithEmoji()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("BEGINNER💀");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelBeginnerWithUnicode()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("初級");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //
    // INTERMEDIATE
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithSpace()
    {
        testUser.setSkillLevel("Inter mediate");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithTab()
    {
        testUser.setSkillLevel("Inter\tmediate");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithNewline()
    {
        testUser.setSkillLevel("Inter\nmediate");
        assertEquals("INTERMEDIATE", testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithInvisibleCharacter()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("INTERMEDIATE\u200F");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithEnDash()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("INTER–MEDIATE");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithEmoji()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("INTERMEDIATE💀");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelIntermediateWithUnicode()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("中級");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //
    // PRO
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithSpace()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("P R O");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithTab()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("PR\tO");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithNewline()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("P\nRO");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithInvisibleCharacter()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("PRO\u200F");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithEnDash()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("PR–O");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithEmoji()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("PRO💀");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetSkillLevelProWithUnicode()
    {
        String originalSkill = testUser.getSkillLevel();
        testUser.setSkillLevel("専門");
        assertEquals(originalSkill, testUser.getSkillLevel());
    }
    

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public void setFilter(String Filter)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for: 
     * 
     *  public void setFilter(String Filter)
        {
            if (Filter == null || Filter.trim().isEmpty())
            {
                return;
            }

            if (!Filter.matches("^[\\p{ASCII}]+$"))
            {
                return;
            }

            String input = Filter.trim().toLowerCase();

            if (input.equals("yes") || input.equals("y"))
            {
                this.filter = true;
            }

            else if (input.equals("no") || input.equals("n"))
            {
                this.filter = false;
            }
        }
    */

    //
    // YES-type inputs
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesLowercase()
    {
        testUser.setFilter("yes");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesUppercase()
    {
        testUser.setFilter("YES");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesMixedCase()
    {
        testUser.setFilter("YeS");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterSingleLetterY()
    {
        testUser.setFilter("y");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithLeadingSpace()
    {
        testUser.setFilter("  yes");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithTrailingSpace()
    {
        testUser.setFilter("yes  ");
        assertTrue(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithTab()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("yes\t");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithNewline()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("yes\n");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithEnDash()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("ye–s");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithInvisibleCharacter()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("yes\u200F");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithEmoji()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("yes💀");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterYesWithUnicode()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("はい");
        assertEquals(original, testUser.getFilter());
    }

    //
    // NO-type inputs
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoLowercase()
    {
        testUser.setFilter("no");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoUppercase()
    {
        testUser.setFilter("NO");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoMixedCase()
    {
        testUser.setFilter("No");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterSingleLetterN()
    {
        testUser.setFilter("n");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithLeadingSpace()
    {
        testUser.setFilter("  no");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithTrailingSpace()
    {
        testUser.setFilter("no  ");
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithTab()
    {
        testUser.setFilter("yes"); // Start with TRUE
        assertTrue(testUser.getFilter());

        testUser.setFilter("no\t"); // Should be trimmed → "no" → valid
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithNewline()
    {
        testUser.setFilter("yes"); // Start with TRUE
        assertTrue(testUser.getFilter());

        testUser.setFilter("no\n"); // Should be trimmed → "no" → valid
        assertFalse(testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithEnDash()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("n–o");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithInvisibleCharacter()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("no\u200F");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithEmoji()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("no💀");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNoWithUnicode()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("いいえ"); // Japanese "no"
        assertEquals(original, testUser.getFilter());
    }

    //
    // Invalid input / fallback
    //

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterNullInput()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter(null);
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterEmptyInput()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterWhitespaceOnly()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("    ");
        assertEquals(original, testUser.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testSetFilterUnknownWord()
    {
        boolean original = testUser.getFilter();
        testUser.setFilter("maybe");
        assertEquals(original, testUser.getFilter());
    }
}