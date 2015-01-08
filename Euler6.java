/* Author: Luigi Vincent

The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares
of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between
the sum of the squares of the first one hundred natural numbers
and the square of the sum.
*/

public class Euler6 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int result = sumSquareDifference(100);

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(System.nanoTime() - startTime) + ".");
	}

	public static int sumSquareDifference(int n) {
		int sumSquare = 0,
			sum = 0,
			squaredSum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;
			sumSquare += i * i;
		}
		
		squaredSum = sum * sum;
		return squaredSum - sumSquare;
	}
}
