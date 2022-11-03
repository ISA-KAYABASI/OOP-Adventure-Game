import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println(" Right now you are at : " +this.getName());
        System.out.println(" Be careful "+obsNumber + " " + this.getObstacle().getName() + " lives here !");
        System.out.println("<S> Savas or <R> Run");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)){

                System.out.println(this.getName() + "All enemies are defeated !");
                return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You are dead.");
            return false;
        }
        return true;
    }


    public boolean combat(int obsNumber){
        for (int i = 0; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.println("<H> Hit Or <R> Run");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")){
                    System.out.println("You hit !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("Monster hit you !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You defeated the enemies ");
                System.out.println("You gain " + this.getObstacle().getAward() + " awards");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your current money is " + this.getPlayer().getMoney());
            }else{
                return false;
            }

        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your health is " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health : " + this.getObstacle().getHealth());
        System.out.println("-----------");
    }

    public void playerStats(){
        System.out.println("gamer stats");
        System.out.println("-------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName() + " Values");
        System.out.println("----------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }


    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
