package resume;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ReadIn {
	public static String initialize() throws FileNotFoundException {
		String read = readFile();
		return read;
	}
	
	public static String readFile() throws FileNotFoundException {
		String read = "";
		Scanner fileScanner = new Scanner(new File("HTML.html"));
		while (fileScanner.hasNextLine()) {
			read += fileScanner.nextLine();
		}
		fileScanner.close();
		return read;
	}
}
