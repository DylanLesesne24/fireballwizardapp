package com.firewizapp.model;

import java.util.UUID;

public class MusicLearningFacade {

    //I'm thinking maybe a constructor could pull data from the file, and then everything could be stored locally

    private UUID userID;
    private UUID quizID;
    private UUID lessonID; //These variables, but theoretically in data loader

    public boolean registerUser(String username, String password, String email)
    {
        //TODO I need to figure out how to get info from the json file and then this is easy
    }

    public boolean loginUser(String username, String password)
    {
        //TODO
    }

    public void startLesson(UUID lessonID)
    {
        //TODO
    }

    public void completeLesson(UUID lessonID)
    {
       //TODO 
    }

    public void takeQuiz(UUID quizID, String[] questions) //Best solution was a string array, the questions are strings, so it kind of made sense to me
    {
        //TODO
    }

    public String getUserProgress(UUID userID)
    {
        //TODO
    }

    public void updateProgress(UUID userID)
    {
        //TODO This feels more like something that would go in data writer
    }

}
