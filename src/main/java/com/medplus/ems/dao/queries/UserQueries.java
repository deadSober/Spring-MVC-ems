/**
 * 
 */
package com.medplus.ems.dao.queries;

/**
 * @author medplus
 *
 */
public abstract class UserQueries {
	public static final String getLoginDetails="SELECT employeeCode FROM tbl_login_details WHERE employeeCode=? AND password=?";
	public static final String getEmployeeDetails="select employeeCode,name,gender,departmentId,dateOfBirth,mobileNumber,emailId,address,roleId,status,createdBy,createdDate,modifiedBy,modifiedDate from tbl_employee_details where (?=0 OR employeeCode=?) AND (?=0 OR mobileNumber=?) AND (?=0 OR status=?) AND (?=0 OR roleId=?) AND (?=0 OR emailID=?) AND (?=0 OR departmentId=?) AND (?=0 OR name=?)";
	public static final String INSERT_EMPLOYEE_DETAILS_QRY = "INSERT INTO tbl_employee_details (name,departmentId,gender,dateOfBirth,mobileNumber,emailId,address,roleId,status,createdDate,createdBy)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	public static final String updateEmployeeDetails="UPDATE tbl_employee_details SET name=?,departmentId=?,gender=?,dateOfBirth=?, mobileNumber=?, emailId=?, address=?, status=?,modifiedBy=?, modifiedDate=? WHERE employeeCode=?";

	public static final String INSERT_LOGIN_DETAILS_QRY = "INSERT INTO  tbl_login_details values(?,?)";
	public static final String INSERT_EMPLOYEE_DETAILS_LOG_QRY = "INSERT INTO  tbl_employee_details_log (employeeCode,name,departmentId,gender,dateOfBirth,mobileNumber,emailId,address,roleId,status,createdDate,createdBy,modifiedDate,modifiedBy)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_BALANCE_QRY = "INSERT INTO tbl_balance(employeeCode,balance,createdBy,createdDate) VALUES (?,?,?,?)";
}