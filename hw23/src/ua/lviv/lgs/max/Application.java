package ua.lviv.lgs.max;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
/**
 * @author alexl
 *
 *@version 1.0
 */
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* declaration and filling the set */
		Set<Employee> setEmployees = new HashSet<>();
		Random random = new Random();
		/*
		 * filling set with random values and method randomNameString to create random
		 * names and surnames of employees
		 */
		for (int i = 0; i < 10; i++) {
			setEmployees
					.add(new Employee(randomNameString(10) + " " + randomNameString(15), (18 + random.nextInt(70))));
		}
		System.out.println("========================================");
		System.out.println("Print Unsorted HashSet Collection: ");
		setEmployees.stream().forEach(System.out::println);
		System.out.println("========================================");
		
		System.out.println();
		System.out.println("Sorting HashSet using Comparator: ");
		List<Employee> list = setEmployees.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println();
		System.out.println("Print sorted HashSet Collection by name: ");
		list.stream().forEach(System.out::println);
		list = setEmployees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		System.out.println();
		System.out.println("Print sorted HashSet Collection by age: ");
		list.stream().forEach(System.out::println);
		
		/* TreeSet sorting block ====================================== */

		System.out.println();
		System.out.println("Original Treeset");
		System.out.println();
		/* Declaration of TreeSet with unsorted HashSet */
		TreeSet<Employee> setTS = new TreeSet<>(setEmployees);
		setTS.stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Sorting using Treeset and Comparator (reverseorder) by age");
		System.out.println();
			
		List<Employee> list2 = setTS.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		list2.stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Sorting using Treeset and Comparator (reverseorder) by name");
		System.out.println();
		List<Employee> list3 = setTS.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		list3.stream().forEach(System.out::println);

	}

	/*
	 * this method generates string from first uppercase and other lowercase
	 * symbols(Latin) with length not more then maxLenght I did not use any sources
	 * to find out how to do this (just only unicode table). It was interesting to do
	 * this. But I am sure that it already exists. I hope my way is good enough.  
	 */
	public static String randomNameString(int maxLength) {

		Random random = new Random();
		/* length is randomly signed but not more then 'maxLenth' */
		int length = random.nextInt(maxLength) + 1;

		/* declare array of chars with fixed length */
		char[] array = new char[length];

		array[0] = (char) (random.nextInt(25) + 65);

		for (int i = 1; i < length; i++) {

			array[i] = (char) (random.nextInt(25) + 97);

		}

		String resultString = new String(array);

		return resultString;
	}

}