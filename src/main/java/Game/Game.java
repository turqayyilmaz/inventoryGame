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
		System.out.println("Macera Oyununa Hoþgeldiniz !");
		System.out.print("Oyuna baþlamadan önce isminizi giriniz : ");
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
			System.out.println("Eylem gerçekleþtirmek için bir yer seçiniz : ");
			System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düþman yok !");
			System.out.println("2. Maðara --> Karþýnýza belki zombi çýkabilir !");
			System.out.println("3. Orman --> Karþýnýza belki vampir çýkabilir !");
			System.out.println("4. Nehir --> Karþýnýza belki ayý çýkabilir !");
			System.out.println("5. Maðaza --> Silah veya Zýrh alabilirsiniz!");
			System.out.print("Gitmek istediðiniz yer : ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("Lütfen geçerli bir yer seçiniz : ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
				case 2:
					if(player.getInv().locIsCompleted("Maðara"))
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
//					System.out.println("Tebrikler Oyunu Kazandýnýz !");
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
		System.out.println("Daha önce bu bölümü tamamladýnýz.");
		System.out.println("--------------------------------------");
		System.out.println();
	}
}
