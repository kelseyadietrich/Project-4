package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetUpObject {
	
	private String createPrsnlDataTableQuery;
	private String createExprDataTableQuery;
	private String createEducDataTableQuery;
	private String createSkillsDataQuery;
	
	public DBSetUpObject(){
		
		this.createPrsnlDataTableQuery = "CREATE TABLE IF NOT EXISTS PERSONALDATA "
	            + "(PersonalID INT PRIMARY KEY     NOT NULL,"
	            + "User BLOB NOT NULL;)";
		
		this.createExprDataTableQuery = "CREATE TABLE IF NOT EXISTS EXPERIENCEDATA "
	            + "(ExperienceID INT PRIMARY KEY           NOT NULL,"
	            + "Work BLOB NOT NULL,"
	            + "PersonalIDExpr INT              ,"
	            + "FOREIGN KEY (PersonalIDExpr) REFERENCES PERSONALDATA (PersonalID));";
		
		this.createEducDataTableQuery = "CREATE TABLE IF NOT EXISTS EDUCATIONDATA "
	            + "(EducItemID INT PRIMARY KEY         NOT NULL,"
	            + "Education BLOB NOT NULL"
	            + "PersonalIDEduc INT              ,"
	            + "FOREIGN KEY (PersonalIDEduc) REFERENCES PERSONALDATA (PersonalID));";
		
		this.createSkillsDataQuery = "CREATE TABLE IF NOT EXISTS SKILLSDATA "
	            + "(SkillsEntryID  INT PRIMARY KEY  NOT NULL,"
	            + "Skills          BLOB          NOT NULL,"
	            + "PersonalIDSkill INT              ,"
	            + "FOREIGN KEY (PersonalIDSkill) REFERENCES PERSONALDATA (PersonalID));";
		
		
	}

	public String getCreatePrsnlDataTableQuery() {
		return createPrsnlDataTableQuery;
	}

	public void setCreatePrsnlDataTableQuery(String createPrsnlDataTableQuery) {
		this.createPrsnlDataTableQuery = createPrsnlDataTableQuery;
	}

	public String getCreateExprDataTableQuery() {
		return createExprDataTableQuery;
	}

	public void setCreateExprDataTableQuery(String createExprDataTableQuery) {
		this.createExprDataTableQuery = createExprDataTableQuery;
	}

	public String getCreateEducDataTableQuery() {
		return createEducDataTableQuery;
	}

	public void setCreateEducDataTableQuery(String createEducDataTableQuery) {
		this.createEducDataTableQuery = createEducDataTableQuery;
	}

	public String getCreateSkillsDataQuery() {
		return createSkillsDataQuery;
	}

	public void setCreateSkillsDataQuery(String createSkillsDataQuery) {
		this.createSkillsDataQuery = createSkillsDataQuery;
	}
	
	
	public void createTableFromStr(String str, Statement stmt, Connection c)  throws SQLException{
		stmt = c.createStatement();
		stmt.executeUpdate(str);
		
	}
	
	public void clear(Statement stmt, Connection c) throws SQLException{
		stmt = c.createStatement();
		String dropQuery = 
				"DROP TABLE IF EXISTS EDUCATIONDATA;"
				+ "DROP TABLE IF EXISTS SKILLSDATA;"
				+ "DROP TABLE IF EXISTS EXPERIENCEDATA;"
				+ "DROP TABLE IF EXISTS PERSONALDATA;";
		stmt.executeUpdate(dropQuery);
		
	
	}
	
	public void setUpWith(Statement stmt, Connection c) throws SQLException{
		clear(stmt, c);
		createTableFromStr(createPrsnlDataTableQuery, stmt, c);
		createTableFromStr(createExprDataTableQuery, stmt, c);
		createTableFromStr(createEducDataTableQuery, stmt, c);
		createTableFromStr(createSkillsDataQuery, stmt, c);
		
	}
	

}
