/* Author: Luigi Vincent

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
*/

import java.util.ArrayList;
import java.util.List;

public class Euler10 {
	public static void main(String[] args) {
		final long START = System.nanoTime();
		final int limit = 2000000;
		long result = 0;
		
		List<Integer> primes = new ArrayList<>();

		for (int i = 1; i < limit; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		
		for (int n : primes) {
			result += n;
		}
		
		final long END = System.nanoTime();

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(END - START) + "."
		);
    }

    public static boolean isPrime(int num) {
    	if (num <= 3) {
    		return num > 1;
    		
    	}
    	if ((num & 1) == 0 || num % 3 == 0) {
    		return false;
    		
    	}

    	int limit = (int) Math.sqrt(num);

    	for (int i = 5; i <= limit; i += 6) {
      		if (num % i == 0 || num % (i + 2) == 0) {
      			return false;
      			
      		}
    	}
    	
    	return true;
  }
}
	
