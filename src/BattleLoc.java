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
        String selecCase = input.nextLine();
        selecCase = selecCase.toUpperCase();
        if (selecCase.equals("S")){
            System.out.println("savas islemleri olacak");
//            savas islemleri

        }
        return true;
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
