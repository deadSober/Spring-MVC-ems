package com.medplus.ems.dao.helpers;

import com.medplus.ems.domain.EmployeeSearchCriteria;

public class UserHelper {
	public  static Object[] employeeSearchParameters(EmployeeSearchCriteria employeeSearchCriteria)
	{
		//EmployeeCode
		int employeeCodeFlag = 0;
		int employeeCode = 0;
		if ((employeeSearchCriteria.getEmployeeCode() != 0)) {
			employeeCodeFlag = 1;
			employeeCode = employeeSearchCriteria.getEmployeeCode();
		}
		//mobileNumber
		int mobileNumberFlag = 0;
		long mobileNumber = 0;
		if ((employeeSearchCriteria.getMobileNumber() != 0)) {
			mobileNumber = employeeSearchCriteria.getMobileNumber();
			mobileNumberFlag = 1;
		}

		// name
		int nameFlag = 0;
		String name = "";
		if ((employeeSearchCriteria.getName() != null) && (!employeeSearchCriteria.getName().isEmpty())) {
			name = employeeSearchCriteria.getName();
			nameFlag = 1;

		}

		// emailId
		int emailIdFlag = 0;
		String emailId = "";
		if ((employeeSearchCriteria.getEmailId() != null) && (!employeeSearchCriteria.getEmailId().isEmpty())) {
			emailId = employeeSearchCriteria.getEmailId();
			emailIdFlag = 1;
		}

		// roleId
		String roleId = "";
		int roleIdFlag = 0;
		if ((employeeSearchCriteria.getCategory()!= null)) {
			roleId = employeeSearchCriteria.getCategory().getValue();
			roleIdFlag = 1;
		}

		// departmentId
		String departmentId = "";
		int departmentIdFlag = 0;
		if ((employeeSearchCriteria.getDepartmentId()!= 0)) {
			departmentId =""+employeeSearchCriteria.getDepartmentId();
			departmentIdFlag = 1;

		}
		// status
		String status = "";
		int statusFlag = 0;
		if (employeeSearchCriteria.getEmployeeStatus()!= null) {
			status = employeeSearchCriteria.getEmployeeStatus().getValue();
			statusFlag = 1;
		}
	
		Object[] parameters = { employeeCodeFlag, employeeCode, mobileNumberFlag, mobileNumber, statusFlag, status,
				roleIdFlag, roleId, emailIdFlag, emailId, departmentIdFlag, departmentId, nameFlag, name };
	return parameters;
	}

}
