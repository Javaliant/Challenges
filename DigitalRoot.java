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
		System.out.println(getDigitalRoot(942));
	}

	private static int getDigitalRoot(int num) {
		int result = 0;

		for (char c : Integer.toString(num).toCharArray()) {
			result += Character.getNumericValue(c);
		}
		if (Integer.toString(result).length() > 1) {
			getDigitalRoot(result);
		}

		return result;
	}
}
