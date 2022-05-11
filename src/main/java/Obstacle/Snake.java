package Obstacle;

import Award.Award;
import Award.Money;
import Award.Weapon;
import Award.Armor;

import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super("Yýlan", 0, 12, null,  5);
        //damage and award fill in
        Random rand = new Random();

        int damage=rand.nextInt(3,8);
        System.out.println("Yýlan hasar : " + damage);

        this.setDamage(damage);




        Award award= null;

        rand = new Random(100);
        int prob= rand.nextInt()+1;
        int subProb= rand.nextInt()+1;
        if(prob<=15){
            if(subProb<=20){
                award= Weapon.weaponList()[2];
            }
            else if(subProb>20 && subProb<=50){
                award= Weapon.weaponList()[1];
            }
            else{
                award= Weapon.weaponList()[0];
            }
        }
        else if(prob>15 && prob<=30){
            if(subProb<=20){
                award= Armor.armorList()[2];
            }
            else if(subProb>20 && subProb<=50){
                award= Armor.armorList()[1];
            }
            else{
                award= Armor.armorList()[0];
            }
        }
        else if(prob>30 && prob<=55){
            if(subProb<=20){
                award=new Money(10);
            }
            else if(subProb>20 && subProb<=50){
                award=new Money(5);
            }
            else{
                award=new Money(1);
            }
        }

        this.setAward(award);
    }
}
