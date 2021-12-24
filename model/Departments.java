package com.payroll.model;

import java.util.Objects;

public class Departments {
	private int deptId;
	private String deptName;
	private Grade grd;
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departments(int deptId, String deptName, Grade grd) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.grd = grd;
	}
	@Override
	public String toString() {
		return "deptId = " + deptId + "\n deptName = " + deptName + "\n grd = " + grd +"\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName, grd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departments other = (Departments) obj;
		return deptId == other.deptId && Objects.equals(deptName, other.deptName) && Objects.equals(grd, other.grd);
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Grade getGrd() {
		return grd;
	}
	public void setGrd(Grade grd) {
		this.grd = grd;
	}
	

}
