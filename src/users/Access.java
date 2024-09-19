package users;
import Engine.Quiz;
import java.util.ArrayList;
import java.util.Scanner;

public class Access {
    public ArrayList<Player> players;
    public ArrayList<Creator> creators;
    public ArrayList<Quiz> allQuizzes;
    public Access() {
        players = new ArrayList<>();
        creators = new ArrayList<>();
        allQuizzes = new ArrayList<>();
    }
    public void homePage(ArrayList<Player> players,ArrayList<Creator> creators,ArrayList<Quiz> allQuizzes){
        this.players = players;
        this.creators = creators;
        this.allQuizzes = allQuizzes;
        System.out.println(creators.size());
        String userChoice = "0";
        System.out.println(allQuizzes.size());
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
        userType(Integer.parseInt(userChoice));

    }
    public void userType(int accessOption){
        Player player;
        Creator creator;
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
                        System.out.println("Type back to main menu and anything to continue");
                        userChoice = myObj.nextLine();
                        if(userChoice.equals("back")) {
                            homePage(players,creators,allQuizzes);
                        }
                        System.out.println("Please enter your username");
                        userName = myObj.nextLine();
                        System.out.println("Please enter your password");
                        password = myObj.nextLine();
                        player = loginPlayer(userName, password);
                        if(player != null ){
                            player.homePage(players,creators,allQuizzes);
                            flag = true;
                        }

                    }
                } else if (userChoice.equals("2")) {
                    System.out.println("Please enter your username");
                    userName = myObj.nextLine();
                    System.out.println("Please enter your password");
                    password = myObj.nextLine();
                    addPlayer(userName, password);
                    player = players.get(players.size()-1);
                    player.homePage(players,creators,allQuizzes);
                    flag = true;

                } else {
                    System.out.println("Please choose 1 or 2");
                }
            }
            else if(accessOption == 2){
                if (userChoice.equals("1")) {
                    while(!flag) {
                        System.out.println("Type back to main menu and anything to continue");
                        userChoice = myObj.nextLine();
                        if(userChoice.equals("back")) {
                            homePage(players,creators,allQuizzes);
                        }
                        System.out.println("Please enter your username");
                        userName = myObj.nextLine();

                        System.out.println("Please enter your password");
                        password = myObj.nextLine();
                        creator = loginCreator(userName, password);
                        if(creator != null ){
                            flag = true;
                            creator.homePage(players,creators,allQuizzes);
                            System.out.print(creator.name);
                        }

                    }
                } else if (userChoice.equals("2")) {
                    System.out.println("Please enter your username");
                    userName = myObj.nextLine();
                    System.out.println("Please enter your password");
                    password = myObj.nextLine();
                    addCreator(userName, password);
                    creator = creators.get(creators.size()-1);


                    creator.homePage(players,creators,allQuizzes);
                    flag = true;
                } else {
                    System.out.println("Please choose 1 or 2");
                }
            }
        }

    }

    public void addPlayer(String username, String password) {
        players.add(new Player(username, password));
        System.out.println("Player added: " + username);
    }
    public void addCreator(String username, String password) {
        creators.add(new Creator(username, password));
        System.out.println("Creator added: " + username);

    }
    public Player loginPlayer(String username, String password) {
        for (Player player : players) {
            System.out.println(player.name + " " + player.password);
            if(player.name.equals(username) && player.password.equals(password)) {
                System.out.println("Logged in");
                return player;
            }
        }
        System.out.println("Wrong username or password");
        return null;
    }
    public Creator loginCreator(String username, String password) {
        for (Creator creator : creators) {

            if(creator.name.equals(username) && creator.password.equals(password)){
                System.out.println("Logged in" );
                return creator;
            }
        }
        System.out.println("Wrong username or password");
        return null;
    }
}
