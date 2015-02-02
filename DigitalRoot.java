/* Author: Luigi Vincent
Challenge: Create a digital Root Function.

Specifications:
A digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n.
If the resulting value has two digits,
continue reducing until a single-digit number is produced.
This is only applicable to the natural numbers.

Found on Codewars
*/

public class DigitalRoot {
	public static void main(String[] args) {
		System.out.println(computeDigitalRoot(942)); // should be 6
		System.out.println(computeDigitalRoot(16); // should be 7
	}

	public static int computeDigitalRoot(int n) {
		return n == 0 ? 0 : n % 9 == 0 ? 9 : n % 9;
	}
}
