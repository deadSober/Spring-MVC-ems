package com.medplus.ems.validators;

import com.medplus.ems.constants.ErrorConstants;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.LoginDetails;
import com.medplus.ems.exception.EMSException;

public class UserValidator {
	public static void validateLoginDetails(LoginDetails loginDetails) throws EMSException {
		CommonValidator.validateInt(loginDetails.getEmployeeCode(), ErrorConstants.INVALID_EMPLOYEE_CODE);
		CommonValidator.validateString(loginDetails.getPassword(), ErrorConstants.INVALID_EMPLOYEE_PASSWORD);
	}

	public static void validateEmployeeDetails(EmployeeDetails employeeDetails) throws EMSException {
		CommonValidator.validate(employeeDetails, ErrorConstants.INVALID_EMPLOYEE_DETAILS);
		CommonValidator.validateName(employeeDetails.getName(), ErrorConstants.INVALID_EMPLOYEE_NAME);
		CommonValidator.validate(employeeDetails.getGender(), ErrorConstants.INVALID_EMPLOYEE_GENDER);
		CommonValidator.validate(employeeDetails.getDepartmentId(), ErrorConstants.INVALID_EMPLOYEE_DEPARTMENT);
		CommonValidator.validate(employeeDetails.getDateOfBirth(), ErrorConstants.INVALID_EMPLOYEE_DATEOFBIRTH);
		CommonValidator.validateMobileNumber(employeeDetails.getMobileNumber(),
				ErrorConstants.INVALID_EMPLOYEE_MOBILENUMBER);
		CommonValidator.validateString(employeeDetails.getEmailId(), ErrorConstants.INVALID_EMPLOYEE_EMAILID);
		CommonValidator.validateString(employeeDetails.getAddress(), ErrorConstants.INVALID_EMPLOYEE_ADDRESS);
		CommonValidator.validate(employeeDetails.getEmployeeStatus(), ErrorConstants.INVALID_EMPLOYEE_STATUS);
		CommonValidator.validate(employeeDetails.getCategory(), ErrorConstants.INVALID_EMPLOYEE_CATEGORY);

	}

	public static void employeeSearchValidate(EmployeeSearchCriteria employeesearchcriteria) throws EMSException {
		int flagsarenull = 1;
		if ((employeesearchcriteria.getEmployeeCode() != 0)) {
			flagsarenull = 0;
		}
		if ((employeesearchcriteria.getMobileNumber() != 0)) {
			CommonValidator.validateMobileNumber(employeesearchcriteria.getMobileNumber(),
					ErrorConstants.INVALID_EMPLOYEE_MOBILENUMBER);
			flagsarenull = 0;
		}
		if ((employeesearchcriteria.getName() != null) && (!employeesearchcriteria.getName().isEmpty())) {
			CommonValidator.validateName(employeesearchcriteria.getName(), ErrorConstants.INVALID_EMPLOYEE_NAME);
			flagsarenull = 0;
		}
		if ((employeesearchcriteria.getEmailId() != null) && (!employeesearchcriteria.getEmailId().isEmpty())) {
			CommonValidator.validateEmailId(employeesearchcriteria.getEmailId(),
					ErrorConstants.INVALID_EMPLOYEE_EMAILID);
			flagsarenull = 0;
		}
		if ((employeesearchcriteria.getCategory() != null)) {
			flagsarenull = 0;
		}
		if ((employeesearchcriteria.getDepartmentId() != 0)) {
			flagsarenull = 0;
		}
		if (employeesearchcriteria.getEmployeeStatus() != null) {
			flagsarenull = 0;
		}

		if (flagsarenull == 1) {
			throw new EMSException("Invalid User Credentials");
		}
	}

	public static void updateEmployeeValidate(EmployeeDetails employeeDetails, int userId) throws EMSException {
		CommonValidator.validateInt(employeeDetails.getEmployeeCode(), ErrorConstants.INVALID_EMPLOYEE_CODE);
		CommonValidator.validateString(employeeDetails.getName(), ErrorConstants.INVALID_EMPLOYEE_NAME);
		CommonValidator.validateChar(employeeDetails.getDepartmentId(), ErrorConstants.INVALID_EMPLOYEE_DEPARTMENT);
		CommonValidator.validateMobileNumber(employeeDetails.getMobileNumber(),
				ErrorConstants.INVALID_EMPLOYEE_MOBILENUMBER);
		CommonValidator.validateEmailId(employeeDetails.getEmailId(), ErrorConstants.INVALID_EMPLOYEE_EMAILID);
		CommonValidator.validateString(employeeDetails.getAddress(), ErrorConstants.INVALID_EMPLOYEE_ADDRESS);
		if (employeeDetails.getEmployeeCode() == userId) {
			if (EmployeeStatus.INACTIVE.equals(employeeDetails.getEmployeeStatus())) {
				throw new EMSException("You are not authorised to change status");
			}
		}
	}
}
