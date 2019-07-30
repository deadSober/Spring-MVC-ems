/**
 * 
 */
package com.medplus.ems.dao;

import java.util.List;

import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.exception.EMSException;

/**
 * @author medplus
 *
 */
public interface UserDao {
	public int getLoginDetails(int employeeCode, String password) throws EMSException;
	public List<EmployeeDetails> getEmployeeDetails(EmployeeSearchCriteria employeeSearchCriteria) throws EMSException;
	public void updateEmployee(EmployeeDetails employeeDetails) throws EMSException;
	public int createEmployeeDetails(EmployeeDetails employeeDetails,int userId) throws EMSException;
	public void insertEmployeeLoginDetails(int empcode,String password);
	public void insertEmployeeBalance(int empcode,int UserId);
}
