/* Author: Luigi Vincent
Challenge: Design a cash register program.

Specifications: 
Your register currently has the following bills/coins within it:

'PENNY': .01,
'NICKEL': .05,
'DIME': .10,
'QUARTER': .25,
'HALF DOLLAR': .50,
'ONE': 1.00,
'TWO': 2.00,
'FIVE': 5.00,
'TEN': 10.00,
'TWENTY': 20.00,
'FIFTY': 50.00,
'ONE HUNDRED': 100.00

Your program should accept as its first argument a path to a filename.
The input file contains several lines. Each line is one test case.
Each line contains two numbers which are separated by a semicolon.
The first is the Purchase price (PP) and the second is the cash(CH).

For each set of input produce a single line of output,
which is the cashBack to be returned to the customer.
In case the CH < PP, print out ERROR. If CH == PP, print out ZERO.
For all other cases print the amount that needs to be returned,
in terms of the currency values provided.
The output should be sorted in highest-to-lowest order

Found on CodeEval
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		while (fileInput.hasNextLine()) {
			printCashChange(fileInput.nextLine());
		}
	}

	private static void printCashChange(String line) {
		String[] fields = line.split(";");

		float pp = Float.parseFloat(fields[0]);
		float ch = Float.parseFloat(fields[1]);

		System.out.println(getCashChange(pp, ch));
	}

	private static String getCashChange(float price, float cash) {
		if (cash < price) { return "ERROR"; }
		if (cash == price) { return "ZERO"; }

		float cashBack = cash - price;
		StringBuilder change = new StringBuilder();

		for (Currency c : Currency.values()) {
   			while (cashBack >= c.getValue()) {
        		cashBack -= c.getValue();
        		change.append(c).append(',');
    		}
		}
		change.setLength(change.length() - 1);

		return change.toString();		
	}

	private enum Currency {
	    ONE_HUNDRED(100.00f),
	          FIFTY( 50.00f),
	         TWENTY( 20.00f),
	            TEN( 10.00f),
	           FIVE(  5.00f),
	            TWO(  2.00f),
	            ONE(  1.00f),
	    HALF_DOLLAR(  0.50f),
	        QUARTER(  0.25f),
	           DIME(  0.10f),
	         NICKEL(  0.05f),
	          PENNY(  0.01f);

	    private final float value;

	    Currency(float value) {
	        this.value = value;
	    }

	    public float getValue() {
	        return this.value;
	    }

	    @Override
	    public String toString() {
	        return this.name().replace("_", " ");
	    }
	}
}
