package com.payroll.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.payroll.model.Admin;

public class AdminDao {
	
	public Admin validateAdmin(String emailId,String password) {
		
		String query="select * from admin_details where email_id = '"+emailId+"' and "
				+ "password = '"+password+"'" ;
		Connection con=ConnectionUtil.dbConnect();
		Admin user=null;
		
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				user=new Admin(emailId,password);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query not executed correctly");
		}
		return user  ;
		
		
	}

}
