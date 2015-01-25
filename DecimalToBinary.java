/* Author: Luigi Vincent
Challenge: Convert Decimal number to its binary representation.

Specifications: Your program should accept as its first argument a path to a filename.
Ignore all Empty Lines.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecimalToBinary {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while(fileInput.hasNextLine()) {
			printBinaryForm(fileInput.nextLine());
		}
	}

	private static void printBinaryForm(String line) {
		if (!line.isEmpty()) {
			System.out.println(
				Integer.toBinaryString(Integer.parseInt(line))
			);
		}
	}
}
