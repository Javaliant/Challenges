/* Author: Luigi Vincent
Challenge: 2520 is the smallest number divisible by 1 to 10 
without any remainder.
What is the smallest positive number that is evenly divisible by 1-20?
*/

import java.util.List;
import java.util.ArrayList;

public class Euler5 {
    static final int MAX_NUM = 20;

    public static void main(String[] args) {
        final long START = System.nanoTime();
        final int GIVEN = 2520;
        int result = GIVEN;

        /* Given that 2520 is the LCM of 1 - 10,
        it is safe to presume that any multiple of 11 - 20, 
        that is also a multiple of 1 - 10,
        is therefore also a multiple of 2520.
        Thus, for a starting point,
        multiply 2520 by the primes between 11 - 20*/
        for (int n : getPrimesBetween(11, 20)) {
            result *= n;
        }

        while (!isSmallestMultiple(result)) {
            result += result;
        }
        
        final long END = System.nanoTime();

        System.out.println("Result: " + result +
                ".\nTime used for calculation in nanoseconds: " +
                (END - START) + "."
        );
    }

    public static boolean isSmallestMultiple(int n) {
        for (int i = 11; i <= MAX_NUM; i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }

    /*Sieve of Eratosthenes - 
    http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes */
    public static List<Integer> getPrimesBetween(int start, int limit) {
        int prime;
        List<Integer> primes = new ArrayList<>(),
            numbers = new ArrayList<>()
        ;

        for (int i = 2; i < limit; i++) {
            numbers.add(i);
        }

        while (!numbers.isEmpty()) {
            prime = numbers.get(0);
            if (prime >= start) { primes.add(prime); }
            for (int i = prime; i < limit; i += prime) {
                numbers.remove((Integer)(i));
            }
        }
        return primes;
    }
}
