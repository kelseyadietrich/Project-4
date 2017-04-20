package resume;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	
	public String read() throws IOException {
		
		FileReader in = new FileReader("HTML.txt");
		BufferedReader file = new BufferedReader(in);
	     
		String html = ""; 	 
				 
	     while ((file.readLine()) != null) {
	         html += file.readLine();
	     }
	     return html;
	}


}
