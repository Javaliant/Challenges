/* Author: Luigi Vincent

Challenge: Determine which category each person fits into based on their age.
From 0 to 2 print : 'Still in Mama's arms' 
3 or 4 print : 'Preschool Maniac' 
From 5 to 11 print : 'Elementary school' 
From 12 to 14: 'Middle school' 
From 15 to 18: 'High school' 
From 19 to 22: 'College'
From 23 to 65: 'Working for the man' 
From 66 to 100: 'The Golden Years' 
If less than 0 or more than 100 print: "This program is for humans"


Specifications: 
Your program should accept as its first argument a path to a filename.
Each line of input contains one integer, the age of the person.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AgeDistribution {
	public static void main(String[] args) throws FileNotFoundException {
		File ages = new File(args[0]);
		Scanner file = new Scanner(ages);

		while (file.hasNextLine()) {
			printCategory(file.nextLine());
		}	
	}

	private static void printCategory(String line) {
		System.out.println(
			getCategory(Integer.parseInt(line))
		);
	}

	private static String getCategory(int age) {
		if (age < 0 || age > 100) { return "This program is for humans"; }
		if (age >= 66) { return "The Golden Years"; }
		if (age >= 23) { return "Working for the Man"; }
		if (age >= 19) { return "College"; }
		if (age >= 15) { return "High School"; }
		if (age >= 12) {return "Middle School"; }
		if (age >= 5) { return "Elementary School"; }
		if (age >= 3 ){ return "Preschool Maniac"; }
		else { return "Still in Mama's arms"; }
	}

}
