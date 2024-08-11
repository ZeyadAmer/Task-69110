package Engine;
import java.util.ArrayList;

public class Quiz {
    public ArrayList<Question> questions;
    public String name;
    public Quiz(String name) {
        questions = new ArrayList<>();
        this.name = name;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }
}
