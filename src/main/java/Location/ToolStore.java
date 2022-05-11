package Location;

import Award.Armor;
import Award.Weapon;
import Game.Player;
import Location.NormalLoc;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Maðaza");
	}

	public boolean getLocation() {
		System.out.println("Para : " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zýrhlar");
		System.out.println("3. Çýkýþ");
		System.out.print("Seçiminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}

		return true;
	}
	
	public int armorMenu() {
		int i=1;
		Armor[] armorList= Armor.armorList();
		for(Armor a: armorList){
			System.out.println(i++ +". "+ a.getName() +" \t <Hasar : "+a.getAvoid() + " - Para : "+a.getPrice()+">");
		}
		System.out.println("0. Çýkýþ");
		System.out.print("Zýrh Seçiniz : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID) {
		Armor armor=null;
		Armor[] armorList= Armor.armorList();
		if(itemID==0){
			System.out.println("Çýkýþ yapýlýyor.");
		}
		else if(itemID>0 && itemID<=armorList.length)
		{
			armor=armorList[itemID-1];
		}
		else{
			System.out.println("Geçersiz iþlem girdiniz.");
		}
		if(armor!=null){
			if (player.getMoney() >= armor.getPrice()) {
				player.getInv().setArmor(armor);
				player.setMoney(player.getMoney() - armor.getPrice());
				System.out.println(armor.getName() + " satýn aldýnýz, Engellenen Hasar : " +armor.getAvoid());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}


	}

	public int weaponMenu() {
		int i=1;
		Weapon[] weaponList= Weapon.weaponList();
		for(Weapon w: weaponList){
			System.out.println(i++ +". "+ w.getName() +" \t <Hasar : "+w.getDamage() + " - Para : "+w.getPrice()+">");
		}
		System.out.println("0. Çýkýþ");
		System.out.print("Silah Seçiniz : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		Weapon[] weaponList= Weapon.weaponList();
		Weapon weapon=null;

		if(itemID==0){
			System.out.println("Çýkýþ yapýlýyor.");
		}
		else if(itemID>0 && itemID<=weaponList.length){
			weapon=weaponList[itemID-1];
		}else {
			System.out.println("Geçersiz iþlem girdiniz.");
		}

		if (weapon!=null) {
			if (player.getMoney() > weapon.getPrice()) {
				player.getInv().setWeapon(weapon);
				player.setMoney(player.getMoney() - weapon.getPrice());
				System.out.println(weapon.getName() + " satýn aldýnýz, Önceki Hasar :" + player.getDamage() + ", Yeni Hasar : "
						+ player.getTotalDamage());
				System.out.println("Kalan Para :" + player.getMoney());
			} else System.out.println("Para yetersiz. !");
		}
	}

}
