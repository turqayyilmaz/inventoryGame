package Location;

import Award.Award;
import Game.Player;
import Award.Weapon;
import Award.Armor;
import Award.Money;
import Obstacle.Obstacle;

import java.util.Random;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected Award award;
	protected boolean isCompleted = false;
	BattleLoc(Player player, String name, Obstacle obstacle, Award award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("�uan buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " ya��yor !");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		System.out.print("<S>ava� veya <K>a� :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println("***********************************************");
				System.out.println(this.getName() + " b�lgesindeki t�m d��manlar� temizlediniz !");
				this.isCompleted=true;
				player.getInv().addAward(award);
				player.getInv().locCompleted(this);
				System.out.println(this.award.getName() + " Kazand�n�z! ");
				System.out.println("***********************************************");
				System.out.println();
				return true;
			}

			if(player.getHealthy() <= 0) {
				System.out.println();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("�ld�n�z !");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				return false;
			}
		
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			int whoStart = new Random().nextInt(2); // 0-> player 1->obstacle
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya <K>a� :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					if(whoStart==0){
						playerHit();
						obstacleHit();
					}
					else {
						obstacleHit();
						playerHit();
					}
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("D��man� yendiniz !");
				String aw = obstacle.getAward().getClass().getName();
				System.out.println(obstacle.getAward().toString() + " Kazand�n�z !!!!!!!!!!!!!!");
				switch (aw){
					case "Award.Weapon":
						this.player.getInv().setWeapon((Weapon)obstacle.getAward());
						break;
					case "Award.Armor":
						this.player.getInv().setArmor((Armor) obstacle.getAward());
						break;
					case "Award.Money":
						player.setMoney(player.getMoney() + obstacle.getAward().getMoney());
						break;
				}


				System.out.println("G�ncel Paran�z : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	private void obstacleHit() {
		System.out.println("Canavar size vurdu !");

		int totalHealth=player.getHealthy();

		if(player.getInv().getArmor() != null)
			totalHealth += player.getInv().getArmor().getAvoid();
		player.setHealthy(totalHealth - obstacle.getDamage());

		afterHit();
		if (player.getHealthy() > 0) {
			System.out.println();
			System.out.println("Siz vurdunuz !");
			obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());


			afterHit();
		}
	}

	private void playerHit() {
		System.out.println("Siz vurdunuz !");
		obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
		afterHit();
		if (obstacle.getHealth() > 0) {
			System.out.println();
			System.out.println("Canavar size vurdu !");
			int totalHealth=player.getHealthy();
			if(player.getInv().getArmor() != null)
				totalHealth += player.getInv().getArmor().getAvoid();
			player.setHealthy(totalHealth - obstacle.getDamage());
			afterHit();
		}
	}

	public void playerStats() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("Oyuncu De�erleri\n--------------");
		System.out.println("Can:" + player.getHealthy());
		System.out.println("Hasar:" + player.getTotalDamage());
		System.out.println("Para:" + player.getMoney());


		if (player.getInv().getWeapon() != null) {
			System.out.println("Silah:" + player.getInv().getWeapon().getName());
		}
		if (player.getInv().getArmor() != null) {
			System.out.println("Z�rh:" + player.getInv().getArmor().getName());
		}

		System.out.println("******************************************");
	}

	public void enemyStats() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("\n" + obstacle.getName() + " De�erleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("�d�l:" + obstacle.getAward().toString());
		System.out.println("******************************************");
	}

	public void afterHit() {
		System.out.println();
		System.out.println("******************************************");
		System.out.println("Oyuncu Can�:" + player.getHealthy());
		System.out.println(obstacle.getName() + " Can�:" + obstacle.getHealth());
		System.out.println("******************************************");
		System.out.println();
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}
}
