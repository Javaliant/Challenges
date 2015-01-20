/* Author: Luigi Vincent
Challenge: Design a cash register program.

Specifications: You will be given two float numbers.

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
        float pp = Float.parseFloat(line.split(";")[0]);
        float ch = Float.parseFloat(line.split(";")[1]);

        System.out.println(getCashChange(pp, ch));
    }

    private static String getCashChange(float price, float cash) {
        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }
        float cashBack = cash - price;


        StringBuilder change = new StringBuilder();

        while (cashBack > 0.01f) {
            if (cashBack >= 100.0f) {
                change.append("ONE HUNDRED");
                cashBack -= 100.0f;
            } else if (cashBack >= 50.0f) {
                change.append("FIFTY");
                cashBack -= 50.0f;
            } else if (cashBack >= 20.0f) {
                change.append("TWENTY");
                cashBack -= 20.0f;
            } else if (cashBack >= 10.0f) {
                change.append("TEN");
                cashBack -= 10.0f;
            } else if (cashBack >= 5.0f) {
                change.append("FIVE");
                cashBack -= 5.0f;
            } else if (cashBack >= 2.0f) {
                change.append("TWO");
                cashBack -= 2.0f;
            } else if (cashBack >= 1.0f) {
                change.append("ONE");
                cashBack -= 1.0f;
            } else if (cashBack >= 0.5f) {
                change.append("HALF DOLLAR");
                cashBack -= 0.5f;
            } else if (cashBack >= 0.25f) {
                change.append("QUARTER");
                cashBack -= 0.25f;
            } else if (cashBack >= 0.1f) {
                change.append("DIME");
                cashBack -= 0.1f;
            } else if (cashBack >= 0.05f) {
                change.append("NICKEL");
                cashBack -= 0.05f;
            } else {
                change.append("PENNY");
                cashBack -= 0.01f;
            }
            change.append(",");
        }
        change.setLength(change.length() - 1);

        return change.toString();
    }
