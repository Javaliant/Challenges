/* Author: Luigi Vincent
A Pangram is a sentence that contains all letters of the alphabet.

Challenge: Write a program, which takes a sentence, and returns all the letters it is missing,
which prevent it from being a pangram.

Specifications: You should ignore the case of the letters in sentence.
Your return should be all lower case letters, in alphabetical order.

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner fileScanner = new Scanner(new File(args[0]));
    	
    	while (fileScanner.hasNext()) {
    		printMissingLetters(fileScanner.nextLine());
    	}
    }

    public static void printMissingLetters(String possiblePangram) {
    	String str = possiblePangram.replaceAll("[^a-zA-Z]", "").toLowerCase();
    	Set<Character> alphabet = new LinkedHashSet<Character>() {
    		{
    			add('a'); add('b'); add('c');
    			add('d'); add('e'); add('f');
    			add('g'); add('h'); add('i');
    			add('j'); add('k'); add('l');
    			add('m'); add('n'); add('o');
    			add('p'); add('q'); add('r');
    			add('s'); add('t'); add('u');
    			add('v'); add('w'); add('x');
    			add('y'); add('z');
    		}
		};

		for (int i = 0; i < str.length(); i++) {
			if (alphabet.contains(str.charAt(i))) {
				alphabet.remove(str.charAt(i));
			}
			if (alphabet.size() == 0) {
				System.out.println("NULL");
				return;
			}
		}
		StringBuilder sb = new StringBuilder();

		for (Character c : alphabet) {
			sb.append(c);
		}

		System.out.println(sb.toString());
    }
}
