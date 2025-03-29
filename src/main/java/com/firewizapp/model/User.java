package com.firewizapp.model;

import java.util.UUID;

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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return password;
    }

    public boolean getFilter() {
        return this.filter;
    }

    public String[] getBadgesEarned() {
        return this.badgesEarned;
    }

    public boolean checkUsername(String inputUsername)
    {
        return this.username.equalsIgnoreCase(inputUsername); //Most username logins I've seen ignore case - Laurin Johnson (so you know who wrote this)
    }

    public boolean checkPassword(String inputPassword)
    {
        return this.password.equals(inputPassword);
    }

    public boolean meetsPassRequirements(String password) 
    {
        if(password == null) //Null Pointer Check
        {
            return false;
        }

        if(password.length() < 8) // Length Check
        {
            return false;
        }

        if(!password.matches(".*\\d.*")) //Number check, this is a representation of 0-9
        {
            return false;
        }

        if(!password.matches(".*[^a-zA-Z0-9].*"))//Special Character check, this is a representation of any character that is NOT a letter (a–z or A–Z) or a digit (0–9).
        {                                        //This includes special characters like: ! " # $ % & ' ( ) * + , - . / : ; < = > ? @ [ \ ] ^ _ ` { | } ~ and spaces
            return false;
        }

        return true;
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

    public UUID getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public boolean isFilterEnabled() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

}
