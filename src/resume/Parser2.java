package resume;

import java.io.IOException;

import java.util.ArrayList;

public class Parser2 {
	public DocHandler document;
	public User user;
	public ArrayList<String> parsed = new ArrayList<String>();

	public void initialize() {
		this.document = new DocHandler();
		this.parsed = new ArrayList<String>();
		parsed.add("<style>");
		parsed.add("h1 {text-align: right;font-size: 30pt;font-family: Arial;font-style: bold;margin: 20;padding: 20;}");
		parsed.add("body {font-family: Rockwell;font-size: 11pt;margin: 20;padding: 20;}");
		parsed.add("p {font-family: Rockwell;font-size: 11pt;width: 90%;}");
		parsed.add("h2 {font-size: 16pt;font-family: Impact;font-style: bold;margin: 20;padding: 20;}");
		parsed.add("h3 {font-size: 16pt;font-family: Arial;font-style: bold;}");
		parsed.add("h4 {font-size: 11pt;font-family: Arial;font-style: bold;}");
		parsed.add("#column1 {float:left;width: 33%;}");
		parsed.add("#column2 {float:left;width: 66%;}");
		parsed.add("</style>");
	}

	public void finalize() {
		parsed.add("</div>");
		String entireHtml = "";
		for (int i = 0; i < parsed.size(); i ++) {
			entireHtml += parsed.get(i);
		}
		document.write(entireHtml);
	}

	public void parsePersonal(User user) {
		String name = user.getName();
		name = name.toUpperCase();
		String email = user.getEmail();
		email = email.toUpperCase();
		String phone = user.getPhone();
		phone = phone.toUpperCase();
		Address add = user.getAddress();
		String address = add.toString();
		address.toUpperCase();

		parsed.add("<div style=\"width: 100%; height: 0px; border-bottom: 55px solid #ea4e4e; text-align: right;\"><span style=\"font-size: 40px; font-family: Arial Black; background-color: #ea4e4e; padding: 0 10px;\">");
		parsed.add(name);
		parsed.add("</span></div>");
		parsed.add("<div style=\"width: 100%; height: 0px; border-bottom: 55px solid #ea4e4e; text-align: right;\"><span style=\"font-size: 16px; font-family: Impact; background-color: #ea4e4e; padding: 0 10px;\">");
		parsed.add(email + " | " + phone + " | " + address);
		parsed.add("</span></div>");
		parsed.add("<br><br>");

		parsed.add("<div id=\"column1\"><h3>OBJECTIVE</h3><hr align=\"left\" width= \"90%\" size=\"10\" color= \"#ea4e4e\">");
		parsed.add("<p>" + user.getAdditional() + "</p>");

	}

	public void parseSkills(Skills skills) {
		parsed.add("<h3>SKILLS</h3>");
		parsed.add("<hr align=\"left\"  width= \"90%\"size=\"10\" color= \"#ea4e4e\">");
		parsed.add("<ul>");
		for (int a = 0; a < skills.size(); a++) {
			parsed.add("<li><h4>" + skills.getSkill(a) + "</h4>");
		}
		parsed.add("</ul>");
		parsed.add("</div>");
		parsed.add("<div id=\"column2\"><h3>EXPERIENCE</h3><hr align=\"left\" size=\"10\" color= \"#ea4e4e\">");

	}

	public void parseWork(Work work) {
		String title = work.getTitle().toUpperCase();
		String company = work.getEmployer().toUpperCase();
		String date = "";
		if (work.stillWorks() == true) {
			date = "CURRENT EMPLOYER";
		} else {
			date = work.getStart() + " - " + work.getEnd();
		}
		parsed.add("<h4>" + title + " | " + company + " | " + date + "</h4>");
		parsed.add("<p>" + work.getDescrip() + "</p>");
	}

	public void openEducation(){
		parsed.add("<h3>EDUCATION</h3><hr align=\"left\" size=\"10\" color= \"#ea4e4e\">");
	}

	public void parseEducation(Education edu) {
		String degree = edu.getDegree().toUpperCase();
		String date = "";
		if (edu.stillGoes() == true) {
			date = "CURRENTLY PURSUING";
		} else {
			date = edu.getStart() + " - " + edu.getEnd();
		}
		String school = edu.getSchool().toUpperCase();
		String major = edu.getMajor().toUpperCase();
		parsed.add("<h4>" + degree + " OF " + major + " | " + date + " | " + school + "</h4>");
		parsed.add("<p>" + edu.getAdditional() + "</p>");
	}



}
