/* Author: Luigi Vincent

Challenge: Calculate N Mod M without using any inbuilt modulus operator.

Specifications: 
You may assume M will never be zero.
Your program should accept as its first argument a path to a filename.
Each line in this file contains two comma separated positive integers.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Modulus {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printModulus(input.nextLine());
		}
	}

	private static void printModulus(String line) {
		String[] operands = line.split(",");

		System.out.println(getModulus(operands[0], operands[1]));
	}

	private static int getModulus(String str1, String str2) {
		int dividend = Integer.parseInt(str1),
			divisor = Integer.parseInt(str2),
			quotient = dividend / divisor
		;

		return dividend - quotient * divisor;
	}
}
