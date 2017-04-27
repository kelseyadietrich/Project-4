package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import resume.Education;
import resume.User;
import resume.Work;

public class CVDataBase {
	Connection c;
	Statement stmt;
	
	int personalIDCount = 0;
	int exprIDCount = 0;
	int educIDCount = 0;
	int skillEntryID = 0;
	
	
	String createPrsnlDataTableQuery = "CREATE TABLE IF NOT EXISTS PERSONALDATA "
            + "(PersonalID INT PRIMARY KEY     NOT NULL,"
            + "Name            VARCHAR(255)    NOT NULL,"
            + "Email           VARCHAR(255)    NOT NULL,"
            + "Phone           VARCHAR(255)    NOT NULL,"
            + "Address         VARCHAR(255)    NOT NULL,"
            + "POBox           INT             NOT NULL,"
            + "City            VARCHAR(255)    NOT NULL,"
            + "State           VARCHAR(255)    NOT NULL,"
            + "Zip             INT     NOT NULL"
            + "AdditionalInfo  VARCHAR(255)    NULL)";
	
	
	String createExprDataTableQuery = "CREATE TABLE IF NOT EXISTS EXPRERIENCEDATA "
            + "(ExperienceID INT PRIMARY KEY           NOT NULL,"
            + "JobTitle            VARCHAR(255)        NOT NULL,"
            + "Employer            VARCHAR(255)        NOT NULL,"
            + "StDate              VARCHAR(255)        NOT NULL,"
            + "EnDate              VARCHAR(255)        NOT NULL,"
            + "StillGo             BOOLEAN             NOT NULL,"
            + "Description         VARCHAR(255)        NULL,"
            + "FOREIGN KEY (PersonalID) REFERENCES PERSONALDATA (PersonalID))";
	
	
	String createEducDataTableQuery = "CREATE TABLE IF NOT EXISTS EDUCATIONDATA "
            + "(EducItemID INT PRIMARY KEY         NOT NULL,"
            + "Institution       VARCHAR(255)      NOT NULL,"
            + "Address           VARCHAR(255)      NOT NULL,"
            + "POBox             VARCHAR(255)      NOT NULL,"
            + "City              VARCHAR(255)      NOT NULL,"
            + "State             BOOLEAN           NOT NULL,"
            + "Zip               VARCHAR(255)      NULL,"
            + "StDate            VARCHAR(255)      NOT NULL,"
            + "EndDate           VARCHAR(255)      NOT NULL,"
            + "StillGo           BOOLEAN           NOT NULL,"
            + "Degree            VARCHAR(255)      NOT NULL,"
            + "Major             VARCHAR(255)      NOT NULL,"
            + "Minor             VARCHAR(255)      NULL,"
            + "AdditionalInof    VARCHAR(255)      NOT NULL,"
            + "FOREIGN KEY (PersonalID) REFERENCES PERSONALDATA (PersonalID))";
	
	
	String createSkillsDataQuery = "CREATE TABLE IF NOT EXISTS SKILLSDATA "
            + "(SkillsEntryID  INT PRIMARY KEY  NOT NULL,"
            + "Skill1          BOOLEAN          NOT NULL,"
            + "Skill2          BOOLEAN          NOT NULL,"
            + "Skill3          BOOLEAN          NOT NULL,"
            + "Skill4          BOOLEAN          NOT NULL,"
            + "Skill5          BOOLEAN          NOT NULL,"
            + "Skill6          BOOLEAN          NOT NULL,"
            + "Skill7          BOOLEAN          NOT NULL,"
            + "FOREIGN KEY (PersonalID) REFERENCES PERSONALDATA (PersonalID))";
	
	public CVDataBase(){
		stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:resumeData.db");
		} catch ( Exception e ) {
			c = null;
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println(this.getClass());
		    System.exit(0);
		}
	}
	
	int getPersonalID(User u){
		int toReturn = this.personalIDCount;
		this.personalIDCount += 1;
		return toReturn;
	}
	
	int getExprID(Work u){
		int toReturn = this.exprIDCount;
		this.exprIDCount += 1;
		return toReturn;
	}
	
	int geteducID(Education e){
		int toReturn = this.educIDCount;
		this.educIDCount += 1;
		return toReturn;
	}
	
//	int getskillsID(Skill u){
//		int toReturn = this.skillEntryID;
//		this.skillEntryID += 1;
//		return toReturn;
//	}
	
	
	
	
	public void createTableFromStr(String str)  throws SQLException{
		stmt = c.createStatement();
		stmt.executeQuery(str);
		
	}
	
	public void setUp() throws SQLException{
		createTableFromStr(createPrsnlDataTableQuery);
		createTableFromStr(createExprDataTableQuery);
		createTableFromStr(createEducDataTableQuery);
		createTableFromStr(createSkillsDataQuery);
		
	}
	
	public void insertWorkEntry(Work w, User u) throws SQLException{
		stmt = c.createStatement();
		String title = w.getTitle();
		String employer = w.getEmployer();
		String stDate = w.getStart();
		String endDate = w.getEnd();
		String description = w.getDescrip();
		boolean stillworks = w.stillWorks();
		String query = "INSERT INTO EXPERIENCEDATA"
				     + "VALUES (" + title + ","
				     + employer + ","
				     + stDate   + ","
				     + endDate  + ","
				     + stillworks + ","
				     + description + ","
				     + getPersonalID(u) + ")";
		stmt.executeQuery(query);
	}
	
	//similar to previous : Maybe use Bifunctor to reduce lines of code? : )
	
	public void insertEducEntry(Education e, User u) throws SQLException{
		stmt = c.createStatement();
		String school = e.getSchool();
		String address = e.getAddress();
		String stDate = e.getStart();
		String endDate = e.getEnd();
		String degree = e.getDegree();
		String additionalInfo = e.getAdditional();
		String major = e.getMajor();
		String minor = e.getMinor();
		boolean stillgoes = e.stillGoes();
		String query = ""; //tocontinue;
		stmt.executeQuery(query);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
