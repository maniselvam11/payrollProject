package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection dbConnect() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			
			con=DriverManager.getConnection(url,"system","oracle");
			}
		
			catch (SQLException e) {
				e.getMessage();
				System.out.println("url or username or password may wrong");

			}
		 
		catch (ClassNotFoundException e) {
			e.getMessage();
			System.out.println("Driver jar does not there");
		
		}
		return con;
		
		
		
	}

}
