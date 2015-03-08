/* Author: Luigi Vincent

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Stack<T> {
	LinkedList<T> list = new LinkedList<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));

		while (input.hasNextLine()) {
			System.out.println(
				retrieveAlternates(input.nextLine().split("\\s+"))
			);
		}
	}

	private static String retrieveAlternates(String[] input) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();

		for (String s : input) {
			stack.push(Integer.parseInt(s));
		}

		for (int i = 0; i < input.length; i++) {
			if ((i & 1) == 0) {
				result.append(' ').append(stack.pop());
			} else {
				stack.pop();
			}
		}

		return result.substring(1);
	}

	public void push(T t) {
		list.add(t);
	}
	public T pop() {
		return list.removeLast();
	}
}
