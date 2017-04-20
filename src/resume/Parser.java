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
		document.write("<br><br>");
		
	}
	
	public void parseWork(Work work) {
		document.write("<h2>Experience</h2>");
		String title = work.getTitle();
		title = title.toUpperCase();
		String company = work.getEmployer();
		company.toUpperCase();
		String start = work.getStart();
		start.toUpperCase();
		String end = work.getEnd();
		end.toUpperCase();
		document.write("<h3>" + title + " | " + company + " | " + start + " - " + end);
		document.write("<ul>");
		document.write("<li>" + work.getDescrip() + "</ul> ");
	
	}
	
	public void parseEducation(Education edu) {
		document.write("<h2>Education</h2>");
		//<h3>DEGREE | DATE EARNED | SCHOOL </h3>
		String degree = edu.getDegree();
		degree = degree.toUpperCase();
		String date = edu.getEnd();
		date = date.toUpperCase();
		String school = edu.getSchool();
		school.toUpperCase();
		
		document.write("<h3>" + degree + " | " + date + " | " + school + "</h3>");
		document.write("<ul>");
		document.write("<li>Major: " + edu.getMajor());
		document.write("<li>Minor: " + edu.getMinor());
		document.write("<li>Additional: " + edu.getAdditional() + "</ul>");
		
	}

}
