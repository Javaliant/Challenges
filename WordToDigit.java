/* Author: Luigi Vincent
Challenge: Take a string representation of numbers and print the numbers.

Specifications: All numbers are separated by semicolon. There are up to 20 numbers in one line. The numbers are "zero" to "nine" Your program should accept as its first argument a path to a filename. Each line in this file is one test case. 

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordToDigit {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printNumbers(input.nextLine());
		}
	}

	private static void printNumbers(String line) {
		String[] nums = line.split(";");
		StringBuilder numbers = new StringBuilder();
		for (String s : nums) {
			numbers.append(getNumber(s));
		}
		System.out.println(numbers.toString());
	}
	
	private static int getNumber(String str) {
		int number = 0;
		switch(str) {
			case "zero":
				number = 0;
			break;
			case "one":
				number = 1;
			break;
			case "two":
				number = 2;
			break;
			case "three":
				number = 3;
			break;
			case "four":
				number = 4;
			break;
			case "five":
				number = 5;
			break;
			case "six":
				number = 6;
			break;
			case "seven":
				number = 7;
			break;
			case "eight":
				number = 8;
			break;
			case "nine":
				number = 9;
			break;
		}
		return number;
	}
}
