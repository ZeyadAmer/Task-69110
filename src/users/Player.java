package users;
import Engine.Scores;
import java.util.ArrayList;

public class Player {
    public String name;
    public String password;
    public ArrayList<Scores> scores;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.scores = new ArrayList<Scores>();
    }
}
