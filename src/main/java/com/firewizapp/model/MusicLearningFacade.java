package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Facade class that simplifies access to the core components of the music
 * learning app,
 * including user management, lesson control, songs, flashcards, and quizzes.
 * 
 * This class follows the Singleton pattern to ensure a single access point to
 * the app logic.
 */
public class MusicLearningFacade {

    private LessonsManager lessonManager;
    private UserList userList;
    private SongList songList;

    private static MusicLearningFacade instance;

    /**
     * Private constructor for Singleton pattern. Initializes core managers.
     */
    private MusicLearningFacade() {
        this.lessonManager = LessonsManager.getInstance();
        this.userList = UserList.getInstance();
        this.songList = SongList.getInstance();
    }

    /**
     * Returns the singleton instance of the MusicLearningFacade.
     * 
     * @return MusicLearningFacade instance
     */
    public static MusicLearningFacade getInstance() {
        if (instance == null) {
            instance = new MusicLearningFacade();
        }
        return instance;
    }

    /**
     * Registers a new user with the system.
     * 
     * @param username   The desired username
     * @param password   The desired password
     * @param email      The user's email
     * @param skillLevel The user's difficulty level
     * @return true if registration is successful, false otherwise
     */
    public boolean registerUser(String username, String password, String email, Difficulty skillLevel) {
        return userList.addUser(username, password, email, skillLevel);
    }

    /**
     * Logs in a user if the username and password are valid.
     * 
     * @param username The user's username
     * @param password The user's password
     * @return User object if login is successful, null otherwise
     */
    public User loginUser(String username, String password) {
        User user = userList.getUser(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    /**
     * Logs out the current user.
     * 
     * @param user The user to log out
     */
    public void logoutUser(User user) {
        user.logout();
    }

    /**
     * Starts a lesson by its ID.
     * 
     * @param lessonID The lesson ID
     */
    public void startLesson(UUID lessonID) {
        lessonManager.getLesson(lessonID);
    }

    /**
     * Marks a lesson as completed by its ID.
     * 
     * @param lessonID The lesson ID
     */
    public void completeLesson(int lessonID) {
        lessonManager.completeLesson(lessonID);
    }

    /**
     * Returns all available lessons in the system.
     * 
     * @return ArrayList of Lessons
     */
    public ArrayList<Lessons> getAllLessons() {
        return lessonManager.getLessons();
    }

    /**
     * Plays a song by ID by printing its chords to the console.
     * 
     * @param songID The ID of the song
     */
    public void playSong(int songID) {
        Song song = songList.getSong(songID);
        if (song != null) {
            System.out.println("Now playing: " + song.getTitle());
            for (String chord : song.getChords()) {
                System.out.println("Chord: " + chord);
            }
        } else {
            System.out.println("Song not found.");
        }
    }

    /**
     * Adds a new song to the song list.
     * 
     * @param song The song to add
     */
    public void addSong(Song song) {
        songList.addSong(song);
    }

    /**
     * Returns all songs available in the system.
     * 
     * @return ArrayList of Song objects
     */
    public ArrayList<Song> getAllSongs() {
        return songList.getAllSongs();
    }

    /**
     * Retrieves the flashcards associated with a given lesson.
     * 
     * @param lessonID The lesson ID
     * @return Flashcards for the lesson
     */
    public Flashcards getFlashcardsForLesson(int lessonID) {
        return lessonManager.getFlashcardsForLesson(lessonID);
    }

    /**
     * Retrieves the quiz associated with a given lesson.
     * 
     * @param lessonID The lesson ID
     * @return Quiz object for the lesson
     */
    public Flashcards getQuizForLesson(int lessonID) {
        return lessonManager.getFlashcardsForLesson(lessonID);
    }
}
