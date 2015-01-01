/* Author: Luigi Vincent

Challenge 3: Given 2 strings, consider all the substrings within them
of length len. Len will be 1 or more.
Returns true if there are any such substrings which appear in both strings.
Compute this in linear time using a HashSet.

Found browsing for cs via web.standford.edu/
*/

import java.util.HashSet;

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
	}

	public static boolean stringIntersect(String a, String b, int len) {
		if (a.length() == 0 || b.length() == 0) { return false; }

		HashSet<String> alpha = permutateString(a, len);
		HashSet<String> beta = permutateString(b, len);

		for (String s : alpha) {
			if (beta.contains(s)) { return true; }
		}

		return false;
	}


	public static HashSet<String> permutateString(String str, int i) {
		if (i > str.length()) {
			throw new IllegalArgumentException(
				"Substring length cannot be larger than provided string"
			);
		}

		HashSet<String> set = new HashSet<>();
		int count = i;

		for (int j = 0; j < str.length(); j++ ) {
			if (count > str.length()) { break; }

			set.add(str.substring(j, count));
			count++;
		}

		return set;
	}
}
