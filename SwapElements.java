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
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwapElements {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			String[] temp = input.nextLine().split(":");
			printSwapped(swapList(temp[0], temp[1]));
		}
	}

	public static void printSwapped(List<String> list) {
		StringBuilder result = new StringBuilder();

		for (String s : list) {
			result.append(' ').append(s);
		}

		System.out.println(result.substring(1));
	}

	public static List<String> swapList(String input, String swapKey) {
		List<String> result = modifyToList(input);

		for (String s : swapKey.split(",")) {
			String[] keys = s.split("-");
			int index1 = Integer.parseInt(keys[0].substring(1));
			int index2 = Integer.parseInt(keys[1]);

			String target1 = result.get(index2);
			String target2 = result.get(index1);

			result.set(index1, target1);
			result.set(index2, target2);
		}

		return result;
	}

	public static List<String> modifyToList(String list) {
		List<String> result = new ArrayList<>(list.length());

		for (String s : list.split("\\s+")) {
			result.add(s);
		}

		return result;
	}	
}
