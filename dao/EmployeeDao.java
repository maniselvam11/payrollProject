package com.payroll.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class EmployeeDao {
	public static boolean insertEmp(Employee emp) {
		boolean result=false;
		String insertQuery="insert into employees (emp_name,emp_dob,emp_doj,emp_address,emp_city,emp_pincode,emp_mobile_no,"
				+ "emp_state,emp_email_id,emp_pan_no,dept_id) values (?,?,?,?,?,?,?,?,?,?,?)";
		Connection con=ConnectionUtil.dbConnect();
		try {
			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setDate(2,new java.sql.Date(emp.getDob().getTime()));
			pstmt.setDate(3, new java.sql.Date(emp.getDoj().getTime()));
			pstmt.setString(4, emp.getAddress());
			pstmt.setString(5, emp.getCity());
			pstmt.setLong(6,emp.getPincode());
			pstmt.setLong(7,emp.getMobileNo());
			pstmt.setString(8, emp.getState());
			pstmt.setString(9, emp.getMailId());
			pstmt.setString(10,emp.getPanNo());
			pstmt.setInt(11, emp.getDept().getDeptId());
			System.out.println(pstmt.executeUpdate()>0?"value inserted successfully":"value not inserted");
			result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result ;
		
		
		}
	public static Employee findEmployee(int empId)
	{
		String findEmployeeQuery="select * from employees where emp_id=?";
	Connection con=ConnectionUtil.dbConnect();
	Employee employee=null;
	try {
		PreparedStatement pstmt=con.prepareStatement(findEmployeeQuery);
		pstmt.setInt(1, empId);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			Departments dept=DepartmentsDao.findDepartment(rs.getInt(12));
			employee=new Employee(rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8),rs.getString(9),rs.getString(10),rs.getString(11),dept);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return employee;
	}
	
	public void updateEmp(Long mobileNo,int empId)
	{
	
		String insertQuery = "update employees set emp_mobile_no="+mobileNo+" where emp_id= "+empId;
		Connection con = ConnectionUtil.dbConnect();
		try {

			Statement stmt=con.createStatement();
			
			System.out.println(stmt.executeUpdate(insertQuery)>0?"Employee Updated Successfully":"employee not updated");
		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
			System.out.println("Employee not updated properly");
		}
		
	}
	public void deleteEmp(int  empId)
	{
		String deleteQuery = "delete from employees where emp_id="+empId;
		Connection con = ConnectionUtil.dbConnect();
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate(deleteQuery);
			
			
			System.out.println("employee details are deleted successfully");

		} catch (Exception e) {
			//catch the exception and get that message
			e.getMessage();
			System.out.println("employee details are not deleted ");
		}
	}
	
	
	public static int findEmployeeID(Employee emp)
	{
		String findId="select emp_id from employees where emp_email_id= '"+emp.getMailId()+"'";
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
	

	public List<Employee> showEmployee(int deptId)
	{
		List<Employee> employeeList=new ArrayList<Employee>();
		
		String showQuery="select * from employees where dept_id="+deptId;
		Connection con=ConnectionUtil.dbConnect();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Departments depart=DepartmentsDao.findDepartment(rs.getInt(12));
				Employee employee=new Employee(rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8),rs.getString(9),rs.getString(10),rs.getString(11),depart);
				employeeList.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	public static Employee findEmploy(String email)
	{
		String findEmployeeQuery="select * from employees where EMP_EMAIL_ID=?";
	Connection con=ConnectionUtil.dbConnect();
	Employee employee=null;
	try {
		PreparedStatement pstmt=con.prepareStatement(findEmployeeQuery);
		pstmt.setString(1, email);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			Departments dept=DepartmentsDao.findDepartment(rs.getInt(12));
			employee=new Employee(rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8),rs.getString(9),rs.getString(10),rs.getString(11),dept);
		}
		
	} catch (SQLException e) {
		
		e.getMessage();
	}
		return employee;
	}
	
	
}
