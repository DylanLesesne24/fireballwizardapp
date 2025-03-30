package com.firewizapp.model;

import java.util.UUID;

/**
 * Represents a user in the FireWiz application. Stores identifying information such as name,
 * email, skill level, and preferences like content filtering and earned badges. 
 * Includes methods for validating credentials and managing user data.
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
     * Checks that the input username matches the username of a user, ignoring capitalization, also checks for invalid username input
     * Tested by Laurin Johnson, WORKS
     * 
     * @param inputUsername
     * @return true if the usernames match, false otherwise
     */
    public boolean checkUsername(String inputUsername)
    {
        if (inputUsername == null || inputUsername.isEmpty() || inputUsername.contains(" "))
        {
            return false;
        }

        return this.username.equalsIgnoreCase(inputUsername); //Most username logins I've seen ignore case - Laurin Johnson (so you know who wrote this)
    }

    /**
     * Checks that the input password matches the password of the user, Case-Sensitive, also checks for invalid password input
     * 
     * @param inputPassword
     * @return true if the passwords match, false otherwise
     */
    public boolean checkPassword(String inputPassword)
    {
        if (inputPassword == null || inputPassword.isEmpty() || inputPassword.contains(" "))
        {
            return false;
        }

        return this.password.equals(inputPassword);
    }

    /**
     * Checks that the chosen username of the user is null, empty, or contains a space, is false if any matches
     * 
     * @param Username
     * @return True if username isn't null, empty, or doesn't contain a space, false otherwise
     */
    public boolean meetsUsernameRequirements(String inputUsername)
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

    /**
     * Checks that the chosen password of the user is not null, not empty, is 8 characters or longer, contains a number, and contains a special character other than space
     * 
     * @param Password
     * @return true if the password is not null, not empty, is 8 characters or longer, contains a number, and contains a special character other than space, false otherwise
     */
    public boolean meetsPassRequirements(String inputPassword) 
    {
        if(inputPassword == null) //Null Pointer Check
        {
            return false;
        }

        if(inputPassword == "")
        {
            return false;
        }

        if(inputPassword.length() < 8) // Length Check
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

    /**
     * Mutator to change the user's skill level
     * 
     * @param SkillLevel
     */
    public void setSkillLevel(String SkillLevel) {
        this.skillLevel = SkillLevel;
    }

    /**
     * Mutator to change the user's filter preference
     * 
     * @param Filter
     */
    public void setFilter(boolean Filter) {
        this.filter = Filter;
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
