package Game;

import Location.Location;
import Location.SafeHouse;
import Location.Forest;
import Location.Cave;
import Location.ToolStore;
import Location.River;
import java.util.Scanner;


public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Ho�geldiniz !");
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
			System.out.println("Eylem ger�ekle�tirmek i�in bir yer se�iniz : ");
			System.out.println("1. G�venli Ev --> Size ait g�venli bir mekan, d��man yok !");
			System.out.println("2. Ma�ara --> Kar��n�za belki zombi ��kabilir !");
			System.out.println("3. Orman --> Kar��n�za belki vampir ��kabilir !");
			System.out.println("4. Nehir --> Kar��n�za belki ay� ��kabilir !");
			System.out.println("5. Ma�aza --> Silah veya Z�rh alabilirsiniz!");
			System.out.print("Gitmek istedi�iniz yer : ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("L�tfen ge�erli bir yer se�iniz : ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
				case 2:
					if(player.getInv().locIsCompleted("Ma�ara"))
					{
						printLocCompleted();
						continue;
					}
					else {
						location = new Cave(player);
						break;

					}

			case 3:
				if(!player.getInv().locIsCompleted("Orman"))
				{
					location = new Forest(player);
				}
				else {
					printLocCompleted();
					continue;
				}
				break;

				case 4:
				if(!player.getInv().locIsCompleted("Nehir"))
				{
					location = new River(player);
				}
				else {
					printLocCompleted();
					continue;
				}
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getClass().getName().equals("Location.SafeHouse")) {
//				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
//					System.out.println("Tebrikler Oyunu Kazand�n�z !");
//					break;

//				}
			}
			if (!location.getLocation()) {
				System.out.println("Oyun Bitti !");
				break;
			}

		}
	}
	public void printLocCompleted(){
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("Daha �nce bu b�l�m� tamamlad�n�z.");
		System.out.println("--------------------------------------");
		System.out.println();
	}
}
