/* Author: Luigi Vincent
2520 is the smallest number divisible by 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by 1-20
*/

public class Euler5 {
        public static void main(String[] args) {
            long startTime = System.nanoTime();
            final int GIVEN = 2520,
            	MAX_NUM = 20;
            int result = GIVEN;

            /* Multiplying by primes for a starting point
            Begins at 11, since 2520 already accounts for 1-10 */
            for (int i = 11; i <= MAX_NUM; i++) {
            	if (isPrime(i)) {
            		result *= i;
            	}
            }
            // Multiplying by 2 for evenness
            result *= 2; // This is already the answer

            // Ensuring it is correct
            while (!isSmallestMultiple(result)) {
                result += result;
            }

            System.out.print("Result: " + result +
                ".\nTime used for calculation in nanoseconds: " +
                (System.nanoTime() - startTime) + ".");
        }

    public static boolean isSmallestMultiple(int n) {
        for (int i = 11; i <= 20; i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if (num % 2 == 0) { return false; }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
	}
}
