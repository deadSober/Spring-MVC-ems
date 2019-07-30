/**
 * 
 */
package com.medplus.ems.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.medplus.ems.dao.UserDao;
import com.medplus.ems.dao.helpers.UserHelper;
import com.medplus.ems.dao.queries.UserQueries;
import com.medplus.ems.domain.Category;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.Gender;
import com.medplus.ems.exception.EMSException;

/**
 * @author medplus
 *
 */
@Repository
public class UserDaoImpl extends UserQueries implements UserDao {
	@Autowired
	JdbcTemplate emsJdbcTemplate;

	@Override
	public int getLoginDetails(int employeeCode, String password) throws EMSException {

		try {
			Object[] login = { employeeCode, password };
			int code = emsJdbcTemplate.queryForObject(getLoginDetails, login, Integer.class);
			return code;
		} catch (EmptyResultDataAccessException e) {
			throw new EMSException("No data found", e);
		}
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails(EmployeeSearchCriteria employeeSearchCriteria) throws EMSException {
		Object[] parameters=UserHelper.employeeSearchParameters(employeeSearchCriteria);
		List<EmployeeDetails> employeeDetailsList=emsJdbcTemplate.query(UserQueries.getEmployeeDetails, parameters,new ResultSetExtractor<List<EmployeeDetails>>() {

			@Override
			public List<EmployeeDetails> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				List<EmployeeDetails> list=new ArrayList<EmployeeDetails>();
			
				while(resultSet.next())
				{
					EmployeeDetails employeeDetails=new EmployeeDetails();
					employeeDetails.setEmployeeCode(resultSet.getInt("employeeCode"));
					employeeDetails.setName(resultSet.getString("name"));
					employeeDetails.setGender(Gender.getGenderStatus((resultSet.getString("gender"))));
					employeeDetails.setDepartmentId(resultSet.getString("DepartmentId").charAt(0));
					employeeDetails.setAddress(resultSet.getString("address"));
					employeeDetails.setEmailId(resultSet.getString("emailId"));
					employeeDetails.setCategory(Category.getCategory(resultSet.getString("roleId")));
					employeeDetails.setCreatedBy(resultSet.getInt("createdBy"));
					employeeDetails.setModifiedBy(resultSet.getInt("modifiedBy"));
					employeeDetails.setEmployeeStatus(EmployeeStatus.getEmployeeStatus(resultSet.getString("status")));
					employeeDetails.setDateOfBirth(resultSet.getDate("dateOfBirth"));
					employeeDetails.setCreatedDate(resultSet.getTimestamp("createdDate"));
					employeeDetails.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
					employeeDetails.setMobileNumber(Long.parseLong(resultSet.getString("mobileNumber")));
					list.add(employeeDetails);
				}
				return list;
			}
			
			
		});
			return employeeDetailsList;
	}

	@Override
	public void updateEmployee(EmployeeDetails employeeDetails) throws EMSException {
		try {
			Object[] update = { employeeDetails.getName(), Character.toString(employeeDetails.getDepartmentId()),
					employeeDetails.getGender().getValue(), employeeDetails.getDateOfBirth(),
					employeeDetails.getMobileNumber(), employeeDetails.getEmailId(), employeeDetails.getAddress(),
					employeeDetails.getEmployeeStatus().getValue(), employeeDetails.getModifiedBy(), new Date(),
					employeeDetails.getEmployeeCode() };
			emsJdbcTemplate.update(updateEmployeeDetails, update);
			createEmployeeLogDetails(employeeDetails.getEmployeeCode());
		} catch (Exception e) {
			e.printStackTrace();
			throw new EMSException("Updation unsucess", e);
		}

	}
	@Override
	public int createEmployeeDetails(EmployeeDetails employeeDetails, int userId) throws EMSException {
		try {
			Object[] createEmployeeParams = new Object[] { employeeDetails.getName(),
					Character.toString(employeeDetails.getDepartmentId()), employeeDetails.getGender().getValue(),
					employeeDetails.getDateOfBirth(), employeeDetails.getMobileNumber(), employeeDetails.getEmailId(),
					employeeDetails.getAddress(), employeeDetails.getCategory().getValue(),
					employeeDetails.getEmployeeStatus().getValue(), new Date(), userId };

			int[] createEmployeeTypes = new int[] { Types.VARCHAR, Types.CHAR, Types.CHAR, Types.DATE, Types.CHAR,
					Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.TIMESTAMP, Types.INTEGER };
			PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_EMPLOYEE_DETAILS_QRY,
					createEmployeeTypes);
			pscf.setReturnGeneratedKeys(true);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			int empcode = emsJdbcTemplate.update(pscf.newPreparedStatementCreator(createEmployeeParams), keyHolder);
			empcode = keyHolder.getKey().intValue();
			employeeDetails.setEmployeeCode(empcode);
			createEmployeeLogDetails(empcode);
			return empcode;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EMSException("Invalid Data", e);
		}
	}

	@Override
	public void insertEmployeeLoginDetails(int empcode, String password) {
		Object[] insertEmployeeLoginDetailsParams = new Object[] { empcode, password };
		int[] insertEmployeeLoginDetailsTypes = new int[] { Types.INTEGER, Types.VARCHAR };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_LOGIN_DETAILS_QRY,
				insertEmployeeLoginDetailsTypes);
		emsJdbcTemplate.update(pscf.newPreparedStatementCreator(insertEmployeeLoginDetailsParams));
	}

	private void createEmployeeLogDetails(int empcode) throws EMSException {
		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		employeeSearchCriteria.setEmployeeCode(empcode);

		List<EmployeeDetails> employeeDetailsList = getEmployeeDetails(employeeSearchCriteria);
		
		if (employeeDetailsList == null || employeeDetailsList.isEmpty() || employeeDetailsList.get(0) == null) {

			throw new EMSException("Employee Details Not Found");
		}
		EmployeeDetails employeeDetails = employeeDetailsList.get(0);
		Object[] createEmployeeLogParams = new Object[] { employeeDetails.getEmployeeCode(), employeeDetails.getName(),
				Character.toString(employeeDetails.getDepartmentId()), employeeDetails.getGender().getValue(),
				employeeDetails.getDateOfBirth(), employeeDetails.getMobileNumber(),
				employeeDetails.getEmailId(), employeeDetails.getAddress(), employeeDetails.getCategory().getValue(),
				employeeDetails.getEmployeeStatus().getValue(), new Date(employeeDetails.getCreatedDate().getTime()),
				employeeDetails.getCreatedBy(), employeeDetails.getModifiedDate(), employeeDetails.getModifiedBy() };
		int[] createEmployeeLogTypes = new int[] { Types.INTEGER, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.DATE,
				Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.TIMESTAMP, Types.INTEGER,
				Types.TIMESTAMP, Types.INTEGER };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_EMPLOYEE_DETAILS_LOG_QRY,
				createEmployeeLogTypes);
		emsJdbcTemplate.update(pscf.newPreparedStatementCreator(createEmployeeLogParams));	

	}


	@Override
	public void insertEmployeeBalance(int empcode, int userId) {
		Object[] insertEmployeeBalanceParams = new Object[] { empcode, 0, userId, new Date() };
		int[] insertEmployeeBalanceTypes = new int[] { Types.INTEGER, Types.DECIMAL, Types.INTEGER, Types.TIMESTAMP };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_BALANCE_QRY,
				insertEmployeeBalanceTypes);
		emsJdbcTemplate.update(pscf.newPreparedStatementCreator(insertEmployeeBalanceParams));

	}
	
}