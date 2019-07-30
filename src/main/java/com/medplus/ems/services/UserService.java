package com.medplus.ems.services;

import java.util.List;

import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.LoginDetails;
import com.medplus.ems.exception.EMSException;

public interface UserService {
	/**
	 * @param loginDetails
	 * @throws EMSException
	 *             check the fields whether null -- if yes - throw Fields are empty
	 *             exception -- else - call Login dao,check the credentials -- if
	 *             not valid--> throw exception - -- else--> check status and role
	 */
	public EmployeeDetails login(LoginDetails loginDetails) throws EMSException;
	/**
	 * @param employeeDetails
	 * @param userId
	 * @return EmployeeDetails
	 * @throws EMSException
	 *             check the fields whether null -- if yes - throw Fields are empty
	 *             exception -- else - check whether call EmployeeDetails dao -- add
	 *             details
	 */
	public int createEmployee(EmployeeDetails employeeDetails, int userId) throws EMSException;
	/**
	 * @param employeeDetails
	 * @userId
	 * @return int -- empcode
	 * @throws EMSException
	 *             status should be active check the fields whether null -- if yes -
	 *             throw Fields are empty exception -- else - call EmployeeDetails
	 *             dao -- update details
	 */
	public void updateEmployee(EmployeeDetails employeeDetails, int userId) throws EMSException;
	/**
	 * @param searchEmployee
	 * @throws EMSException
	 *             check whether searchemployee fileds are null --> if yes-- return
	 *             no records found --> else call EmployeeDetails dao-- get
	 *             empcode,name,mobileNumber,emailId,address,dept,role,status
	 */
	public List<EmployeeDetails> getEmployeeDetails(EmployeeSearchCriteria employeesearchcriteria) throws EMSException;
	/**
	 * @param userId
	 * @param currentPassword
	 * @param newPassword
	 * @throws EMSException
	 *             check the fields whether null -- if yes - throw Fields are empty
	 *             exception -- else- call Login dao - get password and validate
	 *             --if yes upadte Login dao -- else throw not matches exception
	 */
	public void changePassword(int userId, String currentPassword, String newPassword) throws EMSException;
}