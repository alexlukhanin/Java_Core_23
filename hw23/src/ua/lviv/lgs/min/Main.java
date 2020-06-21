/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */

package ua.lviv.lgs.min;

/**
 * * Console application with exception
 * 
 * @author alexl
 * 
 * @version 1.0
 *
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String menuString;
		Scanner sc;
		Menu();
		Menu2();

		while (true) {
			/* checking of menuString from the user */
			sc = new Scanner(System.in);
			InputMenuString inputMenuString = new InputMenuString(sc.next().toLowerCase());

			menuString = inputMenuString.getString();

			if (inputMenuString.flag) {
				switch (menuString) {
				case "1": {
					Parliament.getInstance().addFraction();
					break;
				}
				case "2": {
					Parliament.getInstance().deleteFraction();
					break;
				}
				case "3": {
					Parliament.getInstance().showAllFractions();
					break;
				}
				case "4": {
					Parliament.getInstance().clearFraction();
					break;
				}
				case "5": {
					Parliament.getInstance().showFraction();
					break;
				}
				case "6": {
					Parliament.getInstance().addDeputyToFraction();
					break;
				}
				case "7": {
					Parliament.getInstance().deleteDeputyFromFraction();
					break;
				}
				case "8": {
					Parliament.getInstance().showAllBribersInFraction();
					break;
				}
				case "9": {
					Parliament.getInstance().showMostBriberInFraction();
					break;
				}
				case "menu": {
					Menu();
					break;
				}
				case "q": {
					System.out.println("Exit application... Good buy!");
					System.exit(0);
					sc.close();
				}

				}
				Menu2();
			}
		}

	}

	public static void Menu() {
		System.out.println("| -----------------------Menu------------------------|");
		System.out.println("| Input 1 to add fraction                            |");
		System.out.println("| Input 2 to delete chosen fraction                  |");
		System.out.println("| Input 3 to show all fractions                      |");
		System.out.println("| Input 4 to clear chosen fraction                   |");
		System.out.println("| Input 5 to show chosen fraction                    |");
		System.out.println("| Input 6 to add deputy to chosen fraction           |");
		System.out.println("| Input 7 to delete deputy from chosen fraction      |");
		System.out.println("| Input 8 to show all bribers in chosen fraction     |");
		System.out.println("| Input 9 to show a most briber in chosen fraction   |");

	}

	public static void Menu2() {
		System.out.println("[menu] - show all Menu again");
		System.out.println("[q] - quit the program");

	}

}
