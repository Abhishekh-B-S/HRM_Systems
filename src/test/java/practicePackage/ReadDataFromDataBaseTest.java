package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBaseTest {

	public static void main(String[] args) throws Throwable {
		
		Driver driver = new Driver();
		// step 1: register the database
		DriverManager.registerDriver(driver);
		
		// step 2: get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/practicety","root","root");
		
		// step 3: issue create statement
		 Statement stat = con.createStatement();
		 String query="select * from sdet43";
		
		// step 4: execute story
		 ResultSet result=stat.executeQuery(query);
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3));
		 }
		
		// step 5: close database connection
		 con.close();

	}

}
