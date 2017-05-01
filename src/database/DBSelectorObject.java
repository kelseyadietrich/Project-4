package database;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import resume.Address;
import resume.Education;
import resume.ResumeObject;
import resume.Skills;
import resume.User;
import resume.Work;
//import weatherApplicationComponent.Observation;

public class DBSelectorObject {
	Statement stmt;
	Connection c;
	
	public DBSelectorObject(Statement stmt, Connection c){
		this.stmt = stmt;
		this.c = c;
	}

	public ArrayList<User> getAllKnownUsers() throws SQLException, ClassNotFoundException, IOException{
		ArrayList<ResumeObject> returned = (ArrayList<ResumeObject>) deserializeObjectsInTable("PERSONALDATA", "User");
		ArrayList<User> toReturn = new ArrayList<User>();
		for(ResumeObject rso : returned){
			toReturn.add((User) rso);
		}
		return toReturn;
	}
	
	public ArrayList<Work> getAllKnownWorkExpr() throws SQLException, ClassNotFoundException, IOException{
		ArrayList<ResumeObject> returned = (ArrayList<ResumeObject>) deserializeObjectsInTable("EXPERIENCEDATA", "Work");
		ArrayList<Work> toReturn = new ArrayList<Work>();
		for(ResumeObject rso : returned){
			toReturn.add((Work) rso);
		}
		return toReturn;
	}


	public ArrayList<Skills> getAllKnownSkills() throws ClassNotFoundException, IOException, SQLException{
		ArrayList<ResumeObject> returned = (ArrayList<ResumeObject>) deserializeObjectsInTable("SKILLSDATA", "Skills");
		ArrayList<Skills> toReturn = new ArrayList<Skills>();
		for(ResumeObject rso : returned){
			toReturn.add((Skills) rso);
		}
		return toReturn;
	}



	//TO DO
	public ArrayList<Education> getAllKnownEducation() throws ClassNotFoundException, IOException, SQLException{
		ArrayList<ResumeObject> returned = (ArrayList<ResumeObject>) deserializeObjectsInTable("EDUCATIONDATA", "Education");
		ArrayList<Education> toReturn = new ArrayList<Education>();
		for(ResumeObject rso : returned){
			toReturn.add((Education) rso);
		}
		return toReturn;
	}
	
	public ArrayList<ResumeObject> deserializeObjectsInTable(String table, String objColumnName) throws IOException, SQLException, ClassNotFoundException {
		stmt = c.createStatement();
		String query = String.format("SELECT * FROM  %s;", table);
		ArrayList<ResumeObject> toReturn = new ArrayList<ResumeObject>();		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes(objColumnName));
			ObjectInputStream ois = new ObjectInputStream(bais);
			ResumeObject obsObj = (ResumeObject) ois.readObject();
			toReturn.add(obsObj);
		}
		
		return toReturn;
	}

}
