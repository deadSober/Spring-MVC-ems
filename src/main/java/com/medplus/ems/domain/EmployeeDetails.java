package com.medplus.ems.domain;


import java.util.Date;
import lombok.Data;

@Data
public class EmployeeDetails {
	private int employeeCode;
	private String name;
	private Gender gender;
	private char departmentId;
	private Date dateOfBirth;
	private long mobileNumber;
	private String emailId;
	private String address;
	private Category category;
	private EmployeeStatus employeeStatus;
	private int createdBy;
	private Date createdDate;
	private int modifiedBy;
	private Date modifiedDate;
}