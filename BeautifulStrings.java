/* Author: Luigi Vincent

Challenge:

Specifications:

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BeautifulStrings {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			printMaximumBeauty(input.nextLine());
		}
	}

	private static void printMaximumBeauty(String line) {
		System.out.println(
			findMaximumBeauty(line
				.replaceAll("[^a-zA-Z]", "")
				.toLowerCase()
				.toCharArray()
			)
		);
	}

	private static int findMaximumBeauty(char[] line) {
		int beauty = 0;
		int beautyVal = 26;
		int count = 0;
		Set<Character> uniqueCharacters = new HashSet<>();
		List<Integer> appearanceCounts = new ArrayList<>();

		for (char c : line) {
			uniqueCharacters.add(c);
		}

		for (char u : uniqueCharacters) {
			for (char c : line) {
				if (u == c) {
					count++;
				}
			}

			appearanceCounts.add(count);
			count = 0;
		}

		Collections.sort(appearanceCounts, Collections.reverseOrder());

		for (int i : appearanceCounts) {
			beauty += i * beautyVal--;
		}

		return beauty;
	}
}
