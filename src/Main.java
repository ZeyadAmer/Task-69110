import Engine.Question;
import Engine.Quiz;
import users.Access;
import users.Creator;
import users.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {




    public static void presetQuiz(Quiz quizzes){
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Paris");
        options1.add("London");
        options1.add("Berlin");
        Question q1 = new Question("What is the capital of France?", 1, options1);

        // Instance 2
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("4");
        options2.add("5");
        options2.add("6");
        Question q2 = new Question("What is 2 + 2?", 1, options2);

        // Instance 3
        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Python");
        options3.add("Java");
        options3.add("C++");
        Question q3 = new Question("Which language is used for Android development?", 2, options3);

        // Instance 4
        ArrayList<String> options4 = new ArrayList<>();
        options4.add("Mount Everest");
        options4.add("K2");
        options4.add("Kangchenjunga");
        Question q4 = new Question("What is the highest mountain in the world?", 1, options4);

        // Instance 5
        ArrayList<String> options5 = new ArrayList<>();
        options5.add("The Great Wall of China");
        options5.add("Machu Picchu");
        options5.add("Christ the Redeemer");
        Question q5 = new Question("Which of these is one of the New Seven Wonders of the World?", 1, options5);

        quizzes.addQuestion(q1);
        quizzes.addQuestion(q2);
        quizzes.addQuestion(q3);
        quizzes.addQuestion(q4);
        quizzes.addQuestion(q5);
    }
    public static void main(String[] args) {

        Access access = new Access();
        Quiz preSet = new Quiz("PreSet");
        presetQuiz(preSet);
        access.allQuizzes.add(preSet);

        access.homePage(access.players,access.creators,access.allQuizzes);



    }
}