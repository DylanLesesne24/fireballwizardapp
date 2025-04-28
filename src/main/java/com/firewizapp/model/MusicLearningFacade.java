package com.firewizapp.model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class MusicLearningFacade {

        private static MusicLearningFacade instance;
        private ArrayList<Quiz> quizzes;

        private MusicLearningFacade() {
                quizzes = new ArrayList<>();
                loadDefaultQuizzes();
        }

        public static MusicLearningFacade getInstance() {
                if (instance == null) {
                        instance = new MusicLearningFacade();
                }
                return instance;
        }

        public void addQuiz(Quiz quiz) {
                quizzes.add(quiz);
        }

        public ArrayList<Quiz> getAllQuizzes() {
                return quizzes;
        }

        public Quiz getQuizById(UUID quizID) {
                for (Quiz q : quizzes) {
                        if (q.getQuizID().equals(quizID)) {
                                return q;
                        }
                }
                return null;
        }

        private void loadDefaultQuizzes() {
                Quiz basicsQuiz = new Quiz(UUID.randomUUID(), "Music Basics");

                basicsQuiz.addQuestion(new Question(
                                "What is the symbol for a sharp note?",
                                List.of("♯", "♭", "♮", "𝄐"),
                                0));

                basicsQuiz.addQuestion(new Question(
                                "How many lines are there in a musical staff?",
                                List.of("4", "5", "6", "7"),
                                1));

                basicsQuiz.addQuestion(new Question(
                                "Which note is typically the first on a scale?",
                                List.of("Do", "Re", "Mi", "Fa"),
                                0));

                basicsQuiz.addQuestion(new Question(
                                "What is the name of the musical symbol for silence?",
                                List.of("Fermata", "Rest", "Tie", "Slur"),
                                1));

                quizzes.add(basicsQuiz);

                // -----------

                Quiz theoryQuiz = new Quiz(UUID.randomUUID(), "Advanced Music Theory");

                theoryQuiz.addQuestion(new Question(
                                "Which scale has all white keys on piano?",
                                List.of("Chromatic", "C Major", "F Major", "G Major"),
                                1));

                theoryQuiz.addQuestion(new Question(
                                "What term means to gradually get louder?",
                                List.of("Crescendo", "Diminuendo", "Staccato", "Legato"),
                                0));

                theoryQuiz.addQuestion(new Question(
                                "What is the time signature of a waltz?",
                                List.of("3/4", "4/4", "6/8", "2/2"),
                                0));

                theoryQuiz.addQuestion(new Question(
                                "What term describes very fast tempo?",
                                List.of("Largo", "Allegro", "Presto", "Andante"),
                                2));

                quizzes.add(theoryQuiz);

                // -----------

                Quiz instrumentsQuiz = new Quiz(UUID.randomUUID(), "Instruments & Sounds");

                instrumentsQuiz.addQuestion(new Question(
                                "Which instrument uses reeds?",
                                List.of("Trumpet", "Violin", "Clarinet", "Drum"),
                                2));

                instrumentsQuiz.addQuestion(new Question(
                                "What instrument family is the cello in?",
                                List.of("Percussion", "String", "Brass", "Woodwind"),
                                1));

                instrumentsQuiz.addQuestion(new Question(
                                "Which percussion instrument is tuned?",
                                List.of("Snare Drum", "Bass Drum", "Timpani", "Cymbals"),
                                2));

                instrumentsQuiz.addQuestion(new Question(
                                "Which of these is a woodwind instrument?",
                                List.of("Saxophone", "Trombone", "French Horn", "Violin"),
                                0));

                quizzes.add(instrumentsQuiz);
        }
}
