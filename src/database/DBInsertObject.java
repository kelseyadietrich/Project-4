package database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import resume.Education;
import resume.ResumeObject;
import resume.Skills;
import resume.User;
import resume.Work;

public class DBInsertObject {
	Statement stmt;
	Connection c;
	int personalIDCount;
	int exprIDCount;
	int educIDCount;
	int skillEntryID;


	public DBInsertObject(Statement stmt, Connection c){
		this.stmt = stmt;
		this.c = c;
		this.personalIDCount = 0;
		this.exprIDCount = 0;
		this.educIDCount = 0;
		this.skillEntryID = 0;
	}

	int getPersonalID(){
		return this.personalIDCount;
	}

	public void insertPrsnlEntry(User u) throws SQLException, IOException{
		System.out.println("Inserting Personal Entry");
		this.stmt = this.c.createStatement();
		PreparedStatement pstmt =
				this.c.prepareStatement("INSERT INTO PERSONALDATA VALUES (?, ?);");
		pstmt.setInt(1, getPersonalID());
		pstmt.setObject(2, serializeObject(u));
		pstmt.executeUpdate();
		this.personalIDCount += 1;
	}

	public void insertWorkEntry(Work w) throws SQLException, IOException{
		System.out.println("Inserting Work Entry.");
		this.stmt = this.c.createStatement();
		PreparedStatement pstmt =
				this.c.prepareStatement("INSERT INTO EXPERIENCEDATA VALUES (?, ?, ?);");
		pstmt.setInt(1, exprIDCount);
		pstmt.setObject(2, serializeObject(w));
		pstmt.setInt(3, getPersonalID());
		pstmt.executeUpdate();
		this.exprIDCount += 1;
	}


	public void insertEducEntry(Education e) throws SQLException, IOException{
		System.out.println("Inserting Education Entry.");
		this.stmt = c.createStatement();
		PreparedStatement pstmt =
				this.c.prepareStatement("INSERT INTO EDUCATIONDATA VALUES (?, ?, ?);");
		pstmt.setInt(1,  educIDCount);
		pstmt.setObject(2, serializeObject(e));
		pstmt.setInt(3, getPersonalID());
		pstmt.executeUpdate();
		this.educIDCount += 1;

	}

	public void insertSkillEntries(Skills skillList) throws SQLException, IOException{
		System.out.println("Inserting skills.");
		PreparedStatement pstmt = this.c.prepareStatement("INSERT INTO SKILLSDATA VALUES (?,?,?);");
	    pstmt.setInt(1, this.skillEntryID);
	    pstmt.setObject(2, serializeObject(skillList));
	    pstmt.setInt(3,  getPersonalID());
	    pstmt.executeUpdate();
	    this.skillEntryID += 1;

	}

	public byte[] serializeObject(ResumeObject obs) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obs);
		oos.flush();
		oos.close();
		baos.close();
		return baos.toByteArray();
	}


}
