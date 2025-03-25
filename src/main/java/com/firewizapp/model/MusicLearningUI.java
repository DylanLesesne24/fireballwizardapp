package com.firewizapp.model;

import java.util.Scanner;
import java.util.UUID;

public class MusicLearningUI {
    private MusicLearningFacade facade;
    private Scanner scanner;

    public MusicLearningUI() {
        this.facade = new MusicLearningFacade();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Fireball Wizards Music Learning App");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Start Lesson");
            System.out.println("4. Complete Lesson");
            System.out.println("5. View Progress");
            System.out.println("6. Take a Quiz");
            System.out.println("7. Play Sample Song");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    startLesson();
                    break;
                case 4:
                    completeLesson();
                    break;
                case 5:
                    viewProgress();
                    break;
                case 6:
                    takeQuiz();
                    break;
                case 7:
                    playSampleSong();
                    break;
                case 8:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        boolean success = facade.registerUser(username, password, email);
        if (success) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Try again.");
        }
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean success = facade.loginUser(username, password);
        if (success) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }

    private void startLesson() {
        System.out.print("Enter Lesson ID (UUID): ");
        String lessonIdStr = scanner.nextLine();
        try {
            UUID lessonId = UUID.fromString(lessonIdStr);
            facade.startLesson(lessonId);
        } catch (Exception e) {
            System.out.println("Invalid UUID format or lesson not found: " + e.getMessage());
        }
    }

    private void completeLesson() {
        System.out.print("Enter Lesson ID (UUID): ");
        String lessonIdStr = scanner.nextLine();
        try {
            UUID lessonId = UUID.fromString(lessonIdStr);
            facade.completeLesson(lessonId);
        } catch (Exception e) {
            System.out.println("Invalid UUID format or lesson not found: " + e.getMessage());
        }
    }

    private void viewProgress() {
        System.out.print("Enter User ID (UUID): ");
        String userIdStr = scanner.nextLine();
        try {
            UUID userId = UUID.fromString(userIdStr);
            String progress = facade.getUserProgress(userId);
            System.out.println("User Progress: " + progress);
        } catch (Exception e) {
            System.out.println("Invalid UUID format: " + e.getMessage());
        }
    }

    private void takeQuiz() {
        System.out.print("Enter Quiz ID (UUID): ");
        String quizIdStr = scanner.nextLine();
        try {
            UUID quizId = UUID.fromString(quizIdStr);
            System.out.println("Enter your answers separated by commas:");
            String[] answers = scanner.nextLine().split(",");
            facade.takeQuiz(quizId, answers);
            System.out.println("Quiz submitted successfully!");
        } catch (Exception e) {
            System.out.println("Invalid UUID format or error: " + e.getMessage());
        }
    }

    private void playSampleSong() {
        facade.playSampleSong();
    }

    public static void main(String[] args) {
        MusicLearningUI ui = new MusicLearningUI();
        ui.start();
    }
}
