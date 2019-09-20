package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.testng.annotations.Test;


public class JDBCConnection {
	String[][] table=new String[1][2];
	HashMap<String,String> hs =new HashMap<String,String>();
	ResultSet rs;
		String host = "localhost";
		String port="3306";
	public  void connect() throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/hello", "root", "3114");
		Statement s = conn.createStatement();
		rs= s.executeQuery("select * from UserDetails");
	}
		
	public String[][] getUserDetails() throws SQLException {
		connect();
		while(rs.next()) {
			table[0][0]  = rs.getString("username");
			table[0][1]  = rs.getString("password");
	}
		return table;
	}
	
	@Test
	public void test() throws SQLException {
		connect();
		while(rs.next()) {
			hs.put(rs.getString("username"), rs.getString("password"));
		}
		System.out.println(hs);
	}
	
}
