/* Author: Luigi Vincent

Challenge: Print out all pairs of numbers whose sum is equal to X.

Specifications:
Your program should accept as its first argument a filename.
This file will contain a comma separated list of sorted numbers,
and then the sum 'X', separated by semicolon.
Ignore all empty lines.
If no pair exists, print the string NULL

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class NumberPairs {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printPairs(input.nextLine());
		}
	}

	private static void printPairs(String line) {
		if (!line.isEmpty()) {
			String[] args = line.split(";");
			String[] helper = args[0].split(",");
			int checkingFor = Integer.parseInt(args[1]);
			int[] numbersToCheck = new int[helper.length];

			for (int i = 0; i < helper.length; i++) {
				numbersToCheck[i] = Integer.parseInt(helper[i]);
			}
		
			System.out.println(getPairs(numbersToCheck, checkingFor));
		}
	}

	private static String getPairs(int[] numArray, int goal) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < numArray.length; i++) {
			for (int j = i + 1; j < numArray.length; j++) {
				if (numArray[i] + numArray[j] == goal) {
					result
						.append(numArray[i])
						.append(',')
						.append(numArray[j])
						.append(';')
					;
				}
			}
		}

		if (result.length() == 0) {
			return "NULL";
		}

		result.setLength(result.length() - 1);
		return result.toString();
	}
}
