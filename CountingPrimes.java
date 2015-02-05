/* Author: Luigi Vincent
Challenge: Given two integers N and M,
print the number of primes between N and M (both inclusive)

Specifications:
Your program should accept as its first argument a path to a filename.
Each line in this file contains two comma separated positive integers

Found on CodeEval
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CountingPrimes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while (fileInput.hasNextLine()) {
			printPrimeCount(fileInput.nextLine());
		}
	}

	private static void printPrimeCount(String line) {
		String[] args = line.split(",");

		System.out.println(
			countPrimesWithin(
				Integer.parseInt(args[0]), Integer.parseInt(args[1])
			)
		);
	}

	private static int countPrimesWithin(int lowLim, int limit) {
		int count = 0;
		boolean[] sieve = new boolean[limit + 1];
		Arrays.fill(sieve, true);

		for (int prime = 2; prime < sieve.length; prime++) {
    		if (sieve[prime]) {
    			if (prime >= lowLim) {
    				count++;
    			}

        		for (int np = prime * 2; np < sieve.length; np += prime) {
            		sieve[np] = false;
        		}
        	}
    	}

		return count;
	}
}
