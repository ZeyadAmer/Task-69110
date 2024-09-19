package Engine;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {
    public ArrayList<Question> questions;
    public String name;
    public Quiz(String name) {
        questions = new ArrayList<>();
        this.name = name;
    }


    public void addQuestion(){
        Scanner myObj = new Scanner(System.in);
        boolean flag = false;
        String userChoice;
        String question;
        int answer = -1;
        ArrayList<String> options = new ArrayList<>();
        System.out.println("Enter question: ");
        question = myObj.nextLine();
        while (!flag) {
            System.out.println("1- add option\n" +
                    "2- finish ");
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                System.out.println("Enter option: ");
                String option = myObj.nextLine();
                options.add(option);
            } else if(userChoice.equals("2")){
                if(options.isEmpty()){
                    System.out.println("Enter more options please");
                }else flag = true;
            }
            else flag = true;
        }
        System.out.println("Enter correct option number: ");
        while (answer < 0 || answer > options.size()){
            try{
                answer = myObj.nextInt();
                if(answer < 0 || answer > options.size()){
                    System.out.println("invalid option number");
                }
            }
            catch (InputMismatchException e){
                System.out.println("invalid option number");
                myObj.next();
            }
        }


        Question question1 = new Question(question, answer, options);

        questions.add(question1);

    }
    public void addQuestion(Question question){
        questions.add(question);
    }
}
