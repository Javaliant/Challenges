/* Author: Luigi Vincent
Challenge: Given two integers N and M, count the number of prime numbers between N and M (both inclusive)

Found on CodeEval
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CountingPrimes {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printPrimeCount(fileInput.nextLine());
		}
	}

	private static void printPrimeCount(String line) {
		int n = Integer.parseInt(line.split(",")[0]);
		int m = Integer.parseInt(line.split(",")[1]);

		System.out.println(countPrimesWithin(n, m));
	}

	private static int countPrimesWithin(int first, int limit) {
	    int primeCount = 0;

	    for (int i = first; i <= limit; i++) {
	    	if (isPrime(i)) { primeCount++; }
	    }
	    
	    return primeCount;
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
