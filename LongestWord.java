/* Author: Luigi Vincent
Challenge: Print the longest word in a sentence.
Specifications: Program should accept a file as its input.
Each line has one or more words, each word separated by a space.
If the sentence has more than one word of the same length,
print the first one.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWord {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));
		
		while (fileInput.hasNextLine()) {
			printLongest(fileInput.nextLine());
		}	
	}

	private static void printLongest(String file) {
		System.out.println(getLongest(file));
	}
	// Finds and returns the longest word in a string
	private static String getLongest(String str) {
		String[] words = str.split(" ");
		int longestPosition = 0, longestLength = words[0].length();

		for (int i = 1; i < words.length; i++) {
			if (words[i].length() > longestLength) {
				longestLength = words[i].length();
				longestPosition = i;
			}
		}
		return words[longestPosition];
	}
}
