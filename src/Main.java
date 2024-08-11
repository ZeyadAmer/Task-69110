import Engine.Question;
import Engine.Quiz;
import users.Access;
import users.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int homePage(){
        String userChoice = "0";
        boolean flag = false;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Hello, \n" +
                "Welcome to quiz mania");
        System.out.println("1- Player \n" +
                "2- Creator");

        while(!flag) {
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                flag = true;

            } else if (userChoice.equals("2")) {
                flag = true;

            } else {
                System.out.println("Please choose 1 or 2");
            }
        }
        return Integer.parseInt(userChoice);
    }
    public static int userType(int accessOption, Access access){
        String userChoice = "0";
        String userName;
        String password;
        boolean flag = false;
        Scanner myObj = new Scanner(System.in);
        System.out.println("1- Login \n" +
                "2- Register");

        while(!flag) {
            userChoice = myObj.nextLine();
            if(accessOption == 1){
                if (userChoice.equals("1")) {
                    while(!flag) {
                        System.out.println("Please enter your username");
                        userName = myObj.nextLine();
                        System.out.println("Please enter your password");
                        password = myObj.nextLine();
                        flag = access.loginPlayer(userName, password);
                    }
                } else if (userChoice.equals("2")) {
                    System.out.println("Please enter your username");
                    userName = myObj.nextLine();
                    System.out.println("Please enter your password");
                    password = myObj.nextLine();
                    access.addPlayer(userName, password);

                } else {
                    System.out.println("Please choose 1 or 2");
                }
            }
            else if(accessOption == 2){
                if (userChoice.equals("1")) {
                    while(!flag) {
                        System.out.println("Please enter your username");
                        userName = myObj.nextLine();
                        System.out.println("Please enter your password");
                        password = myObj.nextLine();
                        flag = access.loginCreator(userName, password);
                    }
                } else if (userChoice.equals("2")) {
                    System.out.println("Please enter your username");
                    userName = myObj.nextLine();
                    System.out.println("Please enter your password");
                    password = myObj.nextLine();
                    access.addPlayer(userName, password);

                } else {
                    System.out.println("Please choose 1 or 2");
                }
            }
        }
        return Integer.parseInt(userChoice);
    }

    public void presetQuiz(Quiz quizzes){
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Paris");
        options1.add("London");
        options1.add("Berlin");
        Question q1 = new Question("What is the capital of France?", 0, options1);

        // Instance 2
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("4");
        options2.add("5");
        options2.add("6");
        Question q2 = new Question("What is 2 + 2?", 0, options2);

        // Instance 3
        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Python");
        options3.add("Java");
        options3.add("C++");
        Question q3 = new Question("Which language is used for Android development?", 1, options3);

        // Instance 4
        ArrayList<String> options4 = new ArrayList<>();
        options4.add("Mount Everest");
        options4.add("K2");
        options4.add("Kangchenjunga");
        Question q4 = new Question("What is the highest mountain in the world?", 0, options4);

        // Instance 5
        ArrayList<String> options5 = new ArrayList<>();
        options5.add("The Great Wall of China");
        options5.add("Machu Picchu");
        options5.add("Christ the Redeemer");
        Question q5 = new Question("Which of these is one of the New Seven Wonders of the World?", 0, options5);

        quizzes.addQuestion(q1);
        quizzes.addQuestion(q2);
        quizzes.addQuestion(q3);
        quizzes.addQuestion(q4);
        quizzes.addQuestion(q5);
    }
    public static void main(String[] args) {
        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
        Access access = new Access();
        int accessOption = homePage();
        userType(accessOption, access);

    }
}