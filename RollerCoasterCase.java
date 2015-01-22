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

public class RollerCoasterCase {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while(fileInput.hasNextLine()) {
			printRollerCoasterCase(fileInput.nextLine());
		}
	}

	private static void printRollerCoasterCase(String line) {
		System.out.println(rollercoasterfy(line));
	}

	private static String rollercoasterfy(String line) {
		StringBuilder rollercoaster = new StringBuilder();
		int coaster = 2;

		for (char c : line.toCharArray()) {
			if (Character.isLetter(c)) {
				rollercoaster.append(
					(coaster++ & 1) == 0 ? 
					Character.toUpperCase(c) : 
					Character.toLowerCase(c)
				);
			} else {
				rollercoaster.append(c);
			}
		}
		return rollercoaster.toString();
	}
}
