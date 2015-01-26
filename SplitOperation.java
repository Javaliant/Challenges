/* Author: Luigi Vincent

Challenge: You are given a number N and a pattern.
The pattern consists of lowercase latin letters and one operation "+" or "-".
The challenge is to split the number and evaluate it according to this pattern
e.g.  1232 ab+cd -> a:1, b:2, c:3, d:2 -> 12+32 -> 44

Specifications: 
Your program should accept as its first argument a path to a filename.
Each line of the file is a test case,
containing the number and the pattern separated by a single whitespace.
N is in range [100, 1000000000]

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SplitOperation {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printOutput(input.nextLine());
		}	
	}

	private static void printOutput(String line) {
		String[] operation = line.split("\\s");
		System.out.println(getOutput(operation[0], operation[1]));
	}

	private static int getOutput(String number, String pattern) {
		String[] format = pattern.split("\\W");
		int operatorIndex = format[0].length(),
			firstOperand = Integer.parseInt(number.substring(0, operatorIndex)),
			secondOperand = Integer.parseInt(number.substring(operatorIndex))
		;
		return pattern.charAt(operatorIndex) == '+' ?
			firstOperand + secondOperand :
			firstOperand - secondOperand
		;
	}
}
