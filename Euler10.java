/* Author: Luigi Vincent

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
*/

import java.util.ArrayList;

public class Euler10 {
	public static void main(String[] args) {
		final long START = System.nanoTime();
		long result = 0;

		ArrayList<Integer> nums = new ArrayList<>();

		for (int i = 1; i <= 2000000; i++) {
			if (isPrime(i)) {
				nums.add(i);
			}
		}
		
		for (int n : nums) {
			result += n;
		}
		
		final long END = System.nanoTime();

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(END - START) + "."
		);
    }

    public static boolean isPrime(int num) {
    	if (num <= 3) { return num > 1; }
    	if ((num & 1) == 0 || num % 3 == 0) { return false; }

    	int limit = (int) Math.sqrt(num);

    	for (int i = 5; i <= limit; i += 6) {
      		if (num % i == 0 || num % (i + 2) == 0) { return false; }
    	}
    	return true;
  }
}
