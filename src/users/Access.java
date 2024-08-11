package users;
import java.util.ArrayList;

public class Access {
    public ArrayList<Player> players;
    public ArrayList<Creator> creators;
    public Access() {
        players = new ArrayList<>();
        creators = new ArrayList<>();
    }
    public void addPlayer(String username, String password) {
        players.add(new Player(username, password));
        System.out.println("Player added: " + username);
    }
    public void addCreator(String username, String password) {
        creators.add(new Creator(username, password));
    }
    public boolean loginPlayer(String username, String password) {
        for (Player player : players) {
            if(player.name.equals(username) && player.password.equals(password)) {
                System.out.println("Logged in");
                return true;
            }
        }
        System.out.println("Wrong username or password");
        return false;
    }
    public boolean loginCreator(String username, String password) {
        for (Creator creator : creators) {
            if(creator.name.equals(username) && creator.password.equals(password)){
                System.out.println("Logged in");
                return true;
            }
        }
        System.out.println("Wrong username or password");
        return false;
    }
}
