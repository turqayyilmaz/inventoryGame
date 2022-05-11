package Award;

public class Weapon extends Award{
    private int price;
    public Weapon(String name, int damage, int price) {
        super(name, 0, damage, 0);
        this.price=price;
    }

    public static Weapon[] weaponList(){
        Weapon[] weapons={new Weapon("Tabanca",2,25),
                new Weapon("Kýlýç",3,35),
                new Weapon("Tüfek",7,45)};
        return weapons;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
