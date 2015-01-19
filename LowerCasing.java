/* Author: Luigi Vincent

Challenge: Given a string write a program to convert it into lowercase.

Specifications: The first argument will be a path to a filename containing sentences, one per line. 
You can assume all characters are from the english language.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LowerCasing {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);

		while (in.hasNextLine()) {
			System.out.println(in.nextLine().toLowerCase());
		}
	}
}
