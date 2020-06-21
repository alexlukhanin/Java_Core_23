/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 23
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

import java.util.InputMismatchException;
import java.util.Scanner;

public class Deputy extends Human {

	private String familyName;
	private String firstName;
	private int age;
	private boolean briber;

	/* amountOfBribe is not pass to constructor, depends of boolean "briber" */
	private int amountOfBribe = 0; // default amount = 0

	/* Constructor declaration */
	public Deputy(int weight, int height, String familyName, String firstName, int age, boolean briber) {
		super(weight, height);
		this.familyName = familyName;
		this.firstName = firstName;
		this.age = age;
		this.briber = briber;
	}
	/* getters and setters declarations */

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBriber() {
		return briber;
	}

	public void setBriber(boolean briber) {
		this.briber = briber;
	}

	public int getAmountOfBribe() {
		return amountOfBribe;
	}

	public void setAmountOfBribe(int amountOfBribe) {
		this.amountOfBribe = amountOfBribe;
	}

	@Override
	public String toString() {
		return "Deputy [familyName=" + familyName + ", firstName=" + firstName + ", age=" + age + ", briber=" + briber
				+ ", amountOfBribe=" + amountOfBribe + "]";
	}

	/* method giveBribe() - result depends on how much bride was given */

	@SuppressWarnings("resource")
	public void giveBribe() {
		Scanner sc = new Scanner(System.in);
		if (!briber) {
			System.out.println("This deputy is not a briber!");
		} else {
			System.out.println("Input the amount of bribe");

			while (true) {

				int tempAmount = 0;
				/* input from console and checking for integer value */
				try {
					tempAmount = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Input integer number");
				}

				if (tempAmount > 5000) {
					System.out.println("Police will put a criminal in jail");
					break;
				} else if (tempAmount <= 5000 && tempAmount > 0) {
					this.amountOfBribe = tempAmount;

					break;
				} else {
					System.out.println("Input right amount of bribe ( > 0 )...");
					sc = new Scanner(System.in);
				}
			}

		}

	}

}
