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
import java.util.Scanner;

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

	private static String findIntersection(int[] list1, int[] list2) {
		StringBuilder intersection = new StringBuilder();

		for (int i = 0, j = 0; i < list1.length && j < list2.length; i++) {
			while (list1[i] > list2[j] && j < list2.length) {
				j++;
			}
			if (list1[i] < list2[j]) {
				continue;
			}
			if (list1[i] == list2[j]) {
				intersection.append(',').append(list2[j++]);
			}
		}
			
		if (intersection.length() == 0) {
			return "";
		}

		return intersection.toString().substring(1);
	}
	
	private static int[] toIntArray(String[] array) {
		int[] nums = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			nums[i] = Integer.parseInt(array[i]);
		}

		return nums;
	}
}
