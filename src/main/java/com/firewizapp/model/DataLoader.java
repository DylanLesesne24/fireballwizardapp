package com.firewizapp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataLoader extends Data_Loader {

    public ArrayList<User> getUsers()
    {
        return new ArrayList<User>();
    }

    public HashMap<Integer, Lessons> getLessons()
    {
        return new HashMap<Integer, Lessons>();
    }

    //public HashMap<Integer, ProgressTracker> getProgress()
    //TODO We're getting rid of our ProgressTracker class, so this needs to be fixed

    //public HashMap<Integer, Quizzes> getQuizzes()
    //TODO We're merging quizzes and lessons, so this needs to be fixed
    
}
