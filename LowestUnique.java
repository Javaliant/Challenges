/* Author: Luigi Vincent
Challenge: Find the lowest unique number in a series.

Specifications: A game where each player picks a number from 1 to 9,
writes it on a paper and gives to a guide. 
A player wins if his number is the lowest unique.
Your program should accept as its first argument a path to a filename.
Print a winner's position or 0 in case there is no winner.

Found on CodeEval.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LowestUnique {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printLowestIndex(fileInput.nextLine());
		}	
	}

	private static void printLowestIndex(String file) {
		List<Integer> numbers = new ArrayList<>();

		for (char c : file.trim().toCharArray()) {
			if (c != ' ') { numbers.add(Character.getNumericValue(c)); }
		}

		List<Integer> filtered = getUniques(numbers);
		Collections.sort(filtered);

		System.out.println(filtered.isEmpty() ? 0 :
			(numbers.indexOf(filtered.get(0)) + 1)
		);
	}
	// Count the number of appearances of an item in a list
	private static <T> int appearanceCount(List<T> list, T item) {
	    int count = 0;

	    for (T t : list) {
	        if (t.equals(item)) {
	            count++;
	        }
	    }
	    return count;
	}
	// Filters out non-unique members of a list
	private static <T> List<T> getUniques(List<T> list) {
	    List<T> result = new ArrayList<>();

	    for (T t : list) {
	        if (appearanceCount(list, t) == 1) {
	            result.add(t);
	        }
	    }
	    return result;
	}
}
