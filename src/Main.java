import Engine.Question;
import Engine.Quiz;
import users.Access;
import java.util.ArrayList;

public class Main {




    public static void presetQuiz(Quiz quizzes){
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("1- Paris");
        options1.add("2- London");
        options1.add("3- Berlin");
        Question q1 = new Question("What is the capital of France?", 1, options1);

        // Instance 2
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("1- 4");
        options2.add("2- 5");
        options2.add("3- 6");
        Question q2 = new Question("What is 2 + 2?", 1, options2);

        // Instance 3
        ArrayList<String> options3 = new ArrayList<>();
        options3.add("1- Python");
        options3.add("2- Java");
        options3.add("3- C++");
        Question q3 = new Question("Which language is used for Android development?", 2, options3);

        // Instance 4
        ArrayList<String> options4 = new ArrayList<>();
        options4.add("1- Mount Everest");
        options4.add("2- K2");
        options4.add("3- Kangchenjunga");
        Question q4 = new Question("What is the highest mountain in the world?", 1, options4);

        // Instance 5
        ArrayList<String> options5 = new ArrayList<>();
        options5.add("1- The Great Wall of China");
        options5.add("2- Machu Picchu");
        options5.add("3- Christ the Redeemer");
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