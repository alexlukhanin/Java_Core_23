/** The homework on "Java Core" Course in LOGOS IT Academy Lesson 23. */

package ua.lviv.lgs.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * * Console application with exception
 * 
 * @author alexl
 * 
 * @version 1.0
 */

public class Fraction {
	private static final int MIN_DEPUTY_AGE = 25;
	private String name;
	private List<Deputy> list = new ArrayList<>();

	/** The constructor that construct class Fraction only by its name. */
	public Fraction(String name) {
		this.name = name;
	}

	/**
	 * This constructor makes possibility to add a list of deputies during
	 * construction of the class Fraction.
	 */
	public Fraction(String name, List<Deputy> list) {
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getList() {
		return list;
	}

	public void setList(List<Deputy> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Fraction [name=" + name + ", list=" + list + "]";
	}

	/* Declarations of methods: */

	/** AddDeputy declaration ...================================================ */
	@SuppressWarnings("resource")
	public void addDeputy() {
		String familyName = "";
		String firstName = "";
		int age = 0;
		boolean isBriber = false; // default value, we hope for better
		int weight = 0;
		int height = 0;

		Scanner sc; // creation of console scanner
		System.out.println("Adding the new deputy in the fraction...");
		System.out.println("Add first name:");
		sc = new Scanner(System.in); // input from user
		
		if (sc.hasNext()) {
			firstName = sc.next();
		}
		System.out.println("Add family name:");
		sc = new Scanner(System.in); // input from user
		if (sc.hasNext()) {
			familyName = sc.next();
		}
		/* Add age block ------------------------------------------------------ */
		do {
			System.out.println("Add age (integer value >= " + MIN_DEPUTY_AGE + " ):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number >= MIN_DEPUTY_AGE) {
					age = number;
					break;
				} else {
					try {
						throw new Exception("Value must be correct(age), try again...");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			} else {
				try {
					throw new Exception("Input integer value, try again...");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// sc.close(); // close the terminal/console session
		} while (true);
		/* Add weight block ----------------------------------------------- */
		do {
			System.out.println("Add weight (integer value >0):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number > 0) {
					weight = number;
					break;
				} else {
					try {
						throw new Exception("Value must be >0, try again...");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			} else {
				try {
					throw new Exception("Input integer value, try again...");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// sc.close(); // close the terminal/console session
		} while (true);
		/* Add height block -------------------------------------------------- */
		do {
			System.out.println("Add height (integer value >0):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number > 0) {
					height = number;
					break;
				} else {
					try {
						throw new Exception("Value must be >0, try again...");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			} else {
				try {
					throw new Exception("Input integer value, try again...");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// sc.close(); // close the terminal/console session
		} while (true);

		/* Add "isBriber" block ------------------------------------------------ */
		String string;

		do {
			System.out.println("Is the deputy a briber? (y/n):");
			sc = new Scanner(System.in); // input from user
			if (sc.hasNext()) {
				InputYesNoString inputYesNoString = new InputYesNoString(sc.next().toLowerCase());
				string = inputYesNoString.getString();

				if (inputYesNoString.flag) {
					if ("y".equals(string)) {
						isBriber = true;
					} else {
						isBriber = false;
					}
					break;
				}
			}
		} while (true);
		/* deputy creation and initialization */
		Deputy deputy = new Deputy(weight, height, familyName, firstName, age, isBriber);
		list.add(deputy);
		/* -------------- */
		list.get(list.size() - 1).giveBribe();
	}

	/**
	 * DeleteDeputy() declaration block
	 * ============================================.
	 */
	@SuppressWarnings("resource")
	public void deleteDeputy() {
		String familyName = "";
		String firstName = "";
		Scanner sc;
		System.out.println("Delete the deputy...");
		do {
			System.out.println("Input the first name of deputy:");
			sc = new Scanner(System.in);
			if (sc.hasNext()) {
				firstName = sc.next();
			}
			break;
		} while (true);

		do {
			System.out.println("Input the family name of deputy:");
			sc = new Scanner(System.in);
			if (sc.hasNext()) {
				familyName = sc.next();
			}
			break;
		} while (true);

		 final String familyName1 = familyName;
		 final String firstName1 = firstName;		
		 list.removeIf(x -> x.getFirstName().equalsIgnoreCase(firstName1) &&
		 x.getFamilyName().equalsIgnoreCase(familyName1));
		 System.out.println("Deputy " + firstName1 + " " +  familyName1 + " was deleted");
	}

	/**
	 * ShowAllBribers() declaration
	 * ==================================================.
	 */

	public void showAllBribers() {
		System.out.println("List of all bribers in the fraction:");
		list.stream().filter(Deputy::isBriber).forEach(System.out::println);
	}

	/** ShowMostBriber() declaration =======================================. */

	public void showMostBriber() {
		System.out.println("Most briber in the fraction is ... ");
		Deputy max; // index of max amount
		max = list.stream().reduce((left, right) -> left.getAmountOfBribe() > right.getAmountOfBribe() ? left : right)
				.get();
		System.out.println(max.toString());
	}

	/** ShowAllDeputies() declaration ===================================. */
	public void showAllDeputies() {
		System.out.println("List of all deputies in the fraction:");
		list.stream().forEach(System.out::println);
	}

	/** ClearFraction() declaration ===================================. */
	public void clearFraction() {
		list.clear();
	}
}
