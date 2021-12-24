package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class GradeDao {
	public boolean insertGrade(Grade grade) 
	{	boolean result=false;
		String insertQuery="insert into Grades (grade_name,grade_basic,grade_bonus,grade_pf,grade_pt) values (?,?,?,?,?)";
		Connection con=ConnectionUtil.dbConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			
			pstmt.setString(1, grade.getGradeName());
			pstmt.setLong(2, grade.getGradeBasic());
			pstmt.setLong(3, grade.getGradeBonus());
			pstmt.setLong(4, grade.getGradePf());
			pstmt.setLong(5, grade.getGradePt());
			
			pstmt.executeQuery();
			result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
		}
	public static int findGradeID(Grade grade)
	{
		String findId="select grade_id from grades where grade_name= '"+grade.getGradeName()+"'";
		Connection con=ConnectionUtil.dbConnect();
		Statement stmt;
		int id = 0;
		try {
			stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery(findId);
			while(rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return id;
	}
	
	
	public boolean updateGrade(Long basic,Long bonus,Long pf,Long pt,String gdName)
	{
		String updateQuery = "update  grades set grade_basic=?,grade_bonus=?,grade_pf=?,grade_pt=? where grade_name=?";
		Connection con = ConnectionUtil.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(updateQuery);
			pstmt.setLong(1,basic);
			pstmt.setLong(2, bonus);
			pstmt.setLong(3, pf);
			pstmt.setLong(4, pt);
			pstmt.setString(5, gdName);
			pstmt.executeUpdate();
			result=true;

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
		}
		return result;
	}
	public boolean deleteGrade(int  gradeId)
	{
		String deleteQuery = "delete from Grades where grade_id=?";
		Connection con = ConnectionUtil.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {
			

			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, gradeId);
			pstmt.executeUpdate();
			System.out.println("Grade Deleted Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Grade not Deleted properly");
		}
		return result;
	}
	public List<Grade> showGrade()
	{
		List<Grade> gradeList=new ArrayList<Grade>();
		
		String showQuery="select * from grades";
		Connection con=ConnectionUtil.dbConnect();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Grade grade=new Grade( rs.getString(2), rs.getLong(3), rs.getLong(4),rs.getLong(5),rs.getLong(6));
				gradeList.add(grade);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gradeList;
	}
	public static Long grossSalary(String grdName) {
		
		String qry="select (grade_basic + grade_bonus + grade_pt + grade_pf) gross from grades where grade_name = '"+grdName+"'";
		Connection con=ConnectionUtil.dbConnect();
		Statement stmt;
		Long grossSalary=null;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			if(rs.next()) {
				grossSalary=rs.getLong(1);
//				System.out.println("Gross salary"+grossSalary);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grossSalary;
		
	}
	
	public static Grade findGrade(int gradeId) {
		String qry="select * from grades where grade_id="+gradeId;
		Connection con=ConnectionUtil.dbConnect();
		Grade grd=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next()) {
				 grd=new Grade(rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return grd;
		
	}
	public static Grade findGrade(String gradeName) {
		
		String qry="select * from grades where grade_name = '"+gradeName+"'";
		Connection con=ConnectionUtil.dbConnect();
		Grade grd=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next()) {
				 grd=new Grade(rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return grd;
		
	}
	public static long perDaySalary(String gradeName) {
		String query="select (grade_basic/30)perDaySalary from grades where grade_name = '"+gradeName+"'";
		long perDaySalary=0;
		Connection con=ConnectionUtil.dbConnect();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				perDaySalary=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return perDaySalary ;
	}
	public static long basicSalary(String gradeName) {
		String query="select grade_basic from grades where grade_name = '"+gradeName+"'";
		long basicSalary=0;
		Connection con=ConnectionUtil.dbConnect();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				basicSalary=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return basicSalary ;
	}
	public static long bonus(String gradeName) {
		String query="select grade_bonus from grades where grade_name = '"+gradeName+"'";
		long gradeBonus=0;
		Connection con=ConnectionUtil.dbConnect();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				gradeBonus=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gradeBonus ;
	}
	public static long providentFund(String gradeName) {
		String query="select grade_pf from grades where grade_name = '"+gradeName+"'";
		long providentFund=0;
		Connection con=ConnectionUtil.dbConnect();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				providentFund=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return providentFund ;
	}
	public static long professionalTax(String gradeName) {
		String query="select grade_pt from grades where grade_name = '"+gradeName+"'";
		long professionalTax=0;
		Connection con=ConnectionUtil.dbConnect();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				professionalTax=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return professionalTax ;
	}
	
	
	
}
