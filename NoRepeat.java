/* Author: Luigi Vincent

Challenge: Write a program which finds the first non-repeated character in a string.

Specifications:
The first argument is a path to a file.
The file contains strings, one per line.
Print out the first non-repeated character of each string.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NoRepeat {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			System.out.println(
				retrieveFirstNonRepeatedLetter(input.nextLine())
			);
		}
	}

	private static char retrieveFirstNonRepeatedLetter(String input) {
		Map<Character, Boolean> letters = new LinkedHashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			letters.put(current, !letters.containsKey(current));
		}
		
		for (Map.Entry<Character, Boolean> entry : letters.entrySet()) {
			if (entry.getValue()) {
				return entry.getKey();
			}
		}
		
		throw new NoSuchElementException("No unique characters found");
	}
}
