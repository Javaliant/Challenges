/* Author: Luigi Vincent

Challenge: Create an algorithm which prints out number
on the N-th position in the sequence 011212201220200112...

Specifications: The sequence is constructed as follows:
first is 0, 
then repeated the following action: 
already written part is attributed to the right with replacement
0 to 1,
1 to 2,
2 to 0.

Your program should accept as its first argument a path to a filename.
Each line in this file contains an integer N such that: 0 <= N <= 3000000000

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SequencePosition {
	static String sequence = "011212201220200112";

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printNumberInPosition(fileInput.nextLine());
		}
	}

	private static void printNumberInPosition(String line) {
		int position = Integer.parseInt(line);
		System.out.println(getNumberInPosition(position));
	}

	private static int getNumberInPosition(int position) {
		StringBuilder sequenceBuilder = new StringBuilder(sequence);

		while (sequenceBuilder.length() < position) {
			sequenceBuilder.append(
				sequence.replace('0', '1')
						.replace('1', '2')
						.replace('2', '0')
			);
		}

		sequence = sequenceBuilder.toString();
		return Character.getNumericValue(sequence.charAt(position));
	}
}
