package Award;

public class Money extends  Award{
    public Money(int money) {
        super("Para", money, 0,0);
    }

    @Override
    public String toString(){
        return this.getMoney() + " " +this.getName();
    }
}
