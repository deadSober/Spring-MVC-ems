package com.medplus.ems.services.impl;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.ems.dao.UserDao;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.LoginDetails;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.UserService;
import com.medplus.ems.validators.UserValidator;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public EmployeeDetails login(LoginDetails loginDetails) throws EMSException {

		UserValidator.validateLoginDetails(loginDetails);
		int employeeCode = userDao.getLoginDetails(loginDetails.getEmployeeCode(), loginDetails.getPassword());

		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		employeeSearchCriteria.setEmployeeCode(employeeCode);

		List<EmployeeDetails> employeeDetails = getEmployeeDetails(employeeSearchCriteria);
		EmployeeDetails employeDetails = null;

		for (EmployeeDetails e1 : employeeDetails) {
			employeDetails = e1;
		}

		if (EmployeeStatus.ACTIVE.equals(employeDetails.getEmployeeStatus())) {
			return employeDetails;
		} else {
			throw new EMSException("User is InActive");
		}
	}

	@Override
	public int createEmployee(EmployeeDetails employeeDetails, int userId) throws EMSException {
		UserValidator.validateEmployeeDetails(employeeDetails);
		// employeeDetails.setCreatedBy(userId);
		int empcode = userDao.createEmployeeDetails(employeeDetails, userId);
		userDao.insertEmployeeBalance(empcode, userId);
		final String password = generateUserPassword(10);
		userDao.insertEmployeeLoginDetails(empcode, password);
		return empcode;
	}

	@Override
	public void updateEmployee(EmployeeDetails employeeDetails, int userId) throws EMSException {
		UserValidator.updateEmployeeValidate(employeeDetails, userId);
		employeeDetails.setModifiedBy(userId);
		userDao.updateEmployee(employeeDetails);

	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails(EmployeeSearchCriteria employeesearchcriteria) throws EMSException {
		List<EmployeeDetails> searchemployeelist = null;
	    UserValidator.employeeSearchValidate(employeesearchcriteria);
		searchemployeelist = userDao.getEmployeeDetails(employeesearchcriteria);
		if (searchemployeelist.isEmpty()) {
			throw new EMSException("No Records Found");
		}
		return searchemployeelist;
	}

	@Override
	public void changePassword(int userId, String currentPassword, String newPassword) throws EMSException {
		// TODO Auto-generated method stub

	}
	private static String generateUserPassword(int length) {
		final Random RANDOM = new SecureRandom();
		final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return returnValue.toString();
	}
	
}
