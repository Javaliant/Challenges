/* Author: Luigi Vincent

Challenge: Given 2 lists of positive integers.
Write a program which multiplies corresponding elements in these lists.

Specifications: 
The lists are separated with pipe char: '|' .
Numbers are separated with a space char. 
The number of elements in lists are in range [1, 10]. 
The number of elements is the same in both lists. 
Each element is a number in range [0, 99].
Your program should accept as its first argument a path to a filename.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyLists {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = (args.length > 0) ? 
			new Scanner(new File(args[0])) :
			new Scanner(System.in)
		;

		while (fileInput.hasNextLine()) {
			printMultipliedList(fileInput.nextLine());
		}
	}

	private static void printMultipliedList(String line) {
		String[] params = line.split("\\|");
		StringBuilder multiplied = new StringBuilder();


		for (int n : getMultipliedList(params[0].trim().split("\\s+"), params[1].trim().split("\\s"))) {
			multiplied.append(n).append(' ');
		}
		multiplied.setLength(multiplied.length() - 1);

		System.out.println(multiplied.toString());
	}

	private static List<Integer> getMultipliedList(String[] first, String[] second) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < first.length; i++) {
			result.add(
				Integer.parseInt(first[i]) * Integer.parseInt(second[i])
			);
		}
		return result;
	}
}
