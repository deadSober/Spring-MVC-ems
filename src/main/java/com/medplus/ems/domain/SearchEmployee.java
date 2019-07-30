package com.medplus.ems.domain;

import lombok.Data;

@Data
public class SearchEmployee {
	private int employeeCode;
	private String name;
	private char departmentId;
	private long mobileNumber;
	private String emailId;
	private Category category;
	private EmployeeStatus employeeStatus;
}
