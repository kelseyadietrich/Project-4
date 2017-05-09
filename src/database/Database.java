package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Database {
	public void sendCommand(String s) throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:Resumes.db");
        Statement stat = con.createStatement();
        System.out.println(s);
        stat.execute(s);
        con.close();
	}

    public void main() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:Resumes.db");
        Statement stat = con.createStatement();
        stat.execute("DROP TABLE IF EXISTS Personal");
        stat.execute("DROP TABLE IF EXISTS Work");
        stat.execute("DROP TABLE IF EXISTS Education");
        stat.execute("DROP TABLE IF EXISTS Skills");
        stat.execute("CREATE TABLE Personal (ResID INTEGER, Name TEXT, Email TEXT, Phone TEXT, Street TEXT, Apt TEXT, City TEXT, State TEXT, Zip TEXT, Additional TEXT)");
        stat.execute("CREATE TABLE Work (ResID INTEGER, Job TEXT, Employer TEXT, Start TEXT, End TEXT, Current BOOLEAN, Additional TEXT)");
        stat.execute("CREATE TABLE Education (ResID INTEGER, School TEXT, Start TEXT, End TEXT, Current BOOLEAN, Degree TEXT, Major TEXT, Minor TEXT, Additional TEXT)");
        stat.execute("CREATE TABLE Skills (ResID INTEGER, Skill TEXT)");
    }
}
