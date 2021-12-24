package com.payroll.model;

import java.util.Date;
import java.util.Objects;

public class EmpSalary {
	private Employee empId;
	private Departments deptId;
	private Grade gradeId;
	private Leave leaveId;
	private Date salaryDt;
	private Long gross;
	private Long salary;
	public Employee getEmpId() {
		return empId;
	}
	public void setEmpId(Employee empId) {
		this.empId = empId;
	}
	public Departments getDeptId() {
		return deptId;
	}
	public void setDeptId(Departments deptId) {
		this.deptId = deptId;
	}
	public Grade getGradeId() {
		return gradeId;
	}
	public void setGradeId(Grade gradeId) {
		this.gradeId = gradeId;
	}
	public Leave getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Leave leaveId) {
		this.leaveId = leaveId;
	}
	public Date getSalaryDt() {
		return salaryDt;
	}
	public void setSalaryDt(Date salaryDt) {
		this.salaryDt = salaryDt;
	}
	public Long getGross() {
		return gross;
	}
	public void setGross(Long gross) {
		this.gross = gross;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptId, empId, gradeId, gross, salary, salaryDt);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpSalary other = (EmpSalary) obj;
		return Objects.equals(deptId, other.deptId) && Objects.equals(empId, other.empId)
				&& Objects.equals(gradeId, other.gradeId) && Objects.equals(gross, other.gross)
				&& Objects.equals(salary, other.salary) && Objects.equals(salaryDt, other.salaryDt);
	}
	@Override
	public String toString() {
		return "empId=" + empId + "\n deptId=" + deptId + "\n gradeId=" + gradeId + "\n salaryDt=" + salaryDt
				+ "\n gross=" + gross + "\n salary=" + salary + "\n";
	}
	public EmpSalary(Employee empId, Departments deptId, Grade gradeId, Leave leaveId, Date salaryDt, Long gross,
			Long salary) {
		super();
		this.empId = empId;
		this.deptId = deptId;
		this.gradeId = gradeId;
		this.leaveId = leaveId;
		this.salaryDt = salaryDt;
		this.gross = gross;
		this.salary = salary;
	}
	public EmpSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
