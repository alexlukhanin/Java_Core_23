package ua.lviv.lgs.max2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Commodity {

	private String name;
	private double length;
	private double width;
	private double weight;

	public Commodity(String name, double length, double width, double weight) {
		super();
		this.name = name;
		this.length = length;
		this.width = width;
		this.weight = weight;
	}

	public Commodity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", length=" + length + ", width=" + width + ", weight=" + weight + "]";
	}

	ArrayList<Commodity> commodities = new ArrayList<Commodity>();
	Scanner sc = new Scanner(System.in);

	/* private method that inputs string from console and returns it */
	private String inputStringFromConsole(String message) {
		System.out.println(message);
		sc = new Scanner(System.in);
		String resultString = null;
		if (sc.hasNext()) {
			resultString = sc.next();
		} else {
			try {
				throw new Exception("Check Your string and try again");
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		return resultString;
	}
	/* private method that inputs double from console and returns it */
	private double inputDoubleFromConsole(String message) {
		System.out.println(message);
		double result = 0;
		while (true) {
			sc = new Scanner(System.in);
			if (sc.hasNextDouble()) {
				result = sc.nextDouble();
				break;
			} else {
				try {
					throw new Exception(
							"Enter double number with , or . acording to Your local settings and w/o any letters or other symbols");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	}

	/* private method helps to make simpler to print the list every time */
	private void showList(List<Commodity> list) {
		System.out.println();
		if (!list.isEmpty()) {
			System.out.println("The list looks now in this way:");
			list.stream().forEach(System.out::println);
		} else {
			System.out.println("The list is empty...");
		}
	}

	/* private method that inputs int from console and returns it */
	private int inputIntFromConsole(String message) {
		System.out.println(message);
		int result = 0;
		while (true) {
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				result = sc.nextInt();
				break;
			} else {
				try {
					throw new Exception(
							"Enter int number with  w/o any letters or other symbols");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	}

	/* public methods: =============================================== */

	/* method adds commodity to Arraylist of commodities from console */
	public void addCommodity() {
		System.out.println();
		System.out.println("Please input information about commodity:");
		String name = inputStringFromConsole("Please enter name(string):");
		double length = inputDoubleFromConsole("Please enter length(double number):");
		double width = inputDoubleFromConsole("Please enter width(double number):");
		double weight = inputDoubleFromConsole("Please enter weight(double number):");
		commodities.add(new Commodity(name, length, width, weight));
		showList(commodities);
	}

	/*
	 * method removes all commodity from Arraylist of commodities by name from
	 * console
	 */
	public void removeCommodity() {
		System.out.println();
		System.out.println("Please input information about commodity to remove:");
		final String name = inputStringFromConsole("Please enter name(string):");
		boolean isInList = false;
		if (commodities.removeIf(c -> c.getName().equals(name))) {
			System.out.println("Commodity [" + name + "] was removed succesfully");
			isInList = true;
		}
		
		if (!isInList) {
			System.out.println("There are not commodity that You entered in the list");
		}
		showList(commodities);
	}
	/*
	 * method changes commodity from Arraylist with commodity by name from console
	 */
	public void changeCommodity() {
		System.out.println();
		System.out.println("Please input information about commodity to change:");
		String name = inputStringFromConsole("Please enter name(string):");
		double length = inputDoubleFromConsole("Please enter length(double number):");
		double width = inputDoubleFromConsole("Please enter width(double number):");
		double weight = inputDoubleFromConsole("Please enter weight(double number):");

		System.out.println("Please input information about new commodity :");
		String nameNew = inputStringFromConsole("Please enter name(string):");
		double lengthNew = inputDoubleFromConsole("Please enter length(double number):");
		double widthNew = inputDoubleFromConsole("Please enter width(double number):");
		double weightNew = inputDoubleFromConsole("Please enter weight(double number):");

		boolean isInList = false; // checks that it is in the list or not, default is "false"
		Predicate<Commodity> isQualified = c -> (c.getName().equals(name)) && (c.getLength() == length)
				&& (c.getWeight() == weight) && (c.getWidth() == width);
		
		Stream<Commodity> filter = commodities.stream().filter(isQualified);
		List<Commodity> listTemp = filter.collect(Collectors.toList());
		
		listTemp.stream().forEach(System.out::println);
		if(!listTemp.isEmpty())
			isInList = true;
		listTemp.stream().forEach(c -> {
			c.setName(nameNew);
			c.setLength(lengthNew);
			c.setWidth(widthNew);
			c.setWeight(weightNew);
			System.out.println("Commodity [" + name + "] was changed succesfully with new parameters");
			//isInList = true;
		});
		if (!isInList) {
			System.out.println("There are not commodity that You entered(name, length, width, weight)");
			System.out.println("in the list. There are no changes was made");
		}
		showList(commodities);
	}

	/* sorting methods by different fields */
	public void sortByName() {
		System.out.println("List is sorted by name");
		List<Commodity> collect = commodities.stream().sorted(Comparator.comparing(Commodity::getName)).collect(Collectors.toList());
		showList(collect);
	}

	public void sortByLength() {
		System.out.println("List is sorted by length");
		List<Commodity> collect = commodities.stream().sorted(Comparator.comparing(Commodity::getLength)).collect(Collectors.toList());
		showList(collect);	
	}

	public void sortByWidth() {
		System.out.println("List is sorted by width");
		List<Commodity> collect = commodities.stream().sorted(Comparator.comparing(Commodity::getWidth)).collect(Collectors.toList());
		showList(collect);	
	}

	public void sortByWeight() {
		System.out.println("List is sorted by weight");
		List<Commodity> collect = commodities.stream().sorted(Comparator.comparing(Commodity::getWeight)).collect(Collectors.toList());
		showList(collect);	
	}

	public void getCommodityByNumber() {
		int i = inputIntFromConsole(
				"Please enter the number of commodity to chose (from 0 till " + (commodities.size() - 1) + ") ");
		System.out.println(i);
		if (i < (commodities.size()) && (i >= 0)) {
			System.out.println("Number " + i + " corresponds to " + commodities.get(i));
		} else {
			try {
				throw new Exception(
						"You entered number that not corresponds to any of commodities");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

