package users;
import Engine.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Creator extends User {
    public ArrayList<Quiz> quizzesList;

    public Creator(String name, String password) {
        super(name, password);
        this.quizzesList = new ArrayList<>();
    }

    public void createQuiz(ArrayList<Player> players,ArrayList<Creator> creators,ArrayList<Quiz> allQuizzes){
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

            } else if (userChoice.equals("2")) {
                if(!quiz.questions.isEmpty())
                    flag = true;
                else
                    System.out.println("Please enter at least one question");

            } else{
                this.quizzesList.add(quiz);
                allQuizzes.add(quiz);
                homePage(players,creators,allQuizzes);
                flag = true;
            }

        }

    }


    public void homePage(ArrayList<Player> players,ArrayList<Creator> creators,ArrayList<Quiz> allQuizzes){
        Scanner myObj = new Scanner(System.in);
        System.out.println("1- show quizzes\n" +
                "2- add question to quiz\n" +
                "3- Create new quiz\n" +
                "4- logout");
        String choice = myObj.nextLine();
        switch(choice){
            case "1":
                if(quizzesList.isEmpty()){
                    System.out.println("No quizzes yet");
                    homePage(players,creators,allQuizzes);
                    break;
                }else{
                    for(Quiz quiz : quizzesList){
                         System.out.println(quiz.name);
                    }
                    homePage(players,creators,allQuizzes);
                }
            case "2":
                System.out.println("Enter quiz name: ");
                String nameEntered = myObj.nextLine();
                boolean flag = false;
                for(Quiz quiz : quizzesList){
                    if(quiz.name.equals(nameEntered)){
                        quiz.addQuestion();
                        homePage(players,creators,allQuizzes);
                        flag = true;
                        break;
                    }

                }
                if(!flag){
                    System.out.println("quiz not found");
                    homePage(players, creators, allQuizzes);
                }
                break;

            case "3":
                createQuiz(players,creators,allQuizzes);
                break;
            case "4":
                Access access = new Access();
                access.homePage(players,creators,allQuizzes);
                break;
            default:
                System.out.println("Please choose correct option");
                homePage(players,creators,allQuizzes);
                break;

        }
    }


}
