package database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import resume.Address;
import resume.Education;
import resume.Skills;
import resume.User;
import resume.Work;


public class CVDataBase {
	Connection c;
	Statement stmt;
	DBSetUpObject sqlStmt;
	DBInsertObject sqlInsertStmt;
	DBSelectorObject sqlSelectStmt;
	
	

	public CVDataBase(){
		this.stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection("jdbc:sqlite:resumeData.db");
			this.sqlStmt = new DBSetUpObject();
			this.sqlInsertStmt = new DBInsertObject(stmt, c);
			this.sqlSelectStmt = new DBSelectorObject(stmt, c);
			//setUp();
		} catch ( Exception e ) {
			c = null;
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println(this.getClass());
		    System.exit(0);
		}
	}

	public void setUp() throws SQLException{
		this.sqlStmt.setUpWith(this.stmt, this.c);

	}

	//inserts
	public void insertPrsnlEntry(User u) throws SQLException, IOException{
		this.sqlInsertStmt.insertPrsnlEntry(u);
	}

	public void insertWorkEntry(Work w) throws SQLException, IOException{
		this.sqlInsertStmt.insertWorkEntry(w);
	}


	public void insertEducEntry(Education e) throws SQLException, IOException{
		this.sqlInsertStmt.insertEducEntry(e);

	}

	public void insertSkillEntries(Skills skillList) throws SQLException, IOException{
		this.sqlInsertStmt.insertSkillEntries(skillList);
	}
	
	//retrievals
	public ArrayList<User> getPersonalData() throws ClassNotFoundException, SQLException, IOException{
		return this.sqlSelectStmt.getAllKnownUsers();
	}
	
	public ArrayList<Work> getExperienceData() throws ClassNotFoundException, SQLException, IOException{
		return this.sqlSelectStmt.getAllKnownWorkExpr();
	}
	
	public ArrayList<Education> getEducationData() throws ClassNotFoundException, IOException, SQLException{
		return this.sqlSelectStmt.getAllKnownEducation();
	}
	
	public ArrayList<Skills> getSkillsData() throws ClassNotFoundException, IOException, SQLException{
		return this.sqlSelectStmt.getAllKnownSkills();
	}
	


















}
