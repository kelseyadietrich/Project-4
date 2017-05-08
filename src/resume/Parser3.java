package resume;

import java.io.IOException;

import java.util.ArrayList;

public class Parser3 {
	public DocHandler document;
	public User user;
	public ArrayList<String> parsed = new ArrayList<String>();

	public void initialize() {
		this.document = new DocHandler();
		this.parsed = new ArrayList<String>();
		parsed.add("<style>#column1 {float:left;width: 33%;}#column2 {float:left;width: 66%;}</style>");
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
		name.toUpperCase();
		String email = user.getEmail();
		email.toUpperCase();
		String phone = user.getPhone();
		phone.toUpperCase();
		Address add = user.getAddress();
		String address = add.toString();
		address.toUpperCase();
		String objective = user.getAdditional();
		objective.toUpperCase();

		parsed.add("<div id=\"column1\">");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<h1>");
		parsed.add(name);
		parsed.add("</h1>");
		parsed.add("</center>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<p align=\"center\"><img src=\"Untitled-1_clip_image001.png\" alt=\"Title: Email icon\" width=\"38\" height=\"38\" align=\"middle\"></p>");
		parsed.add("<h3 align=\"center\">");
		parsed.add(email);
		parsed.add("</h3>");
		parsed.add(" <p align=\"center\"><img width=\"38\" height=\"38\" src=\"Untitled-1_clip_image002.png\" alt=\"Title: Telephone icon\"></p>");
		parsed.add("<h3 align=\"center\">");
		parsed.add(phone);
		parsed.add("</h3>");
		parsed.add("<p align=\"center\"><img src=\"Untitled-1_clip_image003.png\" alt=\"Title: Address icon\" width=\"38\" height=\"38\"></p>");
		parsed.add("<h3 align=\"center\">");
		parsed.add(address);
		parsed.add("</h3>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h3 align=\"center\">");
		parsed.add("Objective");
		parsed.add("</h3>");
		parsed.add("<p align=\"center\"><img width=\"26\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<p align=\"center\" style=\"width:350\">");
		parsed.add(objective);
		parsed.add("</p>");
		parsed.add("</center>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h3 align=\"center\">");
		parsed.add("</p>");
		parsed.add("</center>");
		parsed.add("</td>");
		parsed.add("</tr>");
	}

	public void parseSkills(Skills skills) {
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h3 align=\"center\">Skills </h3>");
		parsed.add("<p align=\"center\"><img width=\"26\" height=\"2\" src=\"Untitled-1_clip_image005.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<p align=\"center\">");
		for (int a = 0; a < skills.size(); a++) {
			parsed.add("<h4>" + skills.getSkill(a) + "</h4>");
		}
		parsed.add("</p>");
		parsed.add("</center>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br></td>");
		parsed.add("</div>");
	}

	public void parseWork(Work work) {
		String title = work.getTitle();
		title = title.toUpperCase();
		String company = work.getEmployer();
		company.toUpperCase();
		String start = work.getStart();
		start.toUpperCase();
		String end = work.getEnd();
		end.toUpperCase();

		parsed.add("<h4 align=\"center\">");
		parsed.add(title);
		parsed.add("</h4>");
		parsed.add("<h5 align=\"center\">");
		parsed.add(start + " - " + end);
		parsed.add("</h5>");
		parsed.add("<p align=\"center\">");
		parsed.add(work.getDescrip());
		parsed.add("</p>");
	}
	
	public void openWork() {
		parsed.add("<div id=\"column2\">");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h2 align=\"center\">Experience</h2>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("</div>");
		parsed.add("<center>");
	}
	
	public void closeWork() {
		parsed.add("</center>");
	}

	public void parseEducation(Education edu) {
		String degree = edu.getDegree();
		degree = degree.toUpperCase();
		String date = edu.getEnd();
		date = date.toUpperCase();
		String school = edu.getSchool();
		school.toUpperCase();
		
		parsed.add("<h4 align=\"center\">");
		parsed.add(degree + "/" + date);
		parsed.add("</h4>");
		parsed.add("<h5 align=\"center\">");
		parsed.add(school);
		parsed.add("</h5>");
		parsed.add("<p align=\"center\">");
		parsed.add(edu.getAdditional());
		parsed.add("</p>");
	}

	public void openEdu() {
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h2 align=\"center\">Education</h2>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
	}

	public void closeEdu() {
		parsed.add(" <p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
	}

}
