/* Author: Luigi Vincent
Challenge: Write a program with separates words from digits.

Specifications:
Your program should accept as its first argument a path to a filename.
The file contains strings of words and digits divided by comma.
Without changing the order of elements, separate with a '|' character,
putting words first and numbers afterwards.

e.g.
apple,12,bananas,15 yields apple,bananas|12,15

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StratifyString {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printStratifiedString(input.nextLine());
		}
	}

	private static void printStratifiedString(String line) {
		System.out.println(getStratifiedString(line));
	}

	private static String getStratifiedString(String line) {
		String[] args = line.split(",");
		StringBuilder result = new StringBuilder(),
					  helper = new StringBuilder()
		;

		for (String s : args) {
			if (!isNumeric(s)) {
				result.append(s).append(',');
			} else {
				helper.append(s).append(',');
			}
		}

		if (helper.length() > 0) {
			if (result.length() > 0) {
				result.setLength(result.length() - 1);
				result.append('|');
			}
			result.append(helper);
		}

		result.setLength(result.length() - 1);
		return result.toString();
	}

	private static boolean isNumeric(String s){
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
}
