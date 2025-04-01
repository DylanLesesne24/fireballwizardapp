package com.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.firewizapp.model.User;
import com.firewizapp.model.UserList;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UserListTest{

    private UserList userList;

    @Before
    public void setUp()
    {
        userList = UserList.getInstance();
    }

    //Constructor Test of UserList(), for the sake of
    //Tested by Laurin Johnson, WORKS
    @Test
    public void testConstructorBehaviorViaGetInstance()
    {
        assertNotNull("Constructor should initialize the user list", userList.getUser("MusicLover98"));
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public static UserList getInstance()
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUserListSingletonInstanceIsNotNull()
    {
        assertNotNull("UserList instance should not be null", userList);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUserListSingletonAlwaysSameReference()
    {
        UserList instance1 = UserList.getInstance();
        UserList instance2 = UserList.getInstance();
        assertSame("Both instances should point to the same object", instance1, instance2);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUserListInitializesUserArray()
    {
        ArrayList<User> users = UserList.getUsers();
        assertNotNull("User array should be initialized and not null", users);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public User getUser(String username)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for:
     * 
     *  public User getUser(String username)
        {
            for (User user : users)
            {
                if (user.getUsername().equals(username))
                {
                    return user;
                }
            }

            throw new NoSuchElementException("User not found! Try again.");
        }
    */

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserExactMatch()
    {
        User user = UserList.getInstance().getUser("MusicLover98");
        assertEquals("Expected to find user with username 'MusicLover98'", "Susan", user.getFirstName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserNotFoundThrows()
    {
        assertThrows(NoSuchElementException.class, () -> userList.getUser("NoSuchUser123"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserCaseInsensitive()
    {
        User user = UserList.getInstance().getUser("musiclover98");
        assertEquals("Case-insensitive match should succeed", "Susan", user.getFirstName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testGetUserNullThrows()
    {
        assertThrows(IllegalArgumentException.class, () -> userList.getUser(null));
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public boolean addUser(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for:
     * 
     *  public boolean addUser(String firstName, String lastName, String username, String password, String email, String skillLevel, boolean filter)
        {
            users.add(new User(UUID.randomUUID(), username, password, firstName, lastName, email, skillLevel, filter, new String[] {}));

            return true;
        }
    */

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddUserReturnsTrue()
    {
        boolean added = userList.addUser("John", "Doe", "TestAddUser", "AddPass!23", "john.doe@example.com", "BEGINNER", true);
        assertTrue("User should be added successfully", added);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddedUserHasCorrectFirstName()
    {
        User user = userList.getUser("TestAddUser");
        assertEquals("First name should match", "John", user.getFirstName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddedUserHasCorrectSkillLevel()
    {
        User user = userList.getUser("TestAddUser");
        assertEquals("Skill level should match", "BEGINNER", user.getSkillLevel());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddedUserHasCorrectFilterSetting()
    {
        User user = userList.getUser("TestAddUser");
        assertTrue("Filter setting should match", user.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddMinimalUserReturnsTrue()
    {
        boolean added = userList.addUser("A", "B", "SimpleUser", "Pa$$w0rd!", "a@b.com", "PRO", false);
        assertTrue("Minimal user with valid data should be added", added);

        userList.getUsers().removeIf(u -> u.getUsername().equalsIgnoreCase("SimpleUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testMinimalUserFilterSetting()
    {
        userList.addUser("A", "B", "SimpleUser", "Pa$$w0rd!", "a@b.com", "PRO", false);
        User user = userList.getUser("SimpleUser");
        assertFalse("Minimal user filter setting should be false", user.getFilter());

        userList.getUsers().removeIf(u -> u.getUsername().equalsIgnoreCase("SimpleUser"));
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testMinimalUserUsernameStoredCorrectly()
    {
        userList.addUser("A", "B", "SimpleUser", "Pa$$w0rd!", "a@b.com", "PRO", false);
        User user = userList.getUser("SimpleUser");
        assertEquals("Username should be stored correctly", "SimpleUser", user.getUsername());

        userList.getUsers().removeIf(u -> u.getUsername().equalsIgnoreCase("SimpleUser"));
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Tests for: public static ArrayList<User> getUsers()
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    /*
     *  Testing for:
     * 
     *  public static ArrayList<User> getUsers()
        {
            if (users == null || users.isEmpty())
            {
                users = Data_Loader.loadUsers(); // Optionally, load users again if list is empty
            }

            return users;
        }
    */

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testUserListLoadedFromJson()
    {
        ArrayList<User> users = UserList.getUsers();
        assertTrue("Expected users list to contain at least 2 users", users.size() >= 2);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testJsonUserSusanExists()
    {
        boolean found = false;
        for (User u : UserList.getUsers())
        {
            if (u.getUsername().equals("MusicLover98")) {
                found = true;
                break;
            }
        }
        assertTrue("Susan (MusicLover98) should be found", found);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testJsonUserScottExists()
    {
        boolean found = false;
        for (User u : UserList.getUsers())
        {
            if (u.getUsername().equals("PianoMaster129")) {
                found = true;
                break;
            }
        }
        assertTrue("Scott (PianoMaster129) should be found", found);
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testRejectDuplicateScottEmailUpdate()
    {
        // Attempt to add a duplicate user with new details
        boolean result = userList.addUser("Scott", "Smith", "PianoMaster129", "PianoPass", "pianoKing99@yahoo.com", "PRO", true);
        // Expect the addUser call to be rejected (i.e. return false)
        assertFalse("Adding duplicate user should return false", result);
        // Retrieve the user and verify that the original email remains unchanged
        User user = userList.getUser("PianoMaster129");
        assertEquals("Email should remain unchanged", "PianoMaster@gmail.com", user.getEmail());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testRejectDuplicateScottLastNameUpdate()
    {
        // Attempt to add a duplicate user with new details
        boolean result = userList.addUser("Scott", "Smith", "PianoMaster129", "PianoPass", "pianoKing99@yahoo.com", "PRO", true);
        // Expect the addUser call to be rejected (i.e. return false)
        assertFalse("Adding duplicate user should return false", result);
        // Retrieve the user and verify that the original last name remains unchanged
        User user = userList.getUser("PianoMaster129");
        assertEquals("Last name should remain unchanged", "Mack", user.getLastName());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testAddAndReferenceNewUser()
    {
        // Add a new user with a unique username
        boolean added = userList.addUser("Alice", "Wonderland", "UniqueUser1", "Secret123", "alice@example.com", "BEGINNER", false);
        assertTrue("Expected addUser to succeed for a unique user", added);
    
        // Retrieve the added user
        User user = userList.getUser("UniqueUser1");
        assertNotNull("The added user should be retrievable", user);
    
        // Verify the user's details
        assertEquals("First name should match", "Alice", user.getFirstName());
        assertEquals("Last name should match", "Wonderland", user.getLastName());
        assertEquals("Email should match", "alice@example.com", user.getEmail());
        assertEquals("Skill level should match", "BEGINNER", user.getSkillLevel());
        assertFalse("Filter setting should be false", user.getFilter());
    }

    //Tested by Laurin Johnson, WORKS
    @Test
    public void testScottSkillLevelFromJson()
    {
        User user = userList.getUser("PianoMaster129");
        assertEquals("Skill level should be 'PRO'", "PRO", user.getSkillLevel());
    }
}
