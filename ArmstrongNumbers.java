/* Author: Luigi Vincent

Challenge: Determine if a number is an armstrong number.

Specifications:
An Armstrong number is an n-digit number that is equal to the sum
of the n'th powers of its digits. 
Your program should accept as its first argument a path to a filename.
Each line in this file has a positive integer

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArmstrongNumbers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printIsArmStrongNum(input.nextLine());
		}
	}

	private static void printIsArmStrongNum(String line) {
		System.out.println(
			isArmStrongNum(Integer.parseInt(line), line.length())
		);
	}

	private static boolean isArmStrongNum(int n, int power) {
		int armstrong = n;
		int armstrongNum = 0;

		while (armstrong != 0) {
	       armstrongNum += Math.pow(armstrong % 10, power);
	       armstrong /= 10;
    	}

    	return armstrongNum == n;
	}
}
