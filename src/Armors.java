public class Armors {

    private String name;
    private int id;
    private int block;
    private int price;

    public Armors(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }
    public static Armors[] armors() {
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors("Kalkan",1,1,25);
        armorList[1] = new Armors("Ejder kalkan",2,3,35);
        armorList[2] = new Armors("Hiperwawe kalkan",3,5,45);
        return armorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return block;
    }

    public void setDamage(int damage) {
        this.block = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
