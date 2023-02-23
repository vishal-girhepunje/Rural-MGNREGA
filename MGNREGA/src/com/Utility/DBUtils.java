package com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
public static Connection ProvideConnection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		String url="jdbc:mysql://localhost/mgnrega";	
		try {
			con=DriverManager.getConnection(url,"root","6809");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
}
