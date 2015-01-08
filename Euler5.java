/* Author: Luigi Vincent

2520 is the smallest number divisible by 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by 1-20?
*/

public class Euler5 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// Multiplying by primes for a starting point * 2 for evenness
		int givenTimesPrimes = 2520 * 2 * 11 * 13 * 17 * 19,
			result = givenTimesPrimes;

		while (!isSmallestMultiple(result)) {
			result += givenTimesPrimes;
		}

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(System.nanoTime() - startTime) + ".");
	}

	public static boolean isSmallestMultiple(int n) {
		for (int i = 11; i <= 20; i++) {
			if (n % i != 0) {
				return false;
			}
		}
		return true;
	}
}
