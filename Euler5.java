/* Author: Luigi Vincent
2520 is the smallest number divisible by 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by 1-20
*/

public class Euler5 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        final int MAX_NUM = 20,
           	GIVEN = 2520;
        int result = GIVEN;

        /* Given that 2520 is the LCM of 1 - 10,
        it is safe to presume that any multiple of 11 - 20, 
        that is also a multiple of 1 - 10,
        is therefore also a multiple of 2520.
        Thus, for a starting point,
        multiply 2520 by the primes between 11 - 20*/
        for (int i = 11; i <= MAX_NUM; i++) {
            if (isPrime(i)) {
            	result *= i;
            }
        }

        while (!isSmallestMultiple(result)) {
            result += result;
        }

        System.out.print("Result: " + result +
        	".\nTime used for calculation in nanoseconds: " +
            (System.nanoTime() - startTime) + ".");
        }

    public static boolean isSmallestMultiple(int n) {
        for (int i = 11; i <= MAX_NUM; i++) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }

    // Expects a positive integer
    private static boolean isPrime(int num) {
    	if (num < 1) {
    		throw new IllegalArgumentException(
    			"Argument must be a positive integer." +
    			"\n Argument was " + num + "."
    		);
    	}
    	if (num <= 3){
    		return num == 1 ? false : true;
    	}
        if (num % 2 == 0) { return false; }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
	}
}
