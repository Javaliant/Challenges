/* Author: Luigi Vincent

Challenge: Write a program that swap the letter case in a sentence.

Specifications: Accept a path to a file as the first argument of the program.

Input Example: 
Hello world!
JavaScript language 1.8
A letter

Output Example:
hELLO WORLD!
jAVAsCRIPT LANGUAGE 1.8
a LETTER

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SwapCases {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while(fileInput.hasNextLine()) {
			printswappedCase(fileInput.nextLine());
		}
	}

	private static void printswappedCase(String line) {
		System.out.println(swapCase(line));
	}

	private static String swapCase(String line) {
		StringBuilder swapped = new StringBuilder();

		for (char c : line.toCharArray()) {
			swapped.append(
				Character.isLowerCase(c) ? 
				Character.toUpperCase(c) : 
				Character.toLowerCase(c)
			);
		}
		return swapped.toString();
	}
}
