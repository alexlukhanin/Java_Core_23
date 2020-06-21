/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */
package ua.lviv.lgs.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @author alexl
 *
 */

/** Singleton class Parliament declaration */
public class Parliament {
	/* Singleton pattern realisation */
	private static Parliament instance;

	private Parliament() {
	};

	public static Parliament getInstance() {
		if (instance == null) {
			instance = new Parliament();
		}
		return instance;
	}

	/* list of fractions */

	List<Fraction> list = new ArrayList<Fraction>();

	/* Methods declaration block: ==================== */

	/** the additional private method to check input of fraction from console */
	@SuppressWarnings("resource")
	private Fraction checkInputFraction(String string) {
		Fraction fractionReturn = new Fraction(null);
		System.out.println(string);
		showAllFractions();
		boolean flag = false;

		while (true) {
			/* input from user */
			Scanner sc = new Scanner(System.in);
			String fractionName = "";
			if (sc.hasNext()) {
				fractionName = sc.next();
			}
			final String fractName = fractionName;
			if (list.size() > 0) {
				fractionReturn = list.stream().filter(f -> f.getName().toString().equalsIgnoreCase(fractName)).findFirst().get();
				flag = true;
			} else if (list.size() == 0) {
				System.out.println("There are no fractions at all yet...");
				break;
			} else {
				/* just in case :) */
				System.out.println("Number of fractions can not be negative, there is some error in here...");
				break;
			}

			if (!flag) {
				System.out.println("There is not the fraction with the name You input, try again");
			} else {
				break;
			}
		}
		return fractionReturn;
	}

	/* addFraction method adds new fraction to Parliament */
	@SuppressWarnings("resource")
	public void addFraction() {
		System.out.println("Please, input the name of new fraction:");
		Scanner sc = new Scanner(System.in);
		String fractionName = "";
		if (sc.hasNext()) {
			fractionName = sc.next();
		}

		Fraction fraction = new Fraction(fractionName);
		list.add(fraction);
		System.out.println("Fraction " + fraction.toString() + " added to Parliament");
	}

	/*
	 * deleteFraction() asks user to choose name of fraction from the list (that it
	 * prints) and then checks input from user. If name is incorrect, user have to
	 * try until he/she will input correct one. To print the list of fractions it
	 * uses method showAllFractions()
	 */
	@SuppressWarnings("resource")
	public void deleteFraction() {

		System.out.println("Please, input the name of fraction to delete(choose from the list):");
		showAllFractions();
		boolean flag = false;

		while (true) {

			/* input from user */
			Scanner sc = new Scanner(System.in);
			String fractionName = "";
			if (sc.hasNext()) {
				fractionName = sc.next();
			}
			
			if (list.size() > 0) {
				final String fractName = fractionName;
				Predicate<Fraction> isQualified = f -> f.getName().toString().equalsIgnoreCase(fractName);
				if(list.removeIf(isQualified)) {
					System.out.println("Fraction " + fractName + 
							" has been deleted" + " from Parliament.");
					flag = true;
				}
					
			} else if (list.size() == 0) {
				System.out.println("There are no fractions at all yet...");
				break;
			} else {
				/* just in case :) */
				System.out.println("Number of fractions can not be negative, there is some error in here...");
				break;
			}
			if (!flag) {
				System.out.println("There is not the fraction with the name You input, try again");
			} else {
				break;
			}
		}
	}
	/* just list names of all fractions */
	public void showAllFractions() {
		list.stream().forEach(f -> System.out.println("[" + f.getName().toString() + "]"));
	}

	public void showFraction() {
		Fraction fraction = checkInputFraction("Please choose fraction name to show all fraction");
		System.out.println("Fraction " + fraction.getName().toString() + ":");
		System.out.println(fraction.toString());
	}

	public void addDeputyToFraction() {
		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to add deputy in");
		fraction.addDeputy();
	}

	public void deleteDeputyFromFraction() {
		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to delete deputy from");
		fraction.deleteDeputy();
	}

	public void showAllBribersInFraction() {
		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show all bribers in it");
		fraction.showAllBribers();
	}

	public void showMostBriberInFraction() {
		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show most briber in it");
		fraction.showMostBriber();
	}

	public void showAllDeputiesInFraction() {
		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show all deputies in it");
		fraction.showAllDeputies();
	}

	public void clearFraction() {
		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to clear");
		fraction.clearFraction();
	}
}
