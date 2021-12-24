package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class DepartmentsDao {
	public void insertDep(Departments dprt) 
	
	{	
		String insertQuery="insert into departments  values (?,?,?)";
		Connection con=ConnectionUtil.dbConnect();
		try {
			int gradID=GradeDao.findGradeID(dprt.getGrd());

			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(1, dprt.getDeptId());
			pstmt.setString(2, dprt.getDeptName());
			pstmt.setInt(3,gradID);
			
			pstmt.executeUpdate();
			System.out.println("Department Inserted Successfully");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Department not Inserted successfully");
		}
		
		
		}
	
	
	public static int findDepartmentID(Departments dept)
	{
		int grdID=GradeDao.findGradeID(dept.getGrd());
		String findId="select dept_id from departments where dept_name = '"+dept.getDeptName()+"' and grade_id ="+grdID;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return id;
	}
	public void updateDept(int deptId,String deptName)
	{
		String insertQuery = "update departments set dept_name=? where dept_id=?";
		Connection con = ConnectionUtil.dbConnect();
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1,deptName);
			pstmt.setLong(2, deptId);
			pstmt.executeUpdate();
			System.out.println("Department Updated Successfully");

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Department not updated properly");
		}
	}
	public boolean deleteDept(int  deptId)
	{
		String deleteQuery = "delete from departments where dept_id=?";
		Connection con = ConnectionUtil.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {
			

			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, deptId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
		}
		return result;
	}
	public List<Departments> showDepartments()
	{
		List<Departments> departmentList=new ArrayList<Departments>();
		
		String showQuery="select * from Departments";
		Connection con=ConnectionUtil.dbConnect();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
			 Grade grde=GradeDao.findGrade(rs.getInt(3));
				Departments department=new Departments(rs.getInt(1),rs.getString(2),grde);
				departmentList.add(department);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departmentList;
	}
	public static Departments	findDepartment(int id)
	{
		String query="select * from departments where dept_id="+id;
		Connection con=ConnectionUtil.dbConnect();
		Departments depart=null;
//		int grdId=GradeDao.findGradeID(grade);
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println(rs.getInt(3));
				Grade grade=GradeDao.findGrade(rs.getInt(3));
				
				depart=new Departments(rs.getInt(1),rs.getString(2),grade);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
		
	}
	public static Departments	findDepartment(String deptName)
	{
		String query="select * from departments where dept_name= '"+deptName+"'";
		Connection con=ConnectionUtil.dbConnect();
		Departments depart=null;
//		int grdId=GradeDao.findGradeID(grade);
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
//				System.out.println(rs.getInt(3));
				Grade grade=GradeDao.findGrade(rs.getInt(3));
				
				depart=new Departments(rs.getInt(1),rs.getString(2),grade);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
		
	}
	
	
	

}
