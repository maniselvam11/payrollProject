package com.payroll.model;

import java.util.Date;
import java.util.Objects;

public class Leave {
	private Employee employ;
	private Date leaveDt;
	private String LeaveReason;
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leave(Employee employ, Date leaveDt, String leaveReason) {
		super();
		this.employ = employ;
		this.leaveDt = leaveDt;
		LeaveReason = leaveReason;
	}
	
	@Override
	public String toString() {
		return "employ = " + employ + "\n leaveDt = " + leaveDt + "\n LeaveReason = " + LeaveReason + "\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(LeaveReason, employ);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leave other = (Leave) obj;
		return Objects.equals(LeaveReason, other.LeaveReason) && Objects.equals(employ, other.employ);
	}
	public Employee getEmploy() {
		return employ;
	}
	public void setEmploy(Employee employ) {
		this.employ = employ;
	}
	public Date getLeaveDt() {
		return leaveDt;
	}
	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}
	public String getLeaveReason() {
		return LeaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		LeaveReason = leaveReason;
	}

}
