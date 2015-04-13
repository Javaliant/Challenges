/* Author: Luigi Vincent
Challenge: Determine whether two bits in different positions are the same. 

Specifications:
Given a number n and two integers p1, p2 determine if the bits in position p1 and p2 are the same or not.
Positions p1 and p2 are 1 based.
The first argument will be a path to a filename containing a comma separated list of 3 integers, one list per line.
Print 'true'(lowercase) if the bits are the same and  'false'(lowercase) otherwise.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BitPositions {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			System.out.println(isBitMatch(input.nextLine().split(",")));
		}
	}

	public static boolean isBitMatch(String[] input) {
		String binary = Integer.toBinaryString(Integer.parseInt(input[0]));
		int len = binary.length();
		int pos1 = len - Integer.parseInt(input[1]);
		int pos2 = len - Integer.parseInt(input[2]);

		return binary.charAt(pos1) == binary.charAt(pos2);
	} 
}
