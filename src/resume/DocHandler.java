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
		
		FileReader in = new FileReader("HTML.txt");
		BufferedReader file = new BufferedReader(in);
	     
		String html = ""; 	 
				 
	     while ((file.readLine()) != null) {
	         html += file.readLine();
	     }
	     return html;
	}
	
	public void write(String s) {
			try {
					fileWriter = new FileWriter("HTML.txt");
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
