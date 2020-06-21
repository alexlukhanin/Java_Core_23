package ua.lviv.lgs.max2;

import java.util.Scanner;
/**
 * @author alexl
 *
 */
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Commodity commodity = new Commodity();
		String menuString;
		Scanner sc;
		while (true) {
			System.out.println();
			printMenu();
			/* checking of menuString from the user */
			sc = new Scanner(System.in);
			InputMenuString inputMenuString = new InputMenuString(sc.next().toLowerCase());
			menuString = inputMenuString.getString();

			if (inputMenuString.flag) {
				switch (menuString) {
				case "1": { commodity.addCommodity(); break; }
				case "2": { commodity.removeCommodity(); break;}
				case "3": { commodity.changeCommodity(); break;}
				case "4": { commodity.sortByName();	break;}
				case "5": { commodity.sortByLength(); break; }
				case "6": { commodity.sortByWidth(); break;}
				case "7": { commodity.sortByWeight(); break;}
				case "8": { commodity.getCommodityByNumber(); break;}
				case "9": { 
					System.out.println("Exit application... Good buy!");
					System.exit(0);
					sc.close();
					break;
				}

				}
			}
		}
	}

	public static void printMenu() {
		System.out.println("| -----------------Menu--------------------|");
		System.out.println("| Input 1 to add Commodity                 |");
		System.out.println("| Input 2 to delete chosen Commodity       |");
		System.out.println("| Input 3 to change Commodity              |");
		System.out.println("| Input 4 to sort Commodity by name        |");
		System.out.println("| Input 5 to sort Commodity by length      |");
		System.out.println("| Input 6 to sort Commodity by width       |");
		System.out.println("| Input 7 to sort Commodity by weight      |");
		System.out.println("| Input 8 to get Commodity by index        |");
		System.out.println("| Input 9 to exit                          |");
	}
}
