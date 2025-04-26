package com.firewizapp;

import com.firewizapp.model.MusicLearningFacade;
import com.firewizapp.model.Question;
import com.firewizapp.model.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.Random;

import java.util.List;

public class QuizController {

    @FXML
    private Label quizTitleLabel;
    @FXML
    private Button homeButton;
    @FXML
    private Label questionLabel;
    @FXML
    private Button choiceButton1;
    @FXML
    private Button choiceButton2;
    @FXML
    private Button choiceButton3;
    @FXML
    private Button choiceButton4;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Button retryButton;
    @FXML
    private ImageView backImage;

    private Quiz currentQuiz;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public void initialize() {
        MusicLearningFacade facade = MusicLearningFacade.getInstance();
        List<Quiz> quizzes = facade.getAllQuizzes();

        if (quizzes.isEmpty()) {
            questionLabel.setText("No quizzes available!");
            choiceButton1.setVisible(false);
            choiceButton2.setVisible(false);
            choiceButton3.setVisible(false);
            choiceButton4.setVisible(false);
            feedbackLabel.setText("Please add quizzes first.");
            retryButton.setVisible(false);
            return;
        }

        Random random = new Random();
        currentQuiz = quizzes.get(random.nextInt(quizzes.size())); // <-- random quiz selection!

        questions = currentQuiz.getQuestions();

        if (quizTitleLabel != null) {
            quizTitleLabel.setText("Quiz: " + currentQuiz.getTitle());
        }

        showCurrentQuestion();
    }

    private void showCurrentQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            questionLabel.setText("Quiz Finished! Score: " + score + "/" + questions.size());
            questionLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #4CAF50;");

            choiceButton1.setVisible(false);
            choiceButton2.setVisible(false);
            choiceButton3.setVisible(false);
            choiceButton4.setVisible(false);
            feedbackLabel.setVisible(false);
            retryButton.setVisible(true);
            homeButton.setVisible(true);
            return;
        }

        questionLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: normal; -fx-text-fill: black;");

        Question q = questions.get(currentQuestionIndex);
        questionLabel.setText(q.getQuestionText());
        List<String> choices = q.getAnswerChoices();
        choiceButton1.setText(choices.get(0));
        choiceButton2.setText(choices.get(1));
        choiceButton3.setText(choices.get(2));
        choiceButton4.setText(choices.get(3));
        feedbackLabel.setText("");
    }

    private void handleAnswer(int selectedIndex) {
        Question current = questions.get(currentQuestionIndex);
        if (current.isCorrect(selectedIndex)) {
            feedbackLabel.setText("Correct!");
            score++;
        } else {
            feedbackLabel.setText("Wrong! Correct answer: " +
                    current.getAnswerChoices().get(current.getCorrectAnswerIndex()));
        }
        currentQuestionIndex++;

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            javafx.application.Platform.runLater(this::showCurrentQuestion);
        }).start();
    }

    @FXML
    private void handleChoice1() {
        handleAnswer(0);
    }

    @FXML
    private void handleChoice2() {
        handleAnswer(1);
    }

    @FXML
    private void handleChoice3() {
        handleAnswer(2);
    }

    @FXML
    private void handleChoice4() {
        handleAnswer(3);
    }

    @FXML
    private void handleRetry() {
        // Reset quiz
        currentQuestionIndex = 0;
        score = 0;
        choiceButton1.setVisible(true);
        choiceButton2.setVisible(true);
        choiceButton3.setVisible(true);
        choiceButton4.setVisible(true);
        retryButton.setVisible(false);
        homeButton.setVisible(false); // <-- hide home
        feedbackLabel.setVisible(true);

        if (quizTitleLabel != null) {
            quizTitleLabel.setText("Quiz: " + currentQuiz.getTitle());
        }

        showCurrentQuestion();
    }

    @FXML
    private void handleHome() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/firewizapp/homepage.fxml"));
            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/firewizapp/homepage.fxml"));
            Stage stage = (Stage) questionLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
