package Location;

import Award.Award;
import Game.Player;

import Obstacle.Obstacle;

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
		System.out.println("�uan buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " ya��yor !");
		System.out.print("<S>ava� veya <K>a� :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " b�lgesindeki t�m d��manlar� temizlediniz !");
				this.isCompleted=true;
				player.getInv().addAward(award);
				player.getInv().locCompleted(this);
				System.out.println(this.award.getName() + " Kazand�n�z! ");
				return true;
			}

			if(player.getHealthy() <= 0) {
				System.out.println("�ld�n�z !");
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
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya <K>a� :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
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
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("D��man� yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("G�ncel Paran�z : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	public void playerStats() {
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
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " De�erleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("�d�l:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Can�:" + player.getHealthy());
		System.out.println(obstacle.getName() + " Can�:" + obstacle.getHealth());
		System.out.println();
	}

}
