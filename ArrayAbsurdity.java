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
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		StringBuilder line = new StringBuilder();

		while (input.hasNextLine()) {
			line.append(input.nextLine());

			if (line.length() > 0) {
				printDuplicate(line.toString().split(";")[1].split(","));
			}

			line.setLength(0);
		}
	}

	private static void printDuplicate(String[] nums) {
		boolean[] absurd = new boolean[nums.length];

		for (short i = 0, value; i < nums.length; i++) {
			value = Short.parseShort(nums[i]);

			if (absurd[value]) {
				System.out.println(value);
				break;
			}

			absurd[value] = true;
		}
	}
}
