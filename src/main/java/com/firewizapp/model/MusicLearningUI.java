package com.firewizapp.ui; //TODO I'm leaving this to whoever does this, I haven't been in charge of this

import com.firewizapp.model.MusicLearningFacade;

import java.util.Scanner;
import java.util.UUID;

public class MusicLearningUI {

    private MusicLearningFacade facade;
    private Scanner scanner;

    public MusicLearningUI() {
        this.facade = new MusicLearningFacade();
        this.scanner = new Scanner(System.in);
    }
//Name of app may change
    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Fireball Wizards Music Learning App");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Progress");
            System.out.println("4. Take a Quiz");
            System.out.println("5. Exit");
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
                    viewProgress();
                    break;
                case 4:
                    takeQuiz();
                    break;
                case 5:
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

    private void viewProgress() {
        System.out.print("Enter User ID: ");
        String userIdStr = scanner.nextLine();
        UUID userId = UUID.fromString(userIdStr);

        String progress = facade.getUserProgress(userId);
        System.out.println("User Progress: " + progress);
    }

    private void takeQuiz() {
        System.out.print("Enter Quiz ID: ");
        String quizIdStr = scanner.nextLine();
        UUID quizId = UUID.fromString(quizIdStr);

        System.out.println("Enter your answers below.:");
        String[] answers = scanner.nextLine().split(",");

        facade.takeQuiz(quizId, answers);
        System.out.println("Quiz submitted successfully!");
    }

    public static void main(String[] args) {
        MusicLearningUI ui = new MusicLearningUI();
        ui.start();
    }
}
