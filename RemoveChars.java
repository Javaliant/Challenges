/* Author: Luigi Vincent
Challenge: Remove specific Characters from a string.

Specifications: Your program should accept a file as its argument.
The file contains, line by line, the source strings
and the characters that need to be scrubbed, delimited by a comma.

Print the resulting strings, one per line.
Ensure no trailing empty spaces on each line printed.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveChars {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printResultString(fileInput.nextLine());
		}
	}

	private static void printResultString(String line) {
		System.out.println(
			removeChars(line.split(",")[0], line.split(", ")[1]).trim()
		);
	}

	private static String removeChars(String str, String chars) {
		return str.replaceAll("[," + chars + "]", "");
	}
}
