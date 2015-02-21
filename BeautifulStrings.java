/* Author: Luigi Vincent

Challenge: Print the maximum beauty of strings.

Specifications:
The beauty of a string is the sum of the beauty of the letters within.
The beauty of each letter is an integer between 1 and 26, inclusive.
No two letters have the same beauty.
Lettercase is irrelevant.
Your program should accept as its first argument a path to a filename.
Each line in this file has a sentence.
Print out the maximum beauty of each sentence.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BeautifulStrings {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printMaxBeauty(input.nextLine());
		}
	}

	private static void printMaxBeauty(String line) {
		System.out.println(computeMaxBeauty(line));
	}

	private static int computeMaxBeauty(String text) {
	    String sanitized = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
	    
	    int[] counts = new int[26];
	    for (int i = 0; i < sanitized.length(); i++) {
	        counts[sanitized.charAt(i) - 'a']++;
	    }

	    Arrays.sort(counts);

	    int beauty = 0;
	    for (int i = 25; i >= 0 && counts[i] > 0; i--) {
	        beauty += counts[i] * (i + 1);
	    }

	    return beauty;
	}
}
