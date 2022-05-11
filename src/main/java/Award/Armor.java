package Award;

public class Armor extends Award {
    private int price;

    public Armor(String name, int avoid, int price) {
        super(name, 0, 0, avoid);
        this.price = price;
    }

    public static Armor[] armorList() {
        Armor[] armorArr = {new Armor("Hafif Zýrh", 1, 15),
                new Armor("Orta Zýrh", 3, 25),
                new Armor("Aðýr Zýrh", 5, 40)};
        return armorArr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
