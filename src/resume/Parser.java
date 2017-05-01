package resume;

import java.io.IOException;

import java.util.ArrayList;

public class Parser {
	
	public DocHandler document;
	public User user;
	public ArrayList<String> parsed = new ArrayList<String>();
	
	public void initialize() {
		this.document = new DocHandler();
		this.parsed = new ArrayList<String>();
		parsed.add("<style>");
		parsed.add("h1 {color: #2a7b88;font-size: 30pt;font-family: Cambria;font-style: italic;}");
		parsed.add("body {font-family: Cambria;font-size: 11pt;}");
		parsed.add("h2 {color: #2a7b88;font-size: 14pt;font-family: Cambria;font-style: bold;}");
		parsed.add("h3 {color: ##000000; font-size: 12pt; font-family: Cambria;  font-style: bold;}");
		parsed.add("</style>");

	}
	
	public void finalize() {
		String entireHtml = "";
		for (int i = 0; i < parsed.size(); i ++) {
			entireHtml += parsed.get(i);
		}
		document.write(entireHtml);
	}
	
	public void parsePersonal(User user) {
		String name = user.getName();
		name.toUpperCase();
		Address add = user.getAddress();
		String address = add.toString();
		parsed.add("<h1>" + name + "</h1>");
		parsed.add("<hr>");
		parsed.add(address + " | ");
		parsed.add(user.getPhone() + " | ");
		parsed.add(user.getEmail());
		parsed.add("<br><br>");
		parsed.add("<h2>Objective</h2>");
		parsed.add(user.getAdditional());
		parsed.add("<br><br>");
		
	}
	
	public void parseWork(Work work) {
		parsed.add("<h2>Experience</h2>");
		String title = work.getTitle();
		title = title.toUpperCase();
		String company = work.getEmployer();
		company.toUpperCase();
		String start = work.getStart();
		start.toUpperCase();
		String end = work.getEnd();
		end.toUpperCase();
		parsed.add("<h3>" + title + " | " + company + " | " + start + " - " + end);
		parsed.add("<ul>");
		parsed.add("<li>" + work.getDescrip() + "</ul> ");
	
	}
	
	public void parseEducation(Education edu) {
		parsed.add("<h2>Education</h2>");
		//<h3>DEGREE | DATE EARNED | SCHOOL </h3>
		String degree = edu.getDegree();
		degree = degree.toUpperCase();
		String date = edu.getEnd();
		date = date.toUpperCase();
		String school = edu.getSchool();
		school.toUpperCase();
		
		parsed.add("<h3>" + degree + " | " + date + " | " + school + "</h3>");
		parsed.add("<ul>");
		if (edu.getMajor() != "") {
			parsed.add("<li>Major: " + edu.getMajor());
		}
		if (edu.getMinor() != "") {
			parsed.add("<li>Minor: " + edu.getMinor());
		}
		if (edu.getAdditional() != "") {
			parsed.add("<li>Additional: " + edu.getAdditional() + "</ul>");
		}
		
	}
	
	public void parseSkill(Skills skills) {
		parsed.add("</li></ul><h2>Skills & Abilities</h2>");
		
		
		for (int a = 0; a < skills.size(); a++) {
			parsed.add("<h3>" + skills.getSkill(a) + "</h3>");
			
		}
		
	}
	
	

}
