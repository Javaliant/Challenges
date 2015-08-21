/* Author: Luigi Vincent

Challenge: Print sentences vertically.

*/


public class VerticalSentences {
	public static void main(String[] args) {
		String[] target = {
			"How To Format",
			"put returns between paragraphs",
			"for linebreak add 2 spaces at end"
		};

		printSentenceVertically(target);
	}

	public static int wordCount(String input) {
		return input.trim().split("\\s+").length;
	}

	public static int longestWordCount(String[] input) {
		int result = 0;

		for (String s : input) {
			if (result < wordCount(s)) {
				result = wordCount(s);
			}
		}

		return result;
	}

	public static void printSentenceVertically(String[] input) {
		int longestWordCount = longestWordCount(input);
		int spacesBetweenColumns = 7;
		String formatSpecifier = "%-" + (longestWordCount + spacesBetweenColumns) + "s";
		String[][] words = convertToWordArray(input);

		for (int i = 0; i < longestWordCount; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i < words[j].length) {
					System.out.printf(formatSpecifier, words[j][i]);
				} else {
					System.out.printf(formatSpecifier, "");
				}
			}
			System.out.println();
		}
	}

	public static String[][] convertToWordArray(String[] input) {
		String[][] result = new String[input.length][];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = input[i].trim().split("\\s+");
		}

		return result;
	}
}
