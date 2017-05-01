package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetUpStatements {
	
	private String createPrsnlDataTableQuery;
	private String createExprDataTableQuery;
	private String createEducDataTableQuery;
	private String createSkillsDataQuery;
	
	public DBSetUpStatements(){
		
		this.createPrsnlDataTableQuery = "CREATE TABLE IF NOT EXISTS PERSONALDATA "
	            + "(PersonalID INT PRIMARY KEY     NOT NULL,"
	            + "Name            VARCHAR(255)    NOT NULL,"
	            + "Email           VARCHAR(255)    NOT NULL,"
	            + "Phone           VARCHAR(255)    NOT NULL,"
	            + "Address         BLOB            NOT NULL,"
	            + "AdditionalInfo  VARCHAR(255)    NULL);";
		
		this.createExprDataTableQuery = "CREATE TABLE IF NOT EXISTS EXPERIENCEDATA "
	            + "(ExperienceID INT PRIMARY KEY           NOT NULL,"
	            + "JobTitle            VARCHAR(255)        NOT NULL,"
	            + "Employer            VARCHAR(255)        NOT NULL,"
	            + "StDate              VARCHAR(255)        NOT NULL,"
	            + "EnDate              VARCHAR(255)        NOT NULL,"
	            + "StillGo             BOOLEAN             NOT NULL,"
	            + "Description         VARCHAR(255)        NULL,"
	            + "PersonalIDExpr INT              ,"
	            + "FOREIGN KEY (PersonalIDExpr) REFERENCES PERSONALDATA (PersonalID));";
		
		this.createEducDataTableQuery = "CREATE TABLE IF NOT EXISTS EDUCATIONDATA "
	            + "(EducItemID INT PRIMARY KEY         NOT NULL,"
	            + "Institution       VARCHAR(255)      NOT NULL,"
	            + "Address           BLOB              NOT NULL,"
	            + "StDate            VARCHAR(255)      NOT NULL,"
	            + "EndDate           VARCHAR(255)      NOT NULL,"
	            + "StillGo           BOOLEAN           NOT NULL,"
	            + "Degree            VARCHAR(255)      NOT NULL,"
	            + "Major             VARCHAR(255)      NOT NULL,"
	            + "Minor             VARCHAR(255)      NULL,"
	            + "AdditionalInfo    VARCHAR(255)      NOT NULL,"
	            + "PersonalIDEduc INT              ,"
	            + "FOREIGN KEY (PersonalIDEduc) REFERENCES PERSONALDATA (PersonalID));";
		
		this.createSkillsDataQuery = "CREATE TABLE IF NOT EXISTS SKILLSDATA "
	            + "(SkillsEntryID  INT PRIMARY KEY  NOT NULL,"
	            + "Skill          String          NOT NULL,"
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
