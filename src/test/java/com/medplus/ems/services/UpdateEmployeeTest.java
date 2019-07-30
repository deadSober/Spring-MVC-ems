/**
 * 
 */
package com.medplus.ems.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.Gender;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.UserServiceImpl;

/**
 * @author medplus
 *
 */
@Ignore
public class UpdateEmployeeTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ems-servlet.xml");

	@Test
	public void updateTest1() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("ajju");
		emp.setDepartmentId('S');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medplus.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest2() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(0);
		emp.setName("ajju");
		emp.setDepartmentId('S');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medplus.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);

	}

	@Test(expected = EMSException.class)
	public void updateTest3() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName(null);
		emp.setDepartmentId('D');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medplus.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest4() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId(' ');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medplus.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest5() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('P');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(1876453123l);
		emp.setEmailId("ajju@medpls.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest6() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('P');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajjumedpuls.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest7() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('S');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.ACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medpuls.com");
		emp.setAddress(null);
		userService.updateEmployee(emp, 1);
		assertTrue(emp.getModifiedBy() == 1);
	}

	@Test(expected = EMSException.class)
	public void updateTest8() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('D');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.INACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medpuls.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 2);
		assertTrue(emp.getModifiedBy() == 2);
	}

	@Test
	public void updateTest9() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('A');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.INACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medpuls.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertFalse(emp.getModifiedBy() == 2);
	}
	@Test
	public void updateTest10() throws EMSException {
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeDetails emp = new EmployeeDetails();
		emp.setEmployeeCode(2);
		emp.setName("AJ");
		emp.setDepartmentId('A');
		emp.setGender(Gender.MALE);
		emp.setDateOfBirth(new Date());
		emp.setEmployeeStatus(EmployeeStatus.INACTIVE);
		emp.setMobileNumber(9876453123l);
		emp.setEmailId("ajju@medpuls.com");
		emp.setAddress("asdsdfsdfgh");
		userService.updateEmployee(emp, 1);
		assertFalse(emp.getModifiedBy() == 2);
	}
}
