/* Author: Luigi Vincent

Challenge: Write a program which determines the Mth to last element in a list.

Specifications: 
The first argument is a path to a file.
The file contains the series of space delimited characters
followed by an integer.

The integer represents an index in the list (1-based), one per line.
Print to stdout the Mth element from the end of the list, one per line.

If the index is larger than the number of elements in the list,
ignore that input.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MToLast {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printMToLast(input.nextLine());
		}
	}

	private static void printMToLast(String line) {
		if (line.length() < 1) { return; }
		int targetIndex = Character.getNumericValue(line.charAt(line.length() - 1 ));
		String toCheck = line
			.substring(0, line.length() - 1)
			.replaceAll("\\s", "")
		;

		if (targetIndex <= toCheck.length()) {
			System.out.println(
				getMToLast(toCheck, targetIndex)
			);
		}
	}

	private static char getMToLast(String str, int index) {
		return str.charAt(str.length() - index);
	}
}
