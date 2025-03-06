package com.firewizapp.model;

import java.util.UUID;

public class User {

    // TODO

    private UUID userID;
    private String username;
    private String password;
    private String email;
    private Difficulty skillLevel;
    private boolean filter;
    private String[] WORDS;

    public User(String user, String password, String email, Difficulty SkillLevel) {
        this.userID = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.skillLevel = skillLevel;
        this.filter = false;
        this.WORDS = new String[0];

    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public boolean meetsPassRequirements() {
        return password.length() >= 8;
    }

    public void logout() {
        System.out.println(username + "has logged out.");

    }

    public String getWord(int num) {
        if (num >= 0 && num < WORDS.length) {
            return WORDS[num];
        }
        return null;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Difficulty getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Difficulty skillLevel) {
        this.skillLevel = skillLevel;
    }

    public boolean isFilterEnabled() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

}
