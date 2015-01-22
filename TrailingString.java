/* Author: Luigi Vincent
Challenge: There are two strings: A and B. 
Print 1 if string B occurs at the end of string A
Otherwise, print 0.

Specifications: The first argument is a path to the input filename
containing two comma-delimited strings, one per line.
Ignore all empty lines in the input file.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrailingString {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printTrailingString(fileInput.nextLine());
		}	
	}

	private static void printTrailingString(String line) {
		String[] arguments = line.split(",");
		System.out.println(checkTrailingString(arguments[0], arguments[1]));
	}

	private static int checkTrailingString(String str, String trailing) {
		return str.substring(str.length() - trailing.length())
			.equals(trailing) ? 1 : 0;
	}
}
