/* Author: Luigi Vincent

Challenge: Write a program which outputs the longest lines within a file.

Specifications: 
Your program should accept a file path as its first argument.
The file contains multiple lines.
The first line contains which number of lines you should output.
The other lines are of different lenghts, presented randomly.

You may assume that the input file is formatted correctly,
and that the number in the first line is a valid positive integer.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class LongestLines {
	static TreeMap<Integer, String> lines = new TreeMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		int numberOfLinesToPrint = Integer.parseInt(input.nextLine());

		while (input.hasNextLine()) {
			addLine(input.nextLine());
		}

		printLongestLines(numberOfLinesToPrint);
	}

	private static void printLongestLines(int numberOfTimes) {
		for (int i = 1; i <= numberOfTimes; i++) {
			System.out.println(lines.pollLastEntry().getValue());
		}
	}

	private static void addLine(String line) {
		lines.put(line.length(), line);
	}
}
