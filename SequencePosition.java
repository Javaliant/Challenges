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
	static String sequence = "0";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while (fileInput.hasNextLine()) {
			printNumberInPosition(fileInput.nextLine());
		}
	}

	private static void printNumberInPosition(String line) {
		System.out.println(getNumberInPosition(Integer.parseInt(line)));
	}

	private static int getNumberInPosition(int position) {
		StringBuilder sequenceBuilder = new StringBuilder(sequence);
		StringBuilder newSequence = new StringBuilder();

		while (sequenceBuilder.length() < position) {
			for (char c : sequenceBuilder.toString().toCharArray()) {
				switch(c) {
					case '0':
						newSequence.append('1');
					break;
					case '1':
						newSequence.append('2');
					break;
					case '2':
						newSequence.append('0');
					break;
				}
			}
			sequenceBuilder.append(newSequence.toString());
			newSequence.setLength(0);
		}   

		sequence = sequenceBuilder.toString();
		return Character.getNumericValue(sequence.charAt(position));
	}
}
