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

        Location location = null;
        while(true) {
            player.printInfo();
            System.out.println();
            System.out.println("############ Places ############");
            System.out.println();
            System.out.println("1 - Safe House --> This place is safe for you, no enemies");
            System.out.println("2 - Store --> You can buy weapon or armor");
            System.out.println("0 - Finish the game ");
            System.out.print("Please enter the place you want to go : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location == null){
                System.out.println("You gave up!");
                break;
            }

            if(!location.onLocation())
            {
                System.out.println("Game Over");
                break;
            }
        }

    }


}
