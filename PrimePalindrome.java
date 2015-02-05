/* Author: Luigi Vincent

Challenge:
Write a program which determines the largest prime palindrome less than 1000.

Found on CodeEval
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class PrimePalindrome {
	public static void main(String[] args) {
		final int LIMIT = 1000;

		System.out.println(computeLargestPrimePalindrome(LIMIT));	
	}

	private static boolean isPalindromic(int s) {
        return s == reverse(s);
	}

	private static int reverse(int p) {
    	int reverse = 0;

    	while (p != 0) {
	        reverse *= 10;
	        reverse += (p % 10);
	        p /= 10;
    	}

	    return reverse;
	}

	/* Finding all prime numbers under an integer,
	using Sieve of Eratosthenes
 	http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */
	private static List<Integer> getPrimesWithin(int limit) {
		boolean[] sieve = new boolean[limit];
		Arrays.fill(sieve, true);
		List<Integer> primes = new ArrayList<>();

		for (int prime = 2; prime < sieve.length; prime++) {
    		if (sieve[prime]) {
    			primes.add(prime);
        		for (int np = prime * 2; np < sieve.length; np += prime) {
            		sieve[np] = false;
        		}
        	}
    	}

	    return primes;
	}

	private static int computeLargestPrimePalindrome(int limit) {
		List<Integer> primes = getPrimesWithin(limit);
		ListIterator li = primes.listIterator(primes.size());

		while (li.hasPrevious()) {
			if (isPalindromic((int) li.previous())) {
				return (int) li.next();
			}
		}

		return -1; // if none are found
	}
}
