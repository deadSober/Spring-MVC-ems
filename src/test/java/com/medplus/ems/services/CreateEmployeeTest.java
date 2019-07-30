package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.Category;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.Gender;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.UserServiceImpl;
@Ignore
public class CreateEmployeeTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ems-servlet.xml");

	@Test
	public void createemployeeTest() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(8985828484L);
		employeeDetails.setEmailId("ramasatyanarapasupuleti@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		int empcode = userService.createEmployee(employeeDetails, 1);
		assertTrue(empcode > 0);
	}

	@Test(expected = EMSException.class)
	public void mobileNumberIsZero() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("satya");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(0);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void nameisnull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void departmentIdisnull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('0');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void genderisnull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		// employeeDetails.setGender();
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void dateOfBirthisnull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		// employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void EmailIdisnull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		// employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void AddessisEmpty() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		// employeeDetails.setAddress("India");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void AddessisNull() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void CategoryisEmpty() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("jhbj");
		// employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void EmployeeStatusisEmpty() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("jhbj");
		employeeDetails.setCategory(Category.ADMIN);
		// employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void DateisEmpty() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("jhbj");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		// employeeDetails.setCreatedDate(new Date());
		employeeDetails.setCreatedBy(12);
		userService.createEmployee(employeeDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void CreatedByisEmpty() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("subha");
		employeeDetails.setDepartmentId('S');
		employeeDetails.setGender(Gender.FEMALE);
		employeeDetails.setDateOfBirth(new Date());
		employeeDetails.setMobileNumber(9887);
		employeeDetails.setEmailId("soiiioo@med.com");
		employeeDetails.setAddress("jhbj");
		employeeDetails.setCategory(Category.ADMIN);
		employeeDetails.setEmployeeStatus(EmployeeStatus.ACTIVE);
		employeeDetails.setCreatedDate(new Date());
		userService.createEmployee(employeeDetails, 1);
	}
}