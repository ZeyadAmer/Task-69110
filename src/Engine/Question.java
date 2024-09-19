package Engine;
import java.util.ArrayList;

public class Question {
    public String question;
    public int answer;
    public ArrayList<String> options;
    public Question(String question, int answer, ArrayList<String> options){
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

}
