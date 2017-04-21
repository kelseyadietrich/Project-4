package resume;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.stage.Window;

public class DocHandler {
	
	public FileWriter fileWriter;
	
	public String read() throws IOException {
		return ReadIn.readFile();
		
	}
	
	public void write(String s) {
			try {
					fileWriter = new FileWriter("src/HTML.html");
					fileWriter.write(s);
					fileWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	

	public void done() throws IOException {
		fileWriter.close();
	
	}


}
