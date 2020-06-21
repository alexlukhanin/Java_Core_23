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

public class Human {
	
	private int weight; // int because weight in pounds  
	private int height; // int because height in cm
	public Human(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human [weight=" + weight + ", height=" + height + "]";
	}
	
	

}
