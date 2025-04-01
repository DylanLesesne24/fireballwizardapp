package com.firewizapp.model;

import java.util.UUID;

/**
 * Represents a user in the FireWiz application. Stores identifying information such as name,
 * email, skill level, and preferences like word filtering and earned badges.
 * Includes methods for validating credentials, setting user attributes, and handling basic authentication.
*/
public class User {

    private UUID userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String skillLevel;
    private boolean filter;
    private String[] badgesEarned;

    /**
     * Makes a new User object based on input values
     * Tested by Laurin Johnson, WORKS
     * 
     * @param id
     * @param Username
     * @param Password
     * @param FirstName
     * @param LastName
     * @param Email
     * @param SkillLevel
     * @param Filter
     * @param BadgesEarned
    */
    public User(UUID id, String Username, String Password, String FirstName, String LastName, String Email,
            String SkillLevel, boolean Filter, String[] BadgesEarned) {
        this.userID = id;
        this.username = Username;
        this.password = Password;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = Email;
        this.skillLevel = SkillLevel;
        this.filter = Filter;
        this.badgesEarned = BadgesEarned;

    }

    /**
     * Accessor for the User's first name
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's first name
    */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Accessor for the User's last name
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's last name
    */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Accessor for the User's username
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's username
    */
    public String getUsername() {
        return username;
    }

    /**
     * Accessor for the User's password
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's password
    */
    public String getPassword() {
        return password;
    }

    /**
     * Accessor for the User's UUID
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's UUID
    */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Accessor for the User's email
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's email
    */
    public String getEmail() {
        return email;
    }

    /**
     * Accessor for the User's filter preference
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's filter preference
    */
    public boolean getFilter() {
        return this.filter;
    }

    /**
     * Accessor for the User's earned badges
     * Tested by Laurin Johnson, WORKS
     * 
     * @return Array of User's earned badges
    */
    public String[] getBadgesEarned() {
        return this.badgesEarned;
    }

    /**
     * Accessor for the User's skill level
     * Tested by Laurin Johnson, WORKS
     * 
     * @return User's skill level
    */
    public String getSkillLevel() {
        return skillLevel;
    }

    /**
     * Checks whether the given input username matches the user's username (case-insensitive). Assumes invalid usernames have already been filtered.
     * Tested by Laurin Johnson, WORKS
     * 
     * @param inputUsername
     * @return true if the usernames match, false otherwise
    */
    public boolean checkUsername(String inputUsername)
    {
        return this.username.equalsIgnoreCase(inputUsername); //Most username logins I've seen ignore case - Laurin Johnson (so you know who wrote this)
    }

    /**
     * Checks whether the given input password matches the user's password (case-sensitive). Assumes invalid passwords have already been filtered.
     * Tested by Laurin Johnson, WORKS
     * 
     * @param inputPassword
     * @return true if the passwords match, false otherwise
    */
    public boolean checkPassword(String inputPassword)
    {
        return this.password.equals(inputPassword);
    }

    /**
     * Validates whether the given username meets requirements:
     * - Not null or empty
     * - No spaces, tabs, or newlines
     * - Only contains alphanumeric characters
     * - Less than or equal to 26 characters
     * - Does not match an existing username (case-sensitive)
     *
     * Tested by Laurin Johnson, WORKS
     * 
     * @param inputUsername
     * @return true if the username meets all requirements, false otherwise
    */
    public boolean meetsUsernameRequirements(String inputUsername)
    {
        if(inputUsername == null) //null check
        {
            return false;
        }

        if(inputUsername == "") //empty check
        {
            return false;
        }

        if (inputUsername.contains(" ") || inputUsername.contains("\t") || inputUsername.contains("\n")) //Space, newline, and tab check
        {
            return false; // no whitespace of any kind
        }

        if (!inputUsername.matches("[a-zA-Z0-9]+")) //I don't think special characters should be allowed in a username - Laurin Johnson
        {
            return false;
        }

        if (inputUsername.length() > 26) //Max length of username is 26 characters
        {
            return false;
        }

        for (User existingUser : UserList.getUsers()) //Checks for an already existing username, must match exactly
        {
            if (existingUser.getUsername().equals(inputUsername))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates whether the given password meets requirements:
     * - Not null or empty
     * - Length between 8 and 26 characters
     * - No spaces, tabs, or newlines
     * - Only ASCII characters
     * - Contains at least one digit
     * - Contains at least one special character (excluding space)
     *
     * Tested by Laurin Johnson, WORKS
     * 
     * @param inputPassword
     * @return true if the password meets all requirements, false otherwise
    */
    public boolean meetsPassRequirements(String inputPassword) 
    {
        if (inputPassword == null || inputPassword.isEmpty())
        {
            return false;
        }

        if (inputPassword.contains(" ") || inputPassword.contains("\t") || inputPassword.contains("\n"))
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

        if (!inputPassword.matches("^[\\p{ASCII}]+$"))
        {
            return false;
        }

        if (!inputPassword.matches(".*[!@#$%^&*()_+\\-={}\\[\\]:\";'<>?,./\\\\|].*"))
        {
            return false;
        }

        return true;
    }

    /**
     * Attempts to set the user's skill level based on loose matching.
     * Converts input to uppercase and searches for a match:
     * - Contains "BEGIN" → sets to "BEGINNER"
     * - Contains "INTER" → sets to "INTERMEDIATE"
     * - Contains "PRO" → sets to "PRO"
     * If input is null, empty, non-ASCII, or does not match any known category, the skill level is unchanged.

     * Tested by Laurin Johnson, WORKS
     * 
     * @param SkillLevel
    */
    public void setSkillLevel(String SkillLevel)
    {
        if (SkillLevel == null || SkillLevel.trim().isEmpty())
        {
            return;
        }

        if (!SkillLevel.matches("^[\\p{ASCII}]+$"))
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

    /**
     * Attempts to set the user's filter preference based on input.
     * Accepts:
     * - "yes" or "y" (any capitalization) → sets filter to true
     * - "no" or "n" (any capitalization) → sets filter to false
     * Ignores invalid, non-ASCII, null, or empty input.
     * Tested by Laurin Johnson, WORKS
     * 
     * @param Filter
    */
    public void setFilter(String Filter)
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

    /* Useless, editing this out for now
    public void logout() {
        System.out.println(username + "has logged out.");

    }
    */

    /*
     * public String getWord(int num) { //For now, lets leave this commented TODO
     * if (num >= 0 && num < WORDS.length) {
     * return WORDS[num];
     * }
     * return null;
     * }
    */

}
