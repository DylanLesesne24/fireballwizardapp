package com.firewizapp.model;

import java.util.ArrayList;
import java.util.HashMap;

abstract class Data_Loader {

    public ArrayList<User> loadUsers()
    {
        return new ArrayList<User>();
    }

    public HashMap<Integer, Lessons> loadLessons()
    {
        return new HashMap<Integer, Lessons>();
    }

    //public HashMap<Integer, ProgressTracker> loadProgress() 
    //TODO We're getting rid of our ProgressTracker class, so this needs to be fixed

    //public HashMap<Integer, Quizzes> loadQuizzes()
    //TODO We're merging quizzes and lessons, so this needs to be fixed
}
