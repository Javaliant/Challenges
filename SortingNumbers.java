/* Author: Luigi Vincent

Challenge: Write a program which sorts numbers

Specifications: Accept a path to a file as the first argument of the program.
Please note, that you need to print the numbers till the 3rd digit after 
the dot including trailing zeros.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortingNumbers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while(fileInput.hasNextLine()) {
			printSortedNumbers(fileInput.nextLine());
		}
	}

	private static void printSortedNumbers(String line) {
		String[] numbers = line.split(" ");
		Set<Float> sorted = new TreeSet<>();
		StringBuilder sortedNumbers = new StringBuilder();

		for (String s : numbers) {
			sorted.add(Float.parseFloat(s));
		}
		for (float f : sorted) {
			sortedNumbers.append(String.format("%.3f", f)).append(' ');
		}
		sortedNumbers.setLength(sortedNumbers.length() - 1);

		System.out.println(sortedNumbers.toString());
	}
}
