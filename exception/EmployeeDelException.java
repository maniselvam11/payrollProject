package com.payroll.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class EmployeeDelException extends SQLIntegrityConstraintViolationException{

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Employee details can't be delete";
	}
	
	

}
