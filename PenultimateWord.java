/* Author: Luigi Vincent
Challenge: Find and print the next to last word in a string.

Specifications:
Your program should accept as its first argument a path to a filename.
Each line has more than one word

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class PenultimateWord {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printPenultimate(input.nextLine());
		}
	}

	private static void printPenultimate(String line) {
		System.out.println(getPenultimate(line));
	}

	private static String getPenultimate(String line) {
		String[] sentence = line.split("\\s");
		return sentence[sentence.length - 2];
	}
}
