package database;

import java.io.IOException;
import java.sql.SQLException;

import resume.Address;
import resume.Education;
import resume.Skills;
import resume.User;
import resume.Work;

public class DbMain {
	public static void main(String[] args){
		CVDataBase cvdb = new CVDataBase();
		
		Address testAddress = new Address("1600 Washington ave", "Hutt 17", "Conway", "AR", "72032");
		User testUser = new User("Bosco", "ndemeyemm@hendrix.edu", "501-514-8388", testAddress, "Lorem ipsum dolor sit");
		Education testEd = new Education("Hendrix college", testAddress, "jan-01-2014"
				, "may-05-2018", "Bachelor's", "Lorem ipsum dolor sit", true, "Computer Science", "Applied Math");
		Work testWork = new Work("CS Tutor", "Hendrix Math department", "aug-07-2016"
				, "May-15-2017", "Lorem ipsum dolor sit", false);
		Skills testSkills = new Skills();
		testSkills.add("soccer", "player freshman year!");
		
		
		try {
			cvdb.setUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cvdb.insertPrsnlEntry(testUser);
			cvdb.insertEducEntry(testEd);
			cvdb.insertSkillEntries(testSkills);
			cvdb.insertWorkEntry(testWork);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
