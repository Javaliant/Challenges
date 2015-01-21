/* Author: Luigi Vincent
Challenge: Print the size of the file in bytes.

Found on CodeEval
*/
import java.io.File;
import java.io.FileNotFoundException;

public class FileSize {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		System.out.println(file.length());
	}
}
