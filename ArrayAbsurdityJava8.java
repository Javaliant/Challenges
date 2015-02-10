/* Author: Luigi Vincent

Challenge: Find the duplicated entry.

Specifications:
Your program should accept as its first argument a path to a filename.
Each line in this file is one test case.
Ignore all empty lines.

Each line begins with a positive integer(N), the size of the array,
then a semicolon followed by a comma separated list of positive numbers
which range from 0 to N-2, inclusive.

The array contains exactly one duplicated entry.
That duplicate appears exactly twice.
Print out the duplicated entry, each one on a new line.

Found on CodeEval, java 8 implementation suggested by rolfl (CodeReview)
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArrayAbsurdityJava8 {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get(args[0]))
            .filter(s -> !s.isEmpty())
            .forEach(ArrayAbsurdityJava8::printDuplicate);
    }

    private static void printDuplicate(String line) {
    	int length = Integer.parseInt(line.split(";")[0]);
        int total = Arrays.stream(line.split(";")[1].split(","))
                		.mapToInt(Integer::parseInt)
                		.sum();

        System.out.println(total - (length - 1) * (length - 2) / 2);
    }
}
