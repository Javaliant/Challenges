/* Author: Luigi Vincent

2520 is the LCM of 1 through 10.
What is the LCM of 1 through 20?
*/

import java.util.ArrayList;
import java.util.stream.LongStream;

public class Euler5 {
	public static void main(String[] args) {
		final long START = System.nanoTime();
		final long MAX_NUM = 20L;

		long result = LongStream.rangeClosed(1, MAX_NUM)
			.reduce(Euler5::lcm).getAsLong();
        	
        	final long END = System.nanoTime();

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(END - START) + "."
		);
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
