/* Author: Luigi Vincent

Challenge: Swap positions in a list of numbers.

Specifications:
Your program should accept as its first argument a path to a filename.
The file contains several test cases, one on each line.
Each test case is a list of numbers, supplemented with positions to be swapped.
List and positions are separated by a colon.
Positions start with 0.
There may be more than one position swaps, separated by a comma.
Positions swaps are processed left to right.

Sample Input:
1 2 3 4 5 6 7 8 9 : 0-8
1 2 3 4 5 6 7 8 9 10 : 0-1, 1-3

Sample Output: 
9 2 3 4 5 6 7 8 1
2 4 3 1 5 6 7 8 9 10

Found on CodeEval

Alternative solution to SwapElements using primitives.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SwapTemp {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			String[] temp = input.nextLine().split(":");
			printSwapped(swapList(toIntArray(temp[0]), temp[1]));
		}
	}

	private static void printSwapped(int[] list) {
		StringBuilder result = new StringBuilder();

		for (int n : list) {
			result.append(' ').append(n);
		}

		System.out.println(result.substring(1));
	}

	private static int[] swapList(int[] result, String swapKey) {
		for (String s : swapKey.split(",")) {
			String[] keys = s.split("-");
			int index1 = Integer.parseInt(keys[0].substring(1));
			int index2 = Integer.parseInt(keys[1]);

			int target1 = result[index2];
			int target2 = result[index1];

			result[index1] = target1;
			result[index2] = target2;
		}

		return result;
	}

	private static int[] toIntArray(String input) {
		String[] temp = input.split("\\s+");
		int[] result = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
		}

		return result;
	}
}
