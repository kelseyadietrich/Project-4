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
import java.util.Map;

import resume.Address;
import resume.Education;
import resume.Skills;
import resume.User;
import resume.Work;
import weatherApplicationComponent.Observation;


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
            + "Address         BLOB            NOT NULL,"
            + "AdditionalInfo  VARCHAR(255)    NULL);";
	
	
	String createExprDataTableQuery = "CREATE TABLE IF NOT EXISTS EXPERIENCEDATA "
            + "(ExperienceID INT PRIMARY KEY           NOT NULL,"
            + "JobTitle            VARCHAR(255)        NOT NULL,"
            + "Employer            VARCHAR(255)        NOT NULL,"
            + "StDate              VARCHAR(255)        NOT NULL,"
            + "EnDate              VARCHAR(255)        NOT NULL,"
            + "StillGo             BOOLEAN             NOT NULL,"
            + "Description         VARCHAR(255)        NULL,"
            + "PersonalIDExpr INT              ,"
            + "FOREIGN KEY (PersonalIDExpr) REFERENCES PERSONALDATA (PersonalID));";
	
	
	String createEducDataTableQuery = "CREATE TABLE IF NOT EXISTS EDUCATIONDATA "
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
	
	
	String createSkillsDataQuery = "CREATE TABLE IF NOT EXISTS SKILLSDATA "
            + "(SkillsEntryID  INT PRIMARY KEY  NOT NULL,"
            + "Skill1          String          NOT NULL,"
            + "PersonalIDSkill INT              ,"
            + "FOREIGN KEY (PersonalIDSkill) REFERENCES PERSONALDATA (PersonalID));";
	
	public CVDataBase(){
		stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:resumeData.db");
			//setUp();
		} catch ( Exception e ) {
			c = null;
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println(this.getClass());
		    System.exit(0);
		}
	}
	
	int getPersonalID(){
		return this.personalIDCount;
	}
  
	
	public void deleteAll() throws SQLException {
		stmt = c.createStatement();
		String deleteQuery = "DELETE FROM WEATHERDATA";
		stmt.executeUpdate(deleteQuery);
	}
	
	public void createTableFromStr(String str)  throws SQLException{
		stmt = c.createStatement();
		stmt.executeUpdate(str);
		
	}
	
	public void clear() throws SQLException{
		stmt = c.createStatement();
		String dropQuery = 
				"DROP TABLE IF EXISTS EDUCATIONDATA;"
				+ "DROP TABLE IF EXISTS SKILLSDATA;"
				+ "DROP TABLE IF EXISTS EXPERIENCEDATA;"
				+ "DROP TABLE IF EXISTS PERSONALDATA;";
		stmt.executeUpdate(dropQuery);
		
	
	}
	
	public void setUp() throws SQLException{
		clear();
		createTableFromStr(createPrsnlDataTableQuery);
		createTableFromStr(createExprDataTableQuery);
		createTableFromStr(createEducDataTableQuery);
		createTableFromStr(createSkillsDataQuery);
		
	}
	
	public void insertPrsnlEntry(User u) throws SQLException, IOException{
		stmt = c.createStatement();
		String name = u.getName();
		String email = u.getEmail();
		String phone = u.getPhone();
		Address address = u.getAddress();
		String addInfo = u.getAdditional();
		PreparedStatement pstmt = 
				c.prepareStatement("INSERT INTO PERSONALDATA VALUES (?, ?, ?, ?, ?, ?);");
		pstmt.setInt(1, getPersonalID());
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setString(4, phone);
		pstmt.setObject(5, serializeObject(address));
		pstmt.setString(6, addInfo);
		
		pstmt.executeUpdate();
		personalIDCount += 1;
		
		
		
	}
	
	public void insertWorkEntry(Work w) throws SQLException{
		stmt = c.createStatement();
		String title = w.getTitle();
		String employer = w.getEmployer();
		String stDate = w.getStart();
		String endDate = w.getEnd();
		String description = w.getDescrip();
		boolean stillworks = w.stillWorks();
		PreparedStatement pstmt =
				c.prepareStatement("INSERT INTO EXPERIENCEDATA VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
		pstmt.setInt(1, exprIDCount);
		pstmt.setString(2, title);
		pstmt.setString(3, employer);
		pstmt.setString(4, stDate);
		pstmt.setString(5, endDate);
		pstmt.setBoolean(6, stillworks);
		pstmt.setString(7, description);
		pstmt.setInt(8, getPersonalID());
		pstmt.executeUpdate();
		exprIDCount += 1;
	}
	
	
	public void insertEducEntry(Education e) throws SQLException, IOException{
		stmt = c.createStatement();
		String school = e.getSchool();
		Address address = e.getAddress();
		String stDate = e.getStart();
		String endDate = e.getEnd();
		String degree = e.getDegree();
		String additionalInfo = e.getAdditional();
		String major = e.getMajor();
		String minor = e.getMinor();
		boolean stillgoes = e.stillGoes();
		PreparedStatement pstmt = 
				c.prepareStatement("INSERT INTO EDUCATIONDATA VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		pstmt.setInt(1,  educIDCount);
		pstmt.setString(2, school);
		pstmt.setObject(3,  serializeObject(address));
		pstmt.setString(4,  stDate);
		pstmt.setString(5,  endDate);
		pstmt.setBoolean(6,  stillgoes);
		pstmt.setString(7, degree);
		pstmt.setString(8, major);
		pstmt.setString(9, minor);
		pstmt.setString(10, additionalInfo);
		pstmt.setInt(11, getPersonalID());
		pstmt.executeUpdate();
		educIDCount += 1;
		
	}
	
	public void insertSkillEntries(Skills skillList) throws SQLException{
		PreparedStatement pstmt = c.prepareStatement("INSERT INTO SKILLSDATA VALUES (?,?,?);");
	    ArrayList<Map.Entry<String, String>> skills = new ArrayList<>(skillList.getSkillAndDesc().entrySet());
	    stmt = c.createStatement();
	    for(Map.Entry<String, String> item : skills){
	    	String sk = item.getKey();
	    	String desc = item.getValue();
	    	pstmt.setInt(1, skillEntryID);
	    	pstmt.setString(2, sk);
	    	pstmt.setInt(3,  getPersonalID());
	    	pstmt.executeUpdate();
	    	skillEntryID += 1;
	    	
	    }
		
	}
	
	public byte[] serializeObject(Address obs) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obs);
		oos.flush();
		oos.close();
		baos.close();
		return baos.toByteArray();
	}
	
	
	//TO DO
	public ArrayList<User> getAllKnownUsers() throws SQLException{
		stmt = c.createStatement();
		
		ArrayList<String> names = new ArrayList<>();
		String query = "SELECT Name FROM PERSONALDATA Order by id;";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			names.add(rs.getString(1));
		}
		//return names;
		
		
		return null;
	}
	
	//TO DO 
	public ArrayList<Work> getAllKnownWorkExpr(){
		return null;
	}
	
	//TO DO 
	public ArrayList<Skills> getAllKnownSkills(){
		return null;
	}
	
	
	//TO DO
	public ArrayList<Education> getAllKnownEducation(){
		return null;
	}
	
	
//	public Address deserializeObject(long primaryKey) throws IOException, SQLException, ClassNotFoundException {
//		stmt = c.createStatement();
//		String query = String.format("SELECT OBJECT FROM WEATHERDATA WHERE ID = %d;",
//				primaryKey);
//		ResultSet rs = stmt.executeQuery(query);
//		ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes("OBJECT"));
//		ObjectInputStream ois = new ObjectInputStream(bais);
//		Address obsObj = (Address) ois.readObject();
//		ois.close();
//		bais.close();
//		return obsObj;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
