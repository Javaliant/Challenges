/* Author: Luigi Vincent

Challenge 2: Given a string, return the length of the largest run.
A run is a series of adjacent chars that are the same.

Found browsing for cs via web.standford.edu/
*/

public class Standford2 {
	public static void main(String[] args) {
		System.out.println("Test 1: " + (1  == maxRun("123")));
		System.out.println("Test 1: " + (2  == maxRun("1223")));
		System.out.println("Test 1: " + (2  == maxRun("112233")));
		System.out.println("Test 1: " + (3  == maxRun("1112233"))); 
	}

	public static int maxRun(String str) {
		if (str.length() == 0) { return 0; }

		int maxCheck = 0,
			maxRun = 1,
			currentRun = 1;

		if (str.length() == 1) { return maxRun; }

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				currentRun++;
				if (currentRun > maxRun) { maxRun = currentRun; }
			}
			else { currentRun = 1; }
		}
		return maxRun;
	}
}
