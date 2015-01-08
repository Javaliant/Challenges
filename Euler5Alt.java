/* Author: Luigi Vincent

2520 is the LCM of 1 through 10.
What is the LCM of 1 through 20?
*/

import java.util.ArrayList;

public class Euler5Alt {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		final long MAX_NUM = 20L;

		ArrayList<Long> numbers = new ArrayList<Long>() {
			{ for (long i = 1L; i <= MAX_NUM; i++) { add(i); } }
		};

		long result = numbers
			.stream().reduce(Euler5::lcm).get();

		System.out.print("Result: " + result +
				".\nTime used for calculation in nanoseconds: " +
				(System.nanoTime() - startTime) + ".");
	}

	/*Greatest Common Divisor
	Euclidean algorithm: http://en.wikipedia.org/wiki/Euclidean_algorithm */
	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b); 
	}
	// Least Common Multiple
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
}
