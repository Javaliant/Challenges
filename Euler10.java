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

	public static boolean isPrime(long n) {
    		if (n == 1) { return false; }
    		else if (n < 4) { return true; }
   		else if (n % 2 == 0 || n % 3 == 0) {
        		return false;
    		} else {
        		for (int i = 5; i * i <= n; i += 6) {
            			if (n % i == 0 || n % (i + 2) == 0) {
                			return false;
            			}
        		}
        		return true;
    		}
	}
}
