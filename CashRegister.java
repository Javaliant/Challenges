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
import java.math.BigDecimal;

public class CashRegister {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(args[0]));

		while (fileInput.hasNextLine()) {
			printCashChange(fileInput.nextLine());
		}
	}

	private static void printCashChange(String line) {
		String[] fields = line.split(";");
		BigDecimal pp = new BigDecimal(fields[0]);
		BigDecimal ch = new BigDecimal(fields[1]);
		System.out.println(computeChange(pp, ch));
	}

	private static String computeChange(BigDecimal price, BigDecimal cash) {
		if (cash.compareTo(price) == -1) {
			return "ERROR";
		}
		if (cash.compareTo(price) == 0) {
			return "ZERO";
		}

		BigDecimal cashBack = cash.subtract(price);
		StringBuilder change = new StringBuilder();

		for (Currency c : Currency.values()) {
   			while (cashBack.compareTo(c.getValue()) != -1) {
        		cashBack = cashBack.subtract(c.getValue());
        		change.append(c).append(',');
    			}
		}
		
		change.setLength(change.length() - 1);

		return change.toString();		
	}

	private enum Currency {
	    ONE_HUNDRED(new BigDecimal("100.00")),
	          FIFTY(new BigDecimal( "50.00")),
	         TWENTY(new BigDecimal( "20.00")),
	            TEN(new BigDecimal( "10.00")),
	           FIVE(new BigDecimal(  "5.00")),
	            TWO(new BigDecimal(  "2.00")),
	            ONE(new BigDecimal(  "1.00")),
	    HALF_DOLLAR(new BigDecimal(  "0.50")),
	        QUARTER(new BigDecimal(  "0.25")),
	           DIME(new BigDecimal(  "0.10")),
	         NICKEL(new BigDecimal(  "0.05")),
	          PENNY(new BigDecimal(  "0.01"));

	    private final BigDecimal value;

	    Currency(BigDecimal value) {
	        this.value = value;
	    }

	    public BigDecimal getValue() {
	        return this.value;
	    }

	    @Override
	    public String toString() {
	        return name().replace("_", " ");
	    }
	}
}
