/* Author: Luigi Vincent

Challenge 2: Given a seqing, return the length of the largest run.
A run is a series of adjacent chars that are the same.

Found browsing for cs via web.standford.edu/
*/

public class Standford2 {
	public static void main(String[] args) {
        System.out.println("Test 1: " + (1  == maxRun("123")));
        System.out.println("Test 2: " + (2  == maxRun("1223")));
        System.out.println("Test 3: " + (2  == maxRun("112233")));
        System.out.println("Test 4: " + (3  == maxRun("1112233")));
        System.out.println("Test 5: " + (2  == maxRun("hoopla")));
        System.out.println("Test 6: " + (3  == maxRun("hoopllla")));
        System.out.println("Test 7: " + (3  == maxRun("abbcccddbbbxx")));
        System.out.println("Test 8: " + (0  == maxRun("")));
        System.out.println("Test 9: " + (3  == maxRun("hhhooppoo")));
	}

	public static int maxRun(CharSequence seq) {
		if (seq.length() == 0) { return 0; }

		int maxRun = 1, currentRun = 1;

		for (int i = 1; i < seq.length(); i++) {
			if (seq.charAt(i) == seq.charAt(i - 1)) {
				currentRun++;
				if (currentRun > maxRun) { maxRun = currentRun; }
			} 
			else { currentRun = 1; }
		}
		return maxRun;
	}
}
