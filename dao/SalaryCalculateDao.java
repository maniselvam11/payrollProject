package com.payroll.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.payroll.model.Departments;
import com.payroll.model.EmpSalary;
import com.payroll.model.Employee;
import com.payroll.model.Grade;
import com.payroll.model.Leave;

public class SalaryCalculateDao {

		public static boolean insertSalary(Employee emp,Grade grade,Departments department,Leave leave,Date salaryDt,long grossSalary,long totalSalary) {
			boolean result=false;
			int empID=EmployeeDao.findEmployeeID(emp);
			int deptID=DepartmentsDao.findDepartmentID(department);
			int gradeID=GradeDao.findGradeID(grade);
			int leaveID=LeaveDao.findLeaveID(leave);
			String query="insert into salarys (EMP_ID,DEPT_ID,LEAVE_ID,GRADE_ID,PAID_DATE,GROSS_SALARY,TOTAL_SALARY) values(?,?,?,?,?,?,?)";
			Connection con=ConnectionUtil.dbConnect();
			try {
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, empID);
				pstmt.setInt(2, deptID);
				pstmt.setInt(3, leaveID);
				pstmt.setInt(4, gradeID);
				pstmt.setDate(5, new java.sql.Date(salaryDt.getTime()));
				pstmt.setLong(6, grossSalary);
				pstmt.setLong(7, totalSalary);
				pstmt.executeQuery();
				result=true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
			
		}
		public void updateSalary(int transId,long basic)
		{
		
			String insertQuery = "update employees set ="+basic+" where trans_id="+transId;
			Connection con = ConnectionUtil.dbConnect();
			try {

				Statement stmt=con.createStatement();
				stmt.executeUpdate(insertQuery);
				System.out.println("Employee Updated Successfully");
			} catch (SQLException e) {
				//catch the exception and get that message
				e.printStackTrace();
				System.out.println("Employee not updated properly");
			}
			
		}public List<EmpSalary> showEmployee()
		{
			List<EmpSalary> salaryList=new ArrayList<EmpSalary>();
			
			String showQuery="select * from salarys ";
			Connection con=ConnectionUtil.dbConnect();
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(showQuery);
				while(rs.next())
				{
					
					Employee employ=EmployeeDao.findEmployee(rs.getInt(2));
					Departments department=DepartmentsDao.findDepartment(rs.getInt(3));
					Leave leave=LeaveDao.findLeave(rs.getInt(4));
					Grade grade=GradeDao.findGrade(rs.getInt(5));
					
					EmpSalary empSalary=new EmpSalary(employ,department,grade,leave,rs.getDate(6),rs.getLong(7),rs.getLong(8));
					salaryList.add(empSalary);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return salaryList;
		}
	
	}



