package com.firewizapp.ui;

import com.firewizapp.model.MusicLearningFacade;
import java.util.Scanner;

public class UI {

    private MusicLearningFacade facade;
    private Scanner scanner;

    public UI() {
        this.facade = new MusicLearningFacade();
        this.scanner = new Scanner(System.in);
    }
//This opening line is temporary may change if group has something better
    public void start() {
        System.out.println("Welcome to Fireball Wizards Music App!");
        
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 1) {
                // Login option
                loggedIn = loginUser();
            } else if (choice == 2) {
                // Register option
                loggedIn = registerUser();
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private boolean loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (facade.loginUser(username, password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            showMainMenu();
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    private boolean registerUser() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        // Call facade to register user
        if (facade.registerUser(username, password, email)) {
            System.out.println("Registration successful! You can now log in.");
            return true;
        } else {
            System.out.println("Registration failed. Please try again.");
            return false;
        }
    }

    private void showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Start Lesson");
        System.out.println("2. Take Quiz");
        System.out.println("3. View Progress");
        System.out.println("4. Logout");
        
        // TODO: Implement user choice handling (Start lesson, take quiz, view progress, and logout.)
    }

    public static void main(String[] args) {
        UI app = new UI();
        app.start();
    }
}
