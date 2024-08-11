package users;
import Engine.Quiz;
import Engine.Scores;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public String name;
    public String password;
    public ArrayList<Scores> scores;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.scores = new ArrayList<Scores>();
    }

    public void homePage(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("1- choose quiz\n" +
                "2- show scores\n" +
                "3- logout");
        int choice = myObj.nextInt();
        switch(choice){
            case 1:


            case 2:

            case 3:
                Access access = new Access();
                access.homePage();

            default:
                homePage();
                break;

        }
    }
}
