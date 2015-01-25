/* Author: Luigi Vincent

Challenge: Write a program that alters a sentence to rollercoaster case.

Specifications: Accept a path to a file as the first argument of the program.

The first letter of the line should be in uppercase.
The next letter should be in lowercase.
The next letter should be in uppercase, and so on.
Any characters, except for the letters, 
are ignored during determination of letter case.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CapitalizeWords {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while(fileInput.hasNextLine()) {
			printCapitalized(fileInput.nextLine());
		}
	}

	private static void printCapitalized(String line) {
		System.out.println(capitalizeWords(line));
	}

	private static String capitalizeWords(String line) {
		String[] words = line.split(" ");
		StringBuilder capitalized = new StringBuilder();
		for (String s : words) {
			capitalized.append(
				s.substring(0, 1).toUpperCase() +
				s.substring(1)
			)
			.append(' ');
		}
		return capitalized.toString();
	}
}
