package Engine;
import java.util.ArrayList;

public class Question {
    String question;
    int answer;
    ArrayList<String> options;
    public Question(String question, int answer, ArrayList<String> options){
        this.question = question;
        this.answer = answer;
        this.options = options;

    }

}
