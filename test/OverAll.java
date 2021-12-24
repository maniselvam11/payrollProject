package com.payroll.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.payroll.dao.AdminDao;
import com.payroll.dao.DepartmentsDao;
import com.payroll.dao.EmployeeDao;
import com.payroll.dao.GradeDao;
import com.payroll.dao.LeaveDao;
import com.payroll.dao.SalaryCalculateDao;
import com.payroll.model.Admin;
import com.payroll.model.Departments;
import com.payroll.model.EmpSalary;
import com.payroll.model.Employee;
import com.payroll.model.Grade;
import com.payroll.model.Leave;

public class OverAll {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(" Welcome Administrator ");
		System.out.println("1.login\nEnter your choice");

		int choice = Integer.parseInt(sc.nextLine());
		int adminChoice = 0;
		Admin user = null;
		switch (choice) {
		case 1:
			do {
				String emailId = null;

				System.out.println("Login");
				do {
					System.out.println("enter emailId:");
					emailId = sc.nextLine();
					if (!emailId.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
						System.out.println("email must include upper&special character");
					}
					if (emailId.isEmpty()) {
						System.out.println("email cant be empty");
					}

				} while (!emailId.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || emailId.isEmpty());

				String password = null;
				do {
					System.out.println("enter password");
					password = sc.nextLine();
					if (!password.matches("[A-Za-z0-9@#.!&]{8,16}")) {
						System.out.println("password must include 8 or 16 character");
					}
					if (password.isEmpty()) {
						System.out.println("password should be 8 character");
					}
				} while (!password.matches("[A-Za-z0-9@#.!&]{8,16}") || password.isEmpty());

				AdminDao userDao = new AdminDao();
				user = userDao.validateAdmin(emailId, password);

				if (user != null) {

					System.out.println("Welcome Admin");

				} else {
					System.out.println("invalid emailId && password");

				}
			} while (user == null);
		}

		char option = 'y';
		do {
			System.out.println("\n1.employee\n2.Department\n3.grade\n4.Leave Details\n5.Salary\nEnter ur choice");

			adminChoice = Integer.parseInt(sc.nextLine());

			switch (adminChoice) {

			case 1:
				char choise = 'y';
				do {

					System.out.println(
							"1.employee Add\n2.employee Update\n3.employee Delete\n4.employee show\nEnter your choice");
					int a = Integer.parseInt(sc.nextLine());
					switch (a) {

					case 1:

						System.out.println("Employ details");
						String empName;
						Date empDob = null;
						Date empDoj = null;
						String empAddress;
						String empCity;
						String empPincode;
						String tempMobile;
						Long empMobileNo;
						String empState = null;
						String empEmailId;
						String tempDob = null;
						String tempDoj = null;
						String empPanNo = null;

						do {
							System.out.println("enter empName");
							empName = sc.nextLine();

							if (empName.isEmpty()) {
								System.out.println("empName cant be empty");
							}
							if (!empName.matches("[a-zA-z\s]+")) {
								System.out.println("empName only contains characters");
							}
						} while (empName.isEmpty() || !empName.matches("[a-zA-z\s]+"));

						try {
							do {
								System.out.println("enter EmpDob");
								tempDob = sc.nextLine();
								if (tempDob.isEmpty()) {
									System.out.println("date must be enter");
								}
								if (!tempDob.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}")) {
									System.out.println("date must be eg 'dd-MM-yyyy'");
								}
							} while (tempDob.isEmpty()
									|| !tempDob.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"));
							empDob = sdf.parse(tempDob);

							do {
								System.out.println("enter EmpDoj");
								tempDoj = sc.nextLine();
								if (tempDoj.isEmpty()) {
									System.out.println("date must be enter");
								}
								if (!tempDoj.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}")) {
									System.out.println("date must be eg 'dd-mm'yyyy'");
								}

							} while (tempDoj.isEmpty()
									|| !tempDoj.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"));
							empDoj = sdf.parse(tempDoj);
						}

						catch (ParseException e) {

							e.printStackTrace();
						}
						do {
							System.out.println("enter empAddress");
							empAddress = sc.nextLine();
							if (empAddress.isEmpty()) {
								System.out.println("Address cant be empty");

							}
							if (!empAddress.matches("[a-zA-z0-9/,\s]+")) {
								System.out.println("Address cant matches the format");

							}
						} while (empAddress.isEmpty() || !empAddress.matches("[a-zA-z0-9/,\s]+"));
						do {
							System.out.println("enter empCity");
							empCity = sc.nextLine();

							if (empCity.isEmpty()) {
								System.out.println("city cant be empty");
							}
							if (!empCity.matches("[a-zA-z]+")) {
								System.out.println("city name only contains characters");
							}

						} while (empCity.isEmpty() || !empCity.matches("[a-zA-z]+"));

						do {
							System.out.println("enter empPincode");
							empPincode = sc.nextLine();

							if (!empPincode.matches("[0-9]+{6}")) {
								System.out.println("pincode max 8 character only");
							}
							if (empPincode.isEmpty()) {
								System.out.println("pincode cant be empty");
							}

						} while (empPincode.isEmpty() || !empPincode.matches("[0-9]+{6}"));
						Long empPincod = Long.parseLong(empPincode);

						do {
							System.out.println("enter empMobileNo");
							tempMobile = sc.nextLine();
							if (tempMobile.isEmpty()) {
								System.out.println("mobileNo cant be empty");
							}
							if (!tempMobile.matches("[0-9]{10}")) {
								System.out.println("mobileNo must be 10 numbers");
							}

						} while (tempMobile.isEmpty() || !tempMobile.matches("[0-9]{10}"));

						empMobileNo = Long.parseLong(tempMobile);
						do {
							System.out.println("enter empState");
							empState = sc.nextLine();
							if (empState.isEmpty()) {
								System.out.println("state is cant be empty");
							}
							if (!empState.matches("[a-zA-z\s]+")) {
								System.out.println("state only contains characters");
							}
						} while (empState.isEmpty() || !empState.matches("[a-zA-z\s]+"));

						do {
							System.out.println("enter emailId:");
							empEmailId = sc.nextLine();
							if (!empEmailId.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
								System.out.println("email must include upper&special character");
							}
							if (empEmailId.isEmpty()) {
								System.out.println("email cant be empty");
							}

						} while (!empEmailId.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || empEmailId.isEmpty());

						do {
							System.out.println("enter panNumber");
							empPanNo = sc.nextLine();
							if (empPanNo.isEmpty()) {
								System.out.println("panNumber cant be empty");
							}
							if (!empPanNo.matches("[a-zA-z0-9]+{10}")) {
								System.out.println("panNumber only 12 characters");
							}

						} while (empPanNo.isEmpty() || !empPanNo.matches("[a-zA-Z0-9]+{10}"));
						String depId = null;
						do {
							System.out.println("enter Department ID");
							depId = sc.nextLine();
							if (depId.isEmpty()) {
								System.out.println("id must enter");
							}
							if (!depId.matches("[0-9]+")) {
								System.out.println("id only includes numbers");
							}
						} while (depId.isEmpty() || !depId.matches("[0-9]+"));

						int deptID = Integer.parseInt(depId);
						Departments dprt = DepartmentsDao.findDepartment(deptID);
						Employee emp = new Employee(empName, empDob, empDoj, empAddress, empCity, empPincod,
								empMobileNo, empState, empEmailId, empPanNo, dprt);

						boolean empInsert = EmployeeDao.insertEmp(emp);
						System.out.println(emp);
						if (empInsert != false) {
							System.out.println("Employee " + emp.getEmpName() + " details inserted successfully");
						} else {
							System.out.println("please insert all values");
						}

						break;

					case 2:
						String tempId;
						int empId;

						String tempID;
						do {

							System.out.println("enter id for which employee update");
							tempID = sc.nextLine();
							if (tempID.isEmpty()) {
								System.out.println("employee update id is empty");
							}
							if (!tempID.matches("[0-9]+")) {
								System.out.println("id pattern is wrong");

							}
						} while (!tempID.matches("[0-9]+") || tempID.isEmpty());
						int empID = Integer.parseInt(tempID);

						String empNO = null;
						do {
							System.out.println("enter employee mobile number");
							empNO = sc.nextLine();

							if (empNO.isEmpty()) {
								System.out.println("Mobile number is not empty");
							}
							if (!empNO.matches("[0-9]{10}")) {
								System.out.println("MobileNumber must 10 numbers");
							}
						} while (empNO.isEmpty() || !empNO.matches("[0-9]{10}"));
						Long mobileNo = Long.parseLong(empNO);

						EmployeeDao empUpdateDao = new EmployeeDao();
						empUpdateDao.updateEmp(mobileNo, empID);

						break;

					case 3:
						String delID = null;
						do {
							System.out.println("enter id for which employee delete");
							delID = sc.nextLine();
							if (delID.isEmpty()) {
								System.out.println("emp id must enter");
							}
							if (!delID.matches("[0-9]+")) {
								System.out.println("id pattern is wrong");
							}
						} while (delID.isEmpty() || !delID.matches("[0-9]+"));

						int id = Integer.parseInt(delID);
						EmployeeDao empDeleteDao = new EmployeeDao();
						empDeleteDao.deleteEmp(id);

						break;

					case 4:
						System.out.println("show all employees");
						System.out.println("enter department id for which employees show");
						int depID=Integer.parseInt(sc.nextLine());
						EmployeeDao empShowDao = new EmployeeDao();
						List<Employee> empShow = empShowDao.showEmployee(depID);
						System.out.println(empShow);

						break;
					default:
						System.exit(0);

					}
					System.out.println("Do you want to continue Employee y/n");
					choise = sc.nextLine().charAt(0);
				} while (choise == 'y');
				break;

			case 2:
				do {

					System.out.println("1.update Department\n2.Show Departments");
					int d1 = Integer.parseInt(sc.nextLine());
					System.out.println("Department details");

					switch (d1) {
//				case 1:
//					String deptName = null;
//					String depId=sc.nextLine();
//					do {
//						if(depId.isEmpty()) {
//							System.out.println("Department id must enter");
//						}
//						if(!depId.matches("[0-9]+")) {
//							System.out.println("Department id only numbers");
//						}
//					}while(!depId.matches("[0-9]+")||depId.isEmpty());
//					int depID=Integer.parseInt(depId);
//
//					do {
//						System.out.println("Enter the department Name:");
//						deptName = sc.nextLine();
//						if (deptName.isEmpty()) {
//							System.out.println("Department name must include");
//						}
//						if (!deptName.matches("[a-zA-z]+")) {
//							System.out.println("Department name only contains characters");
//						}
//					} while (!deptName.matches("[a-zA-z]+") || deptName.isEmpty());
//					String ID=null;
//					do {
//						System.out.println("enter Grade ID");
//						ID=sc.nextLine();
//						if (ID.isEmpty()) {
//							System.out.println("id must enter");
//						}
//						if (!ID.matches("[0-9]+")) {
//							System.out.println("id only includes numbers");
//						}
//					} while (ID.isEmpty() || !ID.matches("[0-9]+"));
//					int grdID=Integer.parseInt(ID);
//					
//					Grade grde=GradeDao.findGrade(grdID);
//					DepartmentsDao deptdao=new DepartmentsDao();
//					Departments dprt=new Departments(depID,deptName,grde);
//					deptdao.insertDep(dprt);
//					break;
//				case 2:

					case 1:
						String deptUpdID = null;
						do {
							System.out.println("enter id which Department name update");
							deptUpdID = sc.nextLine();
							if (deptUpdID.isEmpty()) {
								System.out.println("enter department id must");
							}
							if (!deptUpdID.matches("[0-9]+")) {
								System.out.println("Department id pattern is wrong");
							}

						} while (!deptUpdID.matches("[0-9]+") || deptUpdID.isEmpty());
						int updId = Integer.parseInt(deptUpdID);
						String updDeptName = null;
						do {
							System.out.println("enter Department name to change");
							updDeptName = sc.nextLine();
							if (updDeptName.isEmpty()) {
								System.out.println("Department name must enter");
							}
							if (!updDeptName.matches("[a-zA-Z]+")) {
								System.out.println("Department name must characters only");
							}
						} while (!updDeptName.matches("[a-zA-Z]+") || updDeptName.isEmpty());

						DepartmentsDao updDept = new DepartmentsDao();
						updDept.updateDept(updId, updDeptName);
						break;

					case 2:
						System.out.println("Show all departments");
						DepartmentsDao showDept = new DepartmentsDao();
						List<Departments> showDeptList = showDept.showDepartments();
						System.out.println(showDeptList);
						break;

					default:
						System.exit(0);
					}
					System.out.println("Do you want to continue Department y/n");
					choise = sc.nextLine().charAt(0);
				} while (choise == 'y');
				break;

			case 3:
				do {

					System.out.println("1.Add grade\n2.Delete grade\n3.Update grade\n4.show Grade");
					int gradeChoice = Integer.parseInt(sc.nextLine());

					switch (gradeChoice) {
					case 1:
						String gradeName;
						String tempGradebasic;
						long gradeSalary;
						String tempGradeBonus;
						long gradeBonus;
						String tempGradePf;
						long gradePf;
						String tempGradePt;
						long gradePt;
						System.out.println("Enter grade details");
						do {

							System.out.println("enter gradeName");
							gradeName = sc.nextLine();

							if (gradeName.isEmpty()) {
								System.out.println("gradeName cant be empty");
							}
							if (!gradeName.matches("[a-zA-z\s]+")) {
								System.out.println("gradeName only contains characters");
							}
						} while (gradeName.isEmpty() || !gradeName.matches("[a-zA-z\s]+"));

						do {
							System.out.println("enter grade basic salary");

							tempGradebasic = sc.nextLine();
							if (tempGradebasic.isEmpty()) {
								System.out.println("grade basic salary is mandatory");
							}
							if (!tempGradebasic.matches("[0-9]+")) {
								System.out.println("salary only includes numbers");
							}

						} while (tempGradebasic.isEmpty() || !tempGradebasic.matches("[0-9]+"));
						gradeSalary = Long.parseLong(tempGradebasic);

						do {
							System.out.println("enter grade bonus ");

							tempGradeBonus = sc.nextLine();
							if (tempGradeBonus.isEmpty()) {
								System.out.println("grade bonus is mandatory");
							}
							if (!tempGradeBonus.matches("[0-9]+")) {
								System.out.println("Bonus only includes numbers");
							}

						} while (tempGradeBonus.isEmpty() || !tempGradeBonus.matches("[0-9]+"));

						gradeBonus = Long.parseLong(tempGradebasic);

						do {
							System.out.println("enter grade Provident fund");

							tempGradePf = sc.nextLine();
							if (tempGradePf.isEmpty()) {
								System.out.println("grade Provident fund is mandatory");
							}
							if (!tempGradePf.matches("[0-9]+")) {
								System.out.println("Provident fund only includes numbers");
							}

						} while (tempGradePf.isEmpty() || !tempGradePf.matches("[0-9]+"));

						gradePf = Long.parseLong(tempGradePf);

						do {
							System.out.println("enter grade Professional tax fund");

							tempGradePt = sc.nextLine();
							if (tempGradePt.isEmpty()) {
								System.out.println("grade Professional Tax is mandatory");
							}
							if (!tempGradePt.matches("[0-9]+")) {
								System.out.println("Professional Tax  only includes numbers");
							}
						} while (tempGradePt.isEmpty() || !tempGradePt.matches("[0-9]+"));

						gradePt = Long.parseLong(tempGradePt);

						Grade grade = new Grade(gradeName, gradeSalary, gradeBonus, gradePf, gradePt);
						GradeDao gradedao = new GradeDao();
						boolean gradeStatus = gradedao.insertGrade(grade);
						if (gradeStatus != false) {
							System.out.println("Grade Inserted Successfully");

						} else {
							System.out.println("Grade not Inserted successfully");

						}
						break;
					case 2:
						String delGradeID = null;
						do {
							System.out.println("enter id for which grade delete");
							delGradeID = sc.nextLine();
							if (delGradeID.isEmpty()) {
								System.out.println("id must enter");
							}
							if (!delGradeID.matches("[0-9]+")) {
								System.out.println("id only numbers");
							}

						} while (!delGradeID.matches("[0-9]+") || delGradeID.isEmpty());

						int delGradeId = Integer.parseInt(delGradeID);
						GradeDao delGradeDao = new GradeDao();
						delGradeDao.deleteGrade(delGradeId);
						System.out.println("Grade Deleted Successfully");
						break;
					case 3:
						System.out.println("enter Grade Update details");
						String strBasic = null;
						do {
							System.out.println("enter Grade basic salary");
							strBasic = sc.nextLine();
							if (strBasic.isEmpty()) {
								System.out.println("Basic amount is mandatory");
							}
							if (!strBasic.matches("[0-9]+")) {
								System.out.println("Basic amount only numbers");
							}

						} while (strBasic.isEmpty() || !strBasic.matches("[0-9]+"));

						Long grdBasic = Long.parseLong(strBasic);
						String strBonus = null;
						do {
							System.out.println("enter Grade Bonus ");
							strBonus = sc.nextLine();
							if (strBonus.isEmpty()) {
								System.out.println("Bonus must enter");
							}
							if (!strBonus.matches("[0-9]+")) {
								System.out.println("Bonus only have numbers");
							}

						} while (!strBonus.matches("[0-9]+") || strBonus.isEmpty());
						Long grdBonus = Long.parseLong(strBonus);
						String strPf = null;
						do {
							System.out.println("enter Grade Pf");
							strPf = sc.nextLine();
							if (strPf.isEmpty()) {
								System.out.println("PF is mandatory");
							}
							if (!strPf.matches("[0-9]+")) {
								System.out.println("Pf only numbers");
							}

						} while (strPf.isEmpty() || !strPf.matches("[0-9]+"));
						Long grdPf = Long.parseLong(strPf);
						String strPt = null;
						do {
							System.out.println("enter Grade Pt");
							strPt = sc.nextLine();
							if (strPt.isEmpty()) {
								System.out.println("Profesional tax is not empty");
							}
							if (!strPt.matches("[0-9]+")) {
								System.out.println("Professional tax is only numbers");
							}
						} while (strPt.isEmpty() || !strPt.matches("[0-9]+"));
						Long grdPt = Long.parseLong(strPt);

						System.out.println("enter name which grade update");
						String grdName = null;
						do {
							grdName = sc.nextLine();
							if (grdName.isEmpty()) {
								System.out.println("Grade Name is not empty");
							}
							if (!grdName.matches("[a-zA-Z\s]+")) {
								System.out.println("Grade name only characters");
							}

						} while (!grdName.matches("[a-zA-Z\s]+") || grdName.isEmpty());
						GradeDao grdUpd = new GradeDao();
						boolean grdUpdate = grdUpd.updateGrade(grdBasic, grdBonus, grdPf, grdPt, grdName);
						if (grdUpdate != false) {
							System.out.println("Grade Updated successfully");

						} else {
							System.out.println("Grade not Updated successfully");
						}
						break;
					case 4:
						System.out.println("Show all Grades");
						GradeDao showGrd = new GradeDao();
						List<Grade> showGradeList = showGrd.showGrade();
						System.out.println(showGradeList);
						break;

					default:
						System.exit(0);

					}
					System.out.println("Do you want to continue Grades y/n");
					choise = sc.nextLine().charAt(0);

				} while (choise == 'y');
				break;

			case 4:

				do {
					System.out.println("1.leave add\n2.show leave");
					int leaveChoice = Integer.parseInt(sc.nextLine());
					switch (leaveChoice) {

					case 1:
						
						String leaveReason = null;
						do {
							System.out.println("Enter leave reason");
							leaveReason = sc.nextLine();
							if (leaveReason.isEmpty()) {
								System.out.println("Reason is mandatory");
							}
							if (!leaveReason.matches("[a-zA-Z\s]+")) {
								System.out.println("leave reason only contains letters");
							}

						} while (!leaveReason.matches("[a-zA-Z\s]+") || leaveReason.isEmpty());

						String tempLeaveDt = null;
						Date leaveDt = null;
						try {
							do {
								System.out.println("enter Leave Date");
								tempLeaveDt = sc.nextLine();
								if (tempLeaveDt.isEmpty()) {
									System.out.println("date must be enter");
								}
								if (!tempLeaveDt.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}")) {
									System.out.println("date must be eg 'dd-mm'yyyy'");
								}

							} while (tempLeaveDt.isEmpty()
									|| !tempLeaveDt.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"));
							leaveDt = sdf.parse(tempLeaveDt);
						}

						catch (ParseException e) {

							e.printStackTrace();
						}
						String tempEmpId = null;
						do {
							System.out.println("enter id for which employee");
							tempEmpId = sc.nextLine();
							if (tempEmpId.isEmpty()) {
								System.out.println("employ id must enter");
							}
							if (!tempEmpId.matches("[0-9]+")) {
								System.out.println("id only numbers");
							}

						} while (!tempEmpId.matches("[0-9]+") || tempEmpId.isEmpty());

						int emploID = Integer.parseInt(tempEmpId);
						Employee employe = EmployeeDao.findEmployee(emploID);
						Leave leave = new Leave(employe, leaveDt, leaveReason);
						LeaveDao leaveDao = new LeaveDao();
						boolean leaveResult = leaveDao.insertLeave(leave);
						if (leaveResult != false) {
							System.out.println("Leave details inserted successfully");
						} else {
							System.out.println("leave details not inserted successfully");
						}

						break;

					case 2:

						System.out.println("Show all leave");
						LeaveDao showLeave = new LeaveDao();
						List<Leave> showGradeList = showLeave.showLeaveDetail();
						System.out.println(showGradeList);
						break;

					default:
						System.exit(0);
						
					}
					System.out.println("Do you want to continue Leave y/n");
					choise = sc.nextLine().charAt(0);

				} while (choise == 'y');
				break;
			case 5:
				do {
				System.out.println("1.Salary Details add\n2.Show salary Details");
				int salaryChoice=Integer.parseInt(sc.nextLine());
				
					
				
				switch(salaryChoice) {
				
				case 1:
					String empSalaryemail = null;
					 {
							System.out.println("enter employee salary emailId:");
							empSalaryemail = sc.nextLine();
							if (!empSalaryemail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
								System.out.println("email must include upper&special character");
							}
							if (empSalaryemail.isEmpty()) {
								System.out.println("email cant be empty");
							}

						} while (!empSalaryemail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || empSalaryemail.isEmpty());

					Employee employee=EmployeeDao.findEmploy(empSalaryemail);
					
					String gradeName=null;
					do {
						System.out.println("enter the grade name");
						gradeName=sc.nextLine();
						if (gradeName.isEmpty()) {
							System.out.println("grade name is mandatory");
						}
						if (!gradeName.matches("[a-zA-Z\s]+")) {
							System.out.println("grade name only contains characters");
						}
						
					}while(gradeName.isEmpty()||!gradeName.matches("[a-zA-Z\s]+"));
					
					Grade grde=GradeDao.findGrade(gradeName);
					String deptName=null;
					do {
						System.out.println("enter department name");
						deptName=sc.nextLine();
						if (deptName.isEmpty()) {
							System.out.println("Reason is mandatory");
						}
						if (!deptName.matches("[a-zA-Z\s]+")) {
							System.out.println("leave reason only contains letters");
						}
						
					}while(deptName.isEmpty()||!deptName.matches("[a-zA-Z\s]+"));
					
					Departments dpart=DepartmentsDao.findDepartment(deptName);
					
					System.out.println("enter leave date");
					Date leaveDt=null;
					Date salaryDt=null;
					Leave leave=null;
					try {
						leaveDt=sdf.parse(sc.nextLine());
						int empId=EmployeeDao.findEmployeeID(employee);
						leave=LeaveDao.findLeave(leaveDt,empId);
						System.out.println(leave.getEmploy());
						System.out.println("Salary Date");
						salaryDt=sdf.parse(sc.nextLine());
						
					}
					catch (ParseException e) {

						e.printStackTrace();
					}
					
					long grossSalary=GradeDao.grossSalary(gradeName);
					System.out.println("GrossSalary "+grossSalary);
					int employID=EmployeeDao.findEmployeeID(employee);
					System.out.println("EmployeeID "+employID);
					int noOfLeave=LeaveDao.leaveDays(employID);
					System.out.println("count Leave Days "+noOfLeave);
					long perDaySalary=GradeDao.perDaySalary(gradeName);
					System.out.println("PerDay Salary "+perDaySalary);
					long basicSalary=GradeDao.basicSalary(gradeName);
					System.out.println("Basic Salary "+basicSalary);
					long bonus=GradeDao.bonus(gradeName);
					long pt=GradeDao.professionalTax(gradeName);
					long pf=GradeDao.providentFund(gradeName);
					System.out.println("Do you want to deducte professional tax the amount y/n");
					char pfChoise=sc.nextLine().charAt(0);
					if(pfChoise=='y') {
						
					System.out.println("This month bonus do you want to add y/n");
					char bonusChoise=sc.nextLine().charAt(0);
					if(bonusChoise=='y') {
						long salary=(((basicSalary+pt)-(noOfLeave*perDaySalary))-pf);
						System.out.println("Employee salary"+salary);
						SalaryCalculateDao.insertSalary(employee, grde, dpart, leave, salaryDt, grossSalary, salary);
					}
					else {
						long salaryBonus=(((basicSalary+bonus+pt)-(noOfLeave*perDaySalary))-pf);
						System.out.println("Employee salary"+salaryBonus);
						SalaryCalculateDao.insertSalary(employee, grde, dpart, leave, salaryDt, grossSalary, salaryBonus);
						
						
					}
					}
					else {
						System.out.println("This month bonus do you want to add y/n");
						char bonusChoise=sc.nextLine().charAt(0);
						if(bonusChoise=='y') {
							long salary=(((basicSalary+pt)-(noOfLeave*perDaySalary)));
							System.out.println("Employee salary"+salary);
							boolean result=SalaryCalculateDao.insertSalary(employee, grde, dpart, leave, salaryDt, grossSalary, salary);
							if(result!=false) {
								System.out.println("salary details inserted successfully");
							}
							else {
								System.out.println("salary details not inserted successfully");
							}
						}
						else {
							long salaryBonus=(((basicSalary+bonus+pt)-(noOfLeave*perDaySalary)));
							System.out.println("Employee salary"+salaryBonus);
							boolean result=SalaryCalculateDao.insertSalary(employee, grde, dpart, leave, salaryDt, grossSalary, salaryBonus);
							if(result!=false) {
								System.out.println("salary details inserted successfully");
							}
							else {
								System.out.println("salary details not inserted successfully");
							}
							
						}
						
					}
					
					
					break;
				case 2:
					System.out.println("Show Salary information");
					SalaryCalculateDao salaryCal=new SalaryCalculateDao();
					List<EmpSalary>empSalary=salaryCal.showEmployee();
					System.out.println(empSalary);
					break;
					
				default:
					System.exit(0);
					
				}
				System.out.println("Do you want to continue salary y/n");
				choise = sc.nextLine().charAt(0);

			} while (choise == 'y');
					
					
			break;

			default:
				System.exit(0);
			}
			System.out.println("Do you want to go main page:y/n");
			option = sc.nextLine().charAt(0);
		} while (option == 'y');
		System.out.println("Thank you");

	}
}