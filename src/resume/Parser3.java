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
		parsed.add("<table border=\"0\" cellspacing=\"20\" cellpadding=\"0\" summary=\"Layout table for all content\" width=\"100%\">");
		parsed.add("<tr>");
		parsed.add("<td width=\"457\" valign=\"top\"><div>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<h1>");
	}

	public void finalize() {
		String entireHtml = "";
		for (int i = 0; i < parsed.size(); i ++) {
			entireHtml += parsed.get(i);
		}
		document.write(entireHtml);
		System.out.print(entireHtml);
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

		parsed.add("<h1>");
		parsed.add(name);
		parsed.add("</h1>");
		parsed.add("</center>");
		parsed.add(" <p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("</div>");
		parsed.add("  <p align=\"center\"><img src=\"Untitled-1_clip_image001.png\" alt=\"Title: Email icon\" width=\"38\" height=\"38\" align=\"middle\"></p>");
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
		parsed.add("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" summary=\"Left side layout table\" width=\"100%\">");
		parsed.add("<tr>");
		parsed.add("<td width=\"202\" valign=\"top\">&nbsp;</td>");
		parsed.add("</tr>");
		parsed.add("<tr>");
		parsed.add("<td width=\"202\" valign=\"top\">");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h3 align=\"center\">Objective</h3>");
		parsed.add("<p align=\"center\"><img width=\"26\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<p align=\"center\" style=\"width:350\">");
		parsed.add(user.getAdditional());
		parsed.add("</p>");
		parsed.add("</center>");
		parsed.add("</td>");
		parsed.add("</tr>");
	}

	public void parseSkills(Skills skills) {
		parsed.add("<tr>");
		parsed.add("<td width=\"202\" valign=\"top\">");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h3 align=\"center\">Skills </h3>");
		parsed.add("<p align=\"center\"><img width=\"26\" height=\"2\" src=\"Untitled-1_clip_image005.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<center>");
		parsed.add("<p align=\"center\" style=\"width:350\">");
		for (int a = 0; a < skills.size(); a++) {
			parsed.add("<h4>" + skills.getSkill(a) + "</h4>");
		}
		parsed.add("</p>");
		parsed.add("</center>");
		parsed.add("<p align=\"center\"><img width=\"400\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br></td>");
		parsed.add("</tr>");
		parsed.add("</table></td>");
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
		parsed.add("<h4 align=\"center\">");
		parsed.add(start + " - " + end);
		parsed.add("<p align=\"center\"");
		parsed.add(work.getDescrip());
		parsed.add("</p>");
	}
	
	public void openWork() {
		parsed.add("<td width=\"900\" valign=\"top\"><table border=\"0\" cellspacing=\"20\" cellpadding=\"0\" summary=\"Right side layout table\" width=\"100%\">");
		parsed.add("<tr>");
		parsed.add("<td width=\"300\" valign=\"top\"><div>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h2 align=\"center\">Experience</h2>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("</div>");
		parsed.add("<center>");
	}
	
	public void closeWork() {
		parsed.add("</center>");
		parsed.add("</tr>");
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
		parsed.add("");
		parsed.add("</h5>");
		parsed.add("<p align=\"center\">");
		parsed.add("");
		parsed.add("</p>");
	}

	public void openEdu() {
		parsed.add("<tr>");
		parsed.add("<td width=\"346\" valign=\"top\">");
		parsed.add("<div>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("<h2 align=\"center\">Education</h2>");
		parsed.add("<p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("</div>");
	}

	public void closeEdu() {
		parsed.add(" <p align=\"center\"><img width=\"900\" height=\"3\" src=\"Untitled-1_clip_image004.png\" alt=\"Title: Line graphic\"><br>");
		parsed.add("</td>");
		parsed.add("</tr>");
		parsed.add("</table>");
		parsed.add("</td>");
		parsed.add("</tr>");
		parsed.add("</table>");
	}

}
