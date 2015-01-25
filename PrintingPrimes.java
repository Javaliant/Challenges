/* Author: Luigi Vincent
Challenge: Print out the prime numbers less than a given number N.
Your program should accept as its first argument a path to a filename.
Each line in this file is one test case. Each test case will contain an integer.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingPrimes {
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner fileScanner = new Scanner(new File(args[0]));
    	
    	while (fileScanner.hasNext()) {
    		printPrimesUnder(fileScanner.nextLine());
    	}
    }

    private static void printPrimesUnder(String line) {
        StringBuilder sb = new StringBuilder();

        for (int n : getPrimesUnder(Integer.parseInt(line))) {
            sb.append(n).append(',');
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static List<Integer> getPrimesUnder(int limit) {
        int prime;
        List<Integer> primes = new ArrayList<>(),
            numbers = new ArrayList<>()
        ;

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
}
