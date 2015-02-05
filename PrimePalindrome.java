/* Author: Luigi Vincent

Challenge:
Write a program which determines the largest prime palindrome less than 1000.

Found on CodeEval
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PrimePalindrome {
	public static void main(String[] args) {
		final int limit = 1000;

		System.out.println(
			calculateLargestPalindrome(getPrimesUnder(limit))
		);	
	}

	private static boolean isPalindromic(int s) {
        return s == reverse(s);
	}

	private static int reverse(int n) {
	    return Integer.parseInt(
	        new StringBuilder(Integer.toString(n)).reverse().toString()
	    );
	}

	/* Finding all prime numbers under an integer,
	using Sieve of Eratosthenes
 	http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */
	private static List<Integer> getPrimesUnder(int limit) {
	    int prime;
	    List<Integer> primes = new ArrayList<>();
	    List<Integer> numbers = new ArrayList<>();

	    for (int i = 2; i < limit; i++) {
	    	numbers.add(i);
	    }

	    while (!numbers.isEmpty()) {
	    	prime = numbers.get(0);
	    	primes.add(prime);
	    	for (int i = prime; i < limit; i += prime) {
	    		numbers.remove((Integer)(i));
	    	}
	    }
	    return primes;
	}

	private static int calculateLargestPalindrome(List list) {
		ListIterator li = list.listIterator(list.size());
		while (li.hasPrevious()) {
			if (isPalindromic((int)li.previous())) {
				return (int) li.next();
			}
		}

		return -1; // if none are found
	}
}
