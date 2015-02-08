/* Author: Luigi Vincent

Challenge: Write a program which reverses the words in an input sentence.

Specifications:
The first argument is a file that contains multiple sentences, one per line. Empty lines are also possible.
Print each sentence with the reversed words in it, one per line.
Empty lines in the input should be ignored.
Ensure that there are no trailing empty spaces in each line you print.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseWords {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		StringBuilder line = new StringBuilder();

		while (input.hasNextLine()) {
			line.append(input.nextLine());

			if (line.length() > 0) {
				printReversedWords(line.toString().split("\\s+"));
			}

			line.setLength(0);
		}
	}

	private static void printReversedWords(String[] words) {
		StringBuilder reversed = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) {
			reversed.append(words[i].trim()).append(' ');
		}

		System.out.println(reversed.toString().trim());
	}
}
