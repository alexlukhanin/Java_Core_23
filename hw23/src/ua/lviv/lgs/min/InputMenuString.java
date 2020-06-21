/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */

package ua.lviv.lgs.min;

/**
 * *
 * Console application with exception
 * @author alexl
 * 
 * @version 1.0
 *
 */

public class InputMenuString {
	/*This class checks menu input from user and assigns value of string, when it's correct*/
	boolean flag = false;
	private String string;

	public InputMenuString(String string) {
		super();
		if ((string.hashCode() >= 49 && string.hashCode() <= 57) || string.equals("q") || string.equals("menu") ) {
			this.string = string;
			flag = true;
		} else {			
			try {
				throw new Exception("Wrong choise, try again[1-9]...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				Main.Menu2();
				flag = false;
			}
		}
	}

	public String getString() {
		return string;
	}
}
