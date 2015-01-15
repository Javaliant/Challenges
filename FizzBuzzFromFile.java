/* Author: Luigi Vincent

Challenge: Write a program that prints out the final series of numbers
where those divisible by X, Y and both are replaced by “F” for fizz,
“B” for buzz and “FB” for fizz buzz.

Specifications: Your program should accept a file as its first argument.
The file contains multiple separated lines;
each line contains 3 numbers that are space delimited.
The first number is the first divider (X),
the second number is the second divider (Y),
and the third number is how far you should count (N).
You may assume that the input file is formatted correctly and 
the numbers are valid positive integers. 
Your output should print out one line per set. 
Ensure that there are no trailing empty spaces in each line you print.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FizzBuzzFromFile {
    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File(args[0]);
    	Scanner fileScanner = new Scanner(file);
    	while (fileScanner.hasNextLine()) {
    		printFizzBuzz(fileScanner.nextLine());
    	}
    }

    public static void printFizzBuzz(String line) {
    	int fizz = Integer.parseInt(line.split(" ")[0]);
    	int buzz = Integer.parseInt(line.split(" ")[1]);
    	int limit = Integer.parseInt(line.split(" ")[2]);
    	
    	StringBuilder sb = new StringBuilder();

    	for (int i = 1; i <= limit; i++) {
    		if (i % fizz == 0) { sb.append("F"); }
    		if (i % buzz == 0) { sb.append("B"); }
    		else { if (i % fizz != 0) { sb.append(i); } }
    		if (i < limit) { sb.append(" "); }
    	}
    	System.out.println(sb.toString());
    }
}
