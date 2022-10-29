public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player,"Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("----- Welcome to the ToolStore! -----");
        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Logout from ToolStore");
        System.out.println("Choose : ");
        int selectCase = input.nextInt();
        while(selectCase < 1 || selectCase > 3){
            System.out.println("Your choose is not valid ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1 :
                printWeapon();
                break;
            case 2 :
                printArmor();
                break;
                case 3 :
                    System.out.println("See you next time");
                    return true;
        }
        return true;
    }
    public void printWeapon() {
        System.out.println("-------- Weapons --------");
        System.out.println( );
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getName() + " <Price : " + w.getPrice() + " , Damage : " + w.getDamage() + ">");
        }
    }
    public void printArmor() {
        System.out.println("Shields");
    }
}
