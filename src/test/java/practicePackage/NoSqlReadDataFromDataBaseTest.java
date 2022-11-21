package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSqlReadDataFromDataBaseTest {

	public static void main(String[] args) throws Throwable {
		
		
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/practicety","root", "root");
		Statement stat = con.createStatement();
		String query= "insert into sdet43(st_rollnumber,st_name,course,duration) values(04,'asd','IS',4)";
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("one row added");
			
		}	
		else
		{
			System.out.println("no new rows added");
		}
		con.close();
	}

	
}


