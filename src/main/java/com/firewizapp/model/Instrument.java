package com.firewizapp.model;

public class Instrument {
    // Attributes
    private String name;
    private String type;
    private int volume;
    private boolean isElectric;

    // Constructor
    public Instrument(String name, String type, int volume, boolean isElectric) {
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.isElectric = isElectric;
    }

    // Method to simulate playing the instrument
    public void play() {
        System.out.println("Playing the " + name + " (" + type + ").");
    }

    // Method to tune the instrument
    public void tune() {
        System.out.println("Tuning the " + name + " (" + type + ").");
    }

    // Method to get instrument details
    public String getDetails() {
        return "Instrument: " + name +
               "\nType: " + type +
               "\nVolume: " + volume +
               "\nElectric: " + isElectric;
    }

    // Method to stop playing the instrument
    public void stopPlaying() {
        System.out.println("Stopping the " + name + ".");
    }

    // Method to set the volume level
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("Volume for " + name + " set to " + level + ".");
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }
}
