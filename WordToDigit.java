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
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printNumbers(fileInput.nextLine());
		}
	}

	private static void printNumbers(String line) {
		String[] nums = line.split(";");
		StringBuilder numbers = new StringBuilder();
		for (String s : nums) {
			numbers.add(getNumber(s));
		}
		System.out.println(numbers.toString());
	}
	
	private static int getNumber(String str) {
		switch(str) {
			case "zero":
				return 0;
			case "one":
				return 1;
			case "two":
				return 2;
			case "three":
				return 3;
			case "four":
				return 4;
			case "five":
				return 5;
			case "six":
				return 6;
			case "seven":
				return 7;
			case "eight":
				return 8;
			case "nine":
				return 9;
		}
	}
}
