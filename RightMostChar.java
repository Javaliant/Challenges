/* Author: Luigi Vincent

Challenge: Print out the rightmost position of a given character from a string.

Specifications.
You are given a string 'S' and a character 't'.
Print out the position of the rightmost occurrence of 't' (case matters) in 'S'
or -1 if there is none.
The position to be printed out is zero based.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RightMostChar {
	public static void main(String[] arguement) throws FileNotFoundException {
		Scanner input = new Scanner(new File(arguement[0]));
		String[] args;

		while (input.hasNextLine()) {
			args = input.nextLine().split(",");

			System.out.println(args[0].lastIndexOf(args[1]));
		}
	}
}
