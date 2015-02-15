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
				findIntersection(parts[0].split(","), parts[1].split(","))
			);
		}
	}

	private static String findIntersection(String[] arr1, String[] arr2) {
	    StringBuilder result = new StringBuilder();
	    int val1 = Integer.parseInt(arr1[0]);
	    int val2 = Integer.parseInt(arr2[0]);

	    for (int i = 0, j = 0; ; ) {
	        if (val1 == val2) {
	            result.append(',').append(val1);

	            if (++i < arr1.length) {
	            	val1 = Integer.parseInt(arr1[i]);
	            } else {
	            	break;
	            }

	            if (++j < arr2.length) {
	            	val2 = Integer.parseInt(arr2[j]);
	            } else {
	            	break;
	            }
	        } else if (val1 < val2) {
	        	if (++i < arr1.length) {
	            	val1 = Integer.parseInt(arr1[i]);
	            } else {
	            	break;
	            }
	        } else {
	            if (++j < arr2.length) {
	            	val2 = Integer.parseInt(arr2[j]);
	            } else {
	            	break;
	            }
	        }
    	}

	    return result.length() == 0 ? "" : result.substring(1);
	} 
}
