import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to your adventure game!");
        System.out.println("Please enter your name : ");
//        String playerName = input.nextLine();
//        Player player = new Player(playerName);
        Player player = new Player("Isa");
        System.out.println(player.getName()+ " welcome to this dangerous Monsterland !!");
        System.out.println("For start to adventure please choose one of the powerfull character...");
        player.selectChar();


    }


}
