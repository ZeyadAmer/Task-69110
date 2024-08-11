package users;
import Engine.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Creator {
    String name;
    String password;
    ArrayList<Quiz> quizzesList;
    public Creator(String name, String password){
        this.name = name;
        this.password = password;
        quizzesList = new ArrayList<Quiz>();
    }

    public void createQuiz(ArrayList<Quiz> allQuizzes){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter quiz name");
        String name = myObj.nextLine();
        Quiz quiz = new Quiz(name);

        String userChoice;

        boolean flag = false;
        while(!flag){
            System.out.println("1- add a question\n" +
                    "2- close");
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                quiz.addQuestion();

            }else{
                quizzesList.add(quiz);
                allQuizzes.add(quiz);
                homePage(allQuizzes);
                flag = true;
            }

        }

    }
    public void addQuestion(Quiz quiz) {
        Scanner myObj = new Scanner(System.in);
        boolean flag = false;
        String userChoice;
        String question;
        int answer;
        ArrayList<String> options = new ArrayList<>();
        System.out.println("Enter question: ");
        question = myObj.nextLine();
        while (!flag) {
            System.out.println("1- add option\n" +
                    "2- finish ");
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                String option = myObj.nextLine();
                options.add(option);
            } else flag = true;
        }
        System.out.println("Enter correct option number: ");
        answer = myObj.nextInt();
        Question question1 = new Question(question, answer, options);

        quiz.questions.add(question1);
    }
    public void addQuestion() {
        Scanner myObj = new Scanner(System.in);
        boolean flag = false;
        String userChoice;
        String question;
        int answer;

        ArrayList<String> options = new ArrayList<>();
        System.out.println("Enter quiz name: ");
        name = myObj.nextLine();
        Quiz current = null;
        for (Quiz quiz : quizzesList) {
            if (quiz.name.equals(name)) {
                current = quiz;

            }
        }

        System.out.println("Enter question: ");
        question = myObj.nextLine();
        while (!flag) {
            System.out.println("1- add option\n" +
                    "2- finish ");
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                String option = myObj.nextLine();
                options.add(option);
            } else flag = true;
        }
        System.out.println("Enter correct option number: ");
        answer = myObj.nextInt();
        Question question1 = new Question(question, answer, options);

        current.questions.add(question1);
    }

    public void homePage(ArrayList<Quiz> allQuizzes){
        Scanner myObj = new Scanner(System.in);
        System.out.println("1- show quizzes\n" +
                "2- add question to quiz\n" +
                "3- Create new quiz\n" +
                "4- logout");
        int choice = myObj.nextInt();
        switch(choice){
            case 1:
                if(quizzesList.isEmpty()){
                    System.out.println("No quizzes yet");
                    homePage(allQuizzes);
                    break;
                }else{
                    for(Quiz quiz : quizzesList){
                         System.out.println(quiz.name);
                    }
                    homePage(allQuizzes);
                }
            case 2:
                System.out.println("Enter quiz name: ");
                for(Quiz quiz : quizzesList){
                    if(quiz.name.equals(name)){
                        addQuestion(quiz);
                        homePage(allQuizzes);
                    }else
                        System.out.println("quiz not found");
                }

            case 3:
                createQuiz(allQuizzes);
                homePage(allQuizzes);
            case 4:
                Access access = new Access();
                access.homePage();

            default:
                homePage(allQuizzes);
                break;

        }
    }


}
