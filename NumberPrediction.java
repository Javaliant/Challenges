/* Author: Luigi Vincent
Challenge: Print the size of the file in bytes.

Found on CodeEval
*/
import java.io.File;
import java.io.FileNotFoundException;

public class FileSize {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new File(args[0]).length());
	}
}
