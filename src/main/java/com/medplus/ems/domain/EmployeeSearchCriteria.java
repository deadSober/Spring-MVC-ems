package com.medplus.ems.domain;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class EmployeeSearchCriteria {

	private int employeeCode;
	private String name;
	private char departmentId;
	private long mobileNumber;
	private String emailId;
	private Category category;
	private EmployeeStatus employeeStatus;
}