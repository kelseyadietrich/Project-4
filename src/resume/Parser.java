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

	public void openWork(){
		parsed.add("<h2>Experience</h2>");
	}

	public void parseWork(Work work) {
		String title = work.getTitle().toUpperCase();
		String company = work.getEmployer().toUpperCase();
		String start = work.getStart().toUpperCase();
		String end = work.getEnd().toUpperCase();
		parsed.add("<h3>" + title + " | " + company + " | " + start + " - " + ((end.equals(""))?"PRESENT":end));
		parsed.add("<ul>");
		parsed.add("<li>" + work.getDescrip() + "</ul> ");
	}

	public void openEducation(){
		parsed.add("<h2>Education</h2>");
	}

	public void parseEducation(Education edu) {
		String degree = edu.getDegree().toUpperCase();
		String start = edu.getStart().toUpperCase();
		String end = edu.getEnd().toUpperCase();
		String school = edu.getSchool().toUpperCase();
		parsed.add("<h3>" + degree + " | " + start + " - " + ((end.equals(""))?"PRESENT":end) + " | " + school + "</h3>");
		parsed.add("<ul>");
		if (!edu.getMajor().equals("")) parsed.add("<li>Major: " + edu.getMajor() + "</li>");
		if (!edu.getMinor().equals("")) parsed.add("<li>Minor: " + edu.getMinor() + "</li>");
		if (!edu.getAdditional().equals("")) parsed.add("<li>Additional: " + edu.getAdditional() + "</li?");
		parsed.add("</ul>");
	}

	public void parseSkill(Skills skills) {
		parsed.add("</li></ul><h2>Skills & Abilities</h2>");
		parsed.add("<ul>");

		for (int a = 0; a < skills.size(); a++) {
			parsed.add("<li><h3>" + skills.getSkill(a) + "</h3>");

		}
		parsed.add("</ul>");

	}



}
