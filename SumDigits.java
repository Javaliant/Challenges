/* Author: Luigi Vincent
Challenge: Sum digits.

Specifications: Given a positive integer, find the sum of its constituent digits
Your program should accept a file as its argument.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumDigits {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while (fileInput.hasNextLine()) {
			printSum(fileInput.nextLine());
		}
	}

	private static void printSum(String line) {
		int sum = 0;
		for (Character c : line.toCharArray()) {
			sum += Character.getNumericValue(c);
		}
		System.out.println(sum);
	}
}
