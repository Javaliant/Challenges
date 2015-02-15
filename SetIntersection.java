/* Author: Luigi Vincent

Challenge: Print list intersections.

Specifications:
Given two sorted list of numbers (ascending order).
Both comma delimited and the two lists are semicolon delimited.
Print out the intersection of these two sets.

Print out the ascending order sorted intersection of the lists, one per line.
Print empty new line in case the lists have no intersection

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetIntersection {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		String[] parts;

		while (input.hasNextLine()) {
			parts = input.nextLine().split(";");

			System.out.println(
				findIntersection(
					toIntArray(parts[0].split(",")),
					toIntArray(parts[1].split(","))
				)
			);
		}
	}

	private static String findIntersection(int[] foo, int[] bar) {
		Set<Integer> intersection = new LinkedHashSet<>();

		for (int i = 0, j = 0; i < foo.length && j < bar.length; i++) {
			if (foo[i] < bar[j]) {
				continue;
			} else if (foo[i] > bar[j]) {
				j++;
			} else {
				intersection.add(bar[j++]);
			}
		}

		if (intersection.isEmpty()) {
			return ""; // none found
		}

		String result = intersection.toString();
		return result.substring(1, result.length() - 1);
	}
	
	private static int[] toIntArray(String[] array) {
		int[] nums = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			nums[i] = Integer.parseInt(array[i]);
		}

		return nums;
	}
}
