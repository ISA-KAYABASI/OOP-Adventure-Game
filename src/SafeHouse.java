public class SafeHouse extends  NormalLoc{

    public SafeHouse(Player player) {
        super(player, "SafeHouse");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Now you are in SafeHouse!");
        System.out.println("SafeHouse make full your health");
        return true;
    }
}

