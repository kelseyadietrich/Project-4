package resume;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	
	public DocHandler document;
	public User user;
	
	public void initialize(User u) {
		this.document = new DocHandler();
		this.user = u;
		document.write("<style>");
		document.write("h1 {color: #2a7b88;font-size: 30pt;font-family: Cambria;font-style: italic;}");
		document.write("body {font-family: Cambria;font-size: 11pt;}");
		document.write("h2 {color: #2a7b88;font-size: 14pt;font-family: Cambria;font-style: bold;}");
		document.write("h3 {color: ##000000; font-size: 12pt; font-family: Cambria;  font-style: bold;}");
		document.write("</style>");
		
	}
	
	public void parsePersonal() {
		String name = user.getName();
		name.toUpperCase();
		document.write("<h1>" + name + "</h1>");
		document.write("<hr>");
		document.write(user.getAddress() + " | ");
		document.write(user.getPhone() + " | ");
		document.write(user.getEmail());
		document.write("<br><br>");
		document.write("<h2>Objective</h2>");
		document.write(user.getAdditional());
		
	}
	
	public void parseWork() {
		
	}
	
	public void parseIntern() {
		
	}
	
	public void parseEducation() {
		
	}

}
