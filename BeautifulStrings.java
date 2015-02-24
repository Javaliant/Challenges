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
			System.out.println(computeMaxBeauty(input.nextLine()));
		}
	}

	private static int beautyMax(String sentence) {
	    int[] counts = new int[26];
	    IntStream.range(0, sentence.length())
	        .map(i -> (int)sentence.charAt(i))
	        .map(c -> (c >= 'a' && c <= 'z')
	                ? (c - 'a') 
	                : ((c >= 'A' && c <= 'Z') ? (c - 'A') : -1 ))
	        .filter(i -> i >= 0)
	        .forEach(i -> counts[i]++);
	    Arrays.sort(counts);
	    return IntStream.range(0, 26).map(i -> counts[i] * (i + 1)).sum();
	}
}
