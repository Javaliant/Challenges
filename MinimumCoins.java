/* Author: Luigi Vincent

Challenge: Find the minimum number of coins to arrive at a number.

Specifications:
Given coins 5, 3 and 1 find the minimum number of coins to arrive at a number.
Your program should accept as its first argument a path to a filename.
This file contains the number total you are to arrive at

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinimumCoins {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printMinimumCoins(input.nextLine());
		}
	}

	private static void printMinimumCoins(String line) {
		System.out.println(computeMinimumCoins(Integer.parseInt(line)));
	}

	private static int computeMinimumCoins(int n) {
		int count = 0;

		while (n != 0) {
			if (n >= 5) { n -= 5; count++; }
			else if (n >= 3) { n -= 3; count++; }
			else { n -= 1; count++; }
		}

		return count;
	}
}
