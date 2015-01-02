/* Author: Luigi Vincent

Challenge 3: Given 2 strings, consider all the substrings within them
of length len. Len will be 1 or more.
Returns true if there are any such substrings which appear in both strings.
Compute this in linear time using a HashSet.

Found browsing for cs via web.standford.edu/
*/

import java.util.HashSet;
import java.util.Set;

public class Standford3 {
	public static void main(String[] args) {
		System.out.println("Test 1: " +
			(false  == stringIntersect("blahblah", "foralheh", 3))
		);
		System.out.println("Test 2: " +
			(true  == stringIntersect("checking", "deck", 2))
		);
		System.out.println("Test 3: " +
			(false  == stringIntersect("derping", "slurp", 3))
		);
		System.out.println("Test 4: " +
			(false  == stringIntersect("foo", "bar", 1))
		);
		System.out.println("Test 5: " +
			(true  == stringIntersect("nowai", "55&dcsnow", 3))
		);
		System.out.println("Test 6: " +
			(true  == stringIntersect("awaicain", "wai", 3))
		);
	}

	public static boolean stringIntersect(String a, String b, int len) {
		if (a.length() == 0 || b.length() == 0) { return false; }

		Set<String> alpha = permutateString(a, len);
		Set<String> beta = permutateString(b, len);

		for (String s : alpha) {
			if (beta.contains(s)) { return true; }
		}

		return false;
	}


	public static Set<String> permutateString(String str, int length) {
		if (length > str.length()) {
			throw new IllegalArgumentException(
				"Substring length cannot be larger than provided string"
			);
		}

		Set<String> result = new HashSet<>();
		int tracker = length;

		for (int i = 0; i < str.length(); i++ ) {
			if (tracker > str.length()) { break; }

			result.add(str.substring(i, tracker));
			tracker++;
		}

		return result;
	}
}
