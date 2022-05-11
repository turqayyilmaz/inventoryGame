package Award;

public abstract class Award {
    protected String name;
    protected int money;
    protected int damage;
    protected int avoid;

    public Award(String name, int money, int damage, int avoid) {
        this.name = name;
        this.money = money;
        this.damage = damage;
        this.avoid = avoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAvoid() {
        return avoid;
    }

    public void setAvoid(int avoid) {
        this.avoid = avoid;
    }
}
