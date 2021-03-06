/* Author: Luigi Vincent

Challenge 1: Given a string, for each digit in the original string,
replace the digit with that many occurences of the character following.
So "a3tx2z" yields "attttxzzz"

Found browsing for cs via web.standford.edu/
*/

public class Standford1 {
	public static void main(String[] args) {
		/* Two plain cases */
		System.out.println("Test 1: " + "xxaaaabb".equals(blowup("xx3abb")));
		System.out.println("Test 2: " + "xxxZZZZ".equals(blowup("2x3Z")));
		/* digit at the end */
		System.out.println("Test 3: " + "axxx".equals(blowup("a2x3")));
		/* Adjacent digits */
		System.out.println("Test 4: " + "a33111".equals(blowup("a231")));
		/* Digit include 0 */
		System.out.println("Test 5: " + "aabb".equals(blowup("aa0bb")));
		/* Unusual Characters */
		System.out.println("Test 6: " + "AB&&,- ab".equals(blowup("AB&&,- ab")));
		/* Empty String */
		System.out.println("Test 7: " + "".equals(blowup("")));
		/* Only digits */
		System.out.println("Test 8: " + "".equals(blowup("2")));
		System.out.println("Test 9: " + "33".equals(blowup("23")));
	}

	public static String blowup(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
			else if (i == str.length() - 1) { return sb.toString(); }
			else {
				sb.append(lengthen(str.charAt(i + 1),
					Character.getNumericValue(str.charAt(i))));
			}
		}
		return sb.toString();
	}

	public static String lengthen(char c, int i){
		if (i == 0 || c == ' ') { return ""; }
		int count = 0;
		StringBuilder sb = new StringBuilder(c);
		while (count != i) {
			sb.append(c);
			count++;
		}
		return sb.toString();
	}
}
