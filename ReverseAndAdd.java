/* Author: Luigi Vincent

Challenge: Reverse the digits of a number and add it to the original
until the number is a palindrome.

Specifications:
Your program should accept as its first argument a path to a filename.
Each line in this file is one test case.
Each test case will contain an integer n < 10,000.

Assume each test case will always have an answer and
that it is computable with less than 100 iterations.

For each line of input, print a line of output
containing the number of iterations to compute the palindrome 
and the resulting palindrome, on one line separated by a single space.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseAndAdd {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			findAndPrintPalindrome(input.nextLine());
		}
	}

	private static void findAndPrintPalindrome(String line){
		System.out.println(getPalindrome(line));
	}

	private static String getPalindrome(String line) {
		int reverseCount = 0,
			currentNum = Integer.parseInt(line)
		;

		while (!isPalindromic(currentNum)) {
			currentNum += reverse(currentNum);
			reverseCount++;
		}

		return reverseCount + " " + currentNum;
	}

	private static boolean isPalindromic(int s) {
		return s == reverse(s);
	}

	private static int reverse(int n) {
		return Integer.parseInt(
			new StringBuilder(Integer.toString(n)).reverse().toString()
		);
	}
}
