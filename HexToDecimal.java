/* Author: Luigi Vincent

Challenge: Convert a hexadecimal(base 16) number into a decimal(base 10) number.

Specifications: You may assume that the hex number does not have a leading 'Ox'.
Your program should accept as its first argument a path to a filename.
All alpha characters (a through f) in the input will be in lowercase.

Found on CodeEval.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HexToDecimal {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);

		while(in.hasNextLine()) {
			System.out.println(Integer.parseInt(in.nextLine(), 16));
		}
	}
}
