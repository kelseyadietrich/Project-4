package database;

import java.sql.SQLException;

public class DbMain {
	public static void main(String[] args){
		CVDataBase cvdb = new CVDataBase();
		try {
			cvdb.setUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
