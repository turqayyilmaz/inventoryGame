package Game;

import Location.*;

import java.util.Scanner;


public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);

		System.out.println("*********** Macera Oyununa Ho�geldiniz ! ***********");
		System.out.println();
		System.out.print("Oyuna ba�lamadan �nce isminizi giriniz : ");
		String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCha();
		start();
	}

	public void start() {
		while (true) {
			location = null;
			this.player.getInv().printCompletedLocations();

			System.out.println();
			System.out.println("=================================================");
			System.out.println();
			System.out.println("************  M E K A N L A R ************");
			System.out.println("1. G�venli Ev --> Size ait g�venli bir mekan, d��man yok !");
			System.out.println("2. Ma�ara --> Kar��n�za belki zombi ��kabilir !");
			System.out.println("3. Orman --> Kar��n�za belki vampir ��kabilir !");
			System.out.println("4. Nehir --> Kar��n�za belki ay� ��kabilir !");
			System.out.println("5. Maden --> Kar��n�za belki y�lan ��kabilir !");
			System.out.println("6. Ma�aza --> Silah veya Z�rh alabilirsiniz!");
			System.out.print("Gitmek istedi�iniz yer : ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 6) {
				System.out.print("L�tfen ge�erli bir yer se�iniz : ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
				case 2:
					if (player.getInv().locIsCompleted("Ma�ara")) {
						printLocCompleted();
						continue;
					} else {
						location = new Cave(player);
						break;

					}

				case 3:
					if (!player.getInv().locIsCompleted("Orman")) {
						location = new Forest(player);
					} else {
						printLocCompleted();
						continue;
					}
					break;

				case 4:
					if (!player.getInv().locIsCompleted("Nehir")) {
						location = new River(player);
					} else {
						printLocCompleted();
						continue;
					}
					break;
				case 5:
					if (!player.getInv().locIsCompleted("Maden")) {
						location = new Mine(player);
					} else {
						printLocCompleted();
						continue;
					}
					break;


				case 6:
					location = new ToolStore(player);
					break;
				default:
					location = new SafeHouse(player);
			}

			if (location.getClass().getName().equals("Location.SafeHouse")) {
				if (player.getInv().locIsCompleted("Ma�ara") && player.getInv().locIsCompleted("Orman") && player.getInv().locIsCompleted("Nehir") && player.getInv().locIsCompleted("Maden"))
					System.out.println("Tebrikler Oyunu Kazand�n�z !");
				break;

			}

			if (!location.getLocation()) {
				System.out.println("Oyun Bitti !");
				break;
			}

		}
	}
	public void printLocCompleted(){
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Daha �nce bu b�l�m� tamamlad�n�z.");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
	}
}
