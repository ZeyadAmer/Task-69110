package Engine;
import java.util.ArrayList;
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
        int answer;
        ArrayList<String> options = new ArrayList<>();
        System.out.println("Enter question: ");
        question = myObj.nextLine();
        int counter = 0;
        while(!flag){
            counter++;
            System.out.println("1- add option\n" +
                    "2- finish ");
            userChoice = myObj.nextLine();
            if (userChoice.equals("1")) {
                String option = counter + "-"+ myObj.nextLine();
                options.add(option);
            }else flag = true;
        }
        System.out.println("Enter correct option number: ");
        answer = myObj.nextInt();
        Question question1 = new Question(question,answer,options);

        questions.add(question1);
    }
    public void addQuestion(Question question){
        questions.add(question);
    }
}
