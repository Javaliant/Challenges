/* Author: Luigi Vincent

Challenge: 
Write a program which determines the number of 1 bits in
the internal representation of a given integer.

Specifications: 
The first argument is a path to a file.
The file contains integers, one per line.
Print to stdout the number of ones in the binary form of each number.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryOnes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			System.out.println(
				Integer.bitCount(Integer.parseInt(input.nextLine()))
			);
		}
	}
}
