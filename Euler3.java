/* Author: Luigi Vincent

The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143?
*/

public class Euler3 {
	public static void main(String[] args) {
		final long START = System.nanoTime();
		long result = 600851475143L,
			divisor = 2L;

		while (divisor * divisor <= result) {
			if (result % divisor == 0) {
				result /= divisor;
			} else {
				divisor++;
			}
		}
		
		final long END = System.nanoTime();

		System.out.print("Result: " + result +
			".\nTime used for calculation in nanoseconds: " +
			(END - START) + "."
		);
	}
}
