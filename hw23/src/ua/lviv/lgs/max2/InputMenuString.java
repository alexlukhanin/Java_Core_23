package ua.lviv.lgs.max2;
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
		if ((string.hashCode() >= 49 && string.hashCode() <= 57) ) {
			this.string = string;
			flag = true;
		} else {
			try {
				throw new Exception("Wrong choise, try again[1-9]...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				flag = false;
			}
		}
	}
	public String getString() {
		return string;
	}
}
