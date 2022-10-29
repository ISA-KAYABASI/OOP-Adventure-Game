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
                buyWeapon();
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
            System.out.println(w.getId() + "-" + w.getName() +
                    " <Price : " + w.getPrice() + " , Damage : " + w.getDamage() + ">");
        }
        System.out.println("Choose a weapon : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid Choose, try again : ");
            selectWeaponID = input.nextInt();
        }

    }

    public void buyWeapon() {

        System.out.println("Choose a weapon : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid Choose, try again : ");
            selectWeaponID = input.nextInt();
        }


        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You dont have enough money to buy this weapon !");
            }else{
                System.out.println("Now you have " + selectedWeapon.getName() + " use it visely");
                int balace = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balace);
                System.out.println("Your balance is " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }

    }


    public void printArmor() {
        System.out.println("Shields");
    }
}
