/* Author: Luigi Vincent

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueElements {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printUniques(input.nextLine().split(","));
		}
	}

	private static void printUniques(String[] input) {
		StringBuilder result = new StringBuilder();
		Set<String> helper = new LinkedHashSet<>();

		for (String s : input) {
			helper.add(s);
		}

		for (String s : helper) {
			result.append(',').append(s);
		}

		System.out.println(result.substring(1));	
	}

}
