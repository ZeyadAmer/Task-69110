package users;
import Engine.*;
import java.util.ArrayList;

public class Creator {
    String name;
    String password;
    int quizzes;
    ArrayList<Quiz> quizzesList;
    public Creator(String name, String password){
        this.name = name;
        this.password = password;
        quizzes = 0;
        ArrayList<Quiz> quizzesList = new ArrayList<Quiz>();
    }

    private void createQuizzes(String name){
        Quiz quiz = new Quiz(name);
    }

    private void addQuestion(String question, int answer, ArrayList<String> options, String quizName){
        Question question1 = new Question(question, answer, options);
        for(Quiz quiz : quizzesList){
            if(quiz.name.equals(quizName))
                quiz.addQuestion(question1);
        }
    }


}
