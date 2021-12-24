package com.payroll.model;
import java.util.Date;
import java.util.Objects;

public class Employee {
	
	private String empName;
	private Date dob;
	private Date doj;
	private String address;
	private String city;
	private Long pincode;
	private Long mobileNo;
	private String state;
	private String mailId;
	private String panNo;
	private Departments dept;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public Departments getDept() {
		return dept;
	}
	public void setDept(Departments dept) {
		this.dept = dept;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, dept, dob, doj, empName, mailId, mobileNo, panNo, pincode, state);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(dept, other.dept) && Objects.equals(dob, other.dob)
				&& Objects.equals(doj, other.doj) && Objects.equals(empName, other.empName)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(panNo, other.panNo) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(state, other.state);
	}
	@Override
	public String toString() {
		return "empName = " + empName + "\n dob = " + dob + "\n doj = " + doj + "\n address = " + address + "\n city = "
				+ city + "\n pincode = " + pincode + "\n mobileNo = " + mobileNo + "\n state = " + state + "\n mailId = " + mailId
				+ "\n panNo = " + panNo + "\n dept = " + dept +"\n" ;
	}
	public Employee(String empName, Date dob, Date doj, String address, String city, Long pincode, Long mobileNo,
			String state, String mailId, String panNo, Departments dept) {
		super();
		this.empName = empName;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.state = state;
		this.mailId = mailId;
		this.panNo = panNo;
		this.dept = dept;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
