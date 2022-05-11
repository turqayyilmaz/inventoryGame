package Inventory;

import Award.Armor;
import Award.Award;
import Award.Weapon;
import Location.Location;

public class Inventory {
    private Armor armor;
    private Weapon weapon;
    private Award[] awards = new Award[10];
    private String[] completedLocations = new String[10];
    private int locCount =0;
    private int awardCount =0;


    public void locCompleted(Location loc)
    {
        completedLocations[locCount++]=loc.getName();
        //System.out.println(loc.getName() + " Lokasyon eklendir");
    }

    public boolean locIsCompleted(String loc){

        for(int i=0;i<locCount;i++){
            if(completedLocations[i].equals(loc))
                return true;
        }

        return false;
    }

    public void printCompletedLocations(){

        System.out.println("********************************");
        System.out.println("Tamamlanan lokasyonlar");
        System.out.println("********************************");
        for(int i=0;i<locCount;i++)
            System.out.println(this.completedLocations[i]);

        System.out.println("********************************");
        System.out.println();
    }

    public Inventory() {

        this.armor = null;
        this.weapon = null;

    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Award[] getAwards() {
        return awards;
    }

    public void addAward(Award award){
        this.awards[this.awardCount++]=award;
    }
    public void setAwards(Award[] awards) {
        this.awards = awards;
    }
}
