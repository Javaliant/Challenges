/* Author: Luigi Vincent
Challenge: Print out the prime numbers less than a given number N.

Specifications: 
Your program should accept as its first argument a path to a filename.
Each line in this file is one test case.
For each test case,
print out the prime numbers less than N, in ascending order, comma delimited.
There should not be any spaces between the comma and numbers.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintingPrimes {
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner input = new Scanner(new File(args[0]));
    	
    	while (input.hasNext()) {
    		printPrimesUnder(input.nextLine());
    	}
    }

    private static void printPrimesUnder(String line) {
        StringBuilder sb = new StringBuilder();

        for (int n : computePrimesUnder(Integer.parseInt(line))) {
            sb.append(n).append(',');
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static List<Integer> computePrimesUnder(int limit) {
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
}
