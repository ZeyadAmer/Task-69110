package users;
import Engine.Question;
import Engine.Quiz;
import Engine.Scores;
import java.util.ArrayList;
import java.util.Scanner;
public class Player extends User  {
    public ArrayList<Scores> scores;

    public Player(String name, String password) {
        super(name, password);
        this.scores = new ArrayList<>();
    }

    public void homePage(ArrayList<Player> players,ArrayList<Creator> creators,ArrayList<Quiz> allQuizzes){
        Scanner myObj = new Scanner(System.in);
        System.out.println("1- choose quiz\n" +
                "2- show scores\n" +
                "3- logout");
        int choice = myObj.nextInt();
        myObj.nextLine();
        switch(choice){
            case 1:
                for(Quiz quiz : allQuizzes){
                    System.out.println(quiz.name);
                }
                String quizName = myObj.nextLine();
                for(Quiz quiz : allQuizzes){
                    if(quiz.name.equals(quizName)){
                        solveQuiz(quiz);
                        homePage(players,creators,allQuizzes);
                    }


                }
                System.out.println("no quiz found with this name");
                homePage(players,creators,allQuizzes);
            case 2:
                for(Scores score : scores){
                    System.out.println(score.quizName + " " + score.score);
                }
                homePage(players,creators,allQuizzes);

            case 3:
                Access access = new Access();
                access.homePage(players,creators,allQuizzes);

            default:
                homePage(players,creators,allQuizzes);
                break;

        }
    }
    public void solveQuiz(Quiz quiz){
        int score = 0;
        Scanner myObj = new Scanner(System.in);
        for(Question question : quiz.questions){
            System.out.println(question.question);
            for(String option : question.options){
                System.out.println(option);
            }

            int choice = myObj.nextInt();
            if(choice == question.answer){
                System.out.println("Correct answer");
                score++;
            }else
                System.out.println("Wrong answer\nThe right answer is " + question.answer);
        }
        scores.add(new Scores(quiz.name, score));
    }
}
