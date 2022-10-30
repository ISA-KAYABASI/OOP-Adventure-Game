public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player,"Store");
    }

    @Override
    public boolean onLocation(){

    System.out.println("----- Welcome to the ToolStore! -----");
    boolean showMenu = true;
    while (showMenu) {
        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Logout from ToolStore");
        System.out.println("Choose : ");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Your choose is not valid ");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("See you next time");
                showMenu = false;
                break;
         }
     }
    return true;
    }
    public void printWeapon() {
        System.out.println("-------- Weapons --------");
        System.out.println( );
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " <Price : " + w.getPrice() +  " , Damage : " + w.getDamage() + ">");
        }
        System.out.println("0 - Go back ");
    }

    public void buyWeapon() {
        System.out.println("Choose a weapon : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid Choose, try again : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0){

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
    }


    public void printArmor() {
        System.out.println("-------- Armors --------");
        System.out.println( );
       for(Armor a : Armor.armors()){
           System.out.println(a.getId() + " - " + a.getName() +
                   "      Price : " + a.getPrice() + "      Zirh : " + a.getBlock());
       }
        System.out.println("0 - Go back");
    }


    public void buyArmor() {
        System.out.println("Choose a armor : ");
        int selectArmorID = input.nextInt();
        while(selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid Choose, try again : ");
            selectArmorID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You dont have enough money to buy");
            }else{
                System.out.println("You bought the " + selectedArmor.getName());
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Your balance is : " + this.getPlayer().getMoney());
            }
        }
    }

}
