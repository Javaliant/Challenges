/* Author: Luigi Vincent
Challenge: Sum integers from a file.
Specifications: The first argument to the program will be a path to a filename
containing a positive integer, one per line. Print the sum of all integers.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumIntegers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));
		int sum = 0;
		
		while (fileInput.hasNextLine()) {
			sum += Integer.parseInt(fileInput.nextLine());
		}
		System.out.println(sum);
	}
}
