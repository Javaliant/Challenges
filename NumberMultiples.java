/* Author: Luigi Vincent
Challenge: Given numbers x and n, 
where n is a power of 2, 
print out the smallest multiple of n which is greater than or equal to x.

Example Input:
13,8
17,16

Example Output:
16
32

Found on CodeEval
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberMultiples {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);

		while (in.hasNextLine()) {
			printResult(in.nextLine());
		}
	}
	private static void printResult(String line) {
		int goal = Integer.parseInt(line.split(",")[0]);
		int multiplier = Integer.parseInt(line.split(",")[1]);

		System.out.println(getResult(goal, multiplier));
	}
	private static int getResult(int x, int n) {
		for (int i = n; ; i += n) {
			if (i >= x) {
				return i;
			}
		}
	}
}
