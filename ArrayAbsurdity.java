/* Author: Luigi Vincent

Challenge: Find the duplicated entry.

Specifications:
Your program should accept as its first argument a path to a filename.
Each line in this file is one test case.
Ignore all empty lines.

Each line begins with a positive integer(N), the size of the array,
then a semicolon followed by a comma separated list of positive numbers
which range from 0 to N-2, inclusive.

The array contains exactly one duplicated entry.
That duplicate appears exactly twice.
Print out the duplicated entry, each one on a new line.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayAbsurdity {
	public static void main(String[] argument) throws FileNotFoundException {
		Scanner input = new Scanner(new File(argument[0]));
		StringBuilder line = new StringBuilder();
		String[] args;

		while (input.hasNextLine()) {
			line.append(input.nextLine());

			if (line.length() > 0) {
				args = line.toString().split(";");
				printDuplicate(args[0], args[1].split(","));
			}
			
			line.setLength(0);
		}
	}

	private static void printDuplicate(String size, String[] nums) {
		boolean[] absurd = new boolean[Integer.parseInt(size)];

		for (int i = 0, value; i < absurd.length; i++) {
			value = Integer.parseInt(nums[i]);

			if (absurd[value]) {
				System.out.println(value);
				break;
			}

			absurd[value] = true;
		}
	}
}
