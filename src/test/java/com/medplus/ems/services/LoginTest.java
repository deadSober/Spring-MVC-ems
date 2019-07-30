/**
 * 
 */
package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.domain.LoginDetails;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.UserServiceImpl;


/**
 * @author medplus
 *
 */
@Ignore
public class LoginTest {
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ems-servlet.xml");
@Test
public void loginTest1() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(1);
	loginDetails.setPassword("admin");
	EmployeeDetails employee=userService.login(loginDetails);
	assertTrue(employee.getEmployeeStatus().equals(EmployeeStatus.ACTIVE));
	}

@Test(expected=EMSException.class)
public void loginTest2() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(0);
	loginDetails.setPassword("sdfg");
	userService.login(loginDetails);
	}

@Test(expected=EMSException.class)
public void loginTest3() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(0);
	loginDetails.setPassword(null);
	userService.login(loginDetails);
}

@Test(expected=EMSException.class)
public void loginTest4() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(2);
	loginDetails.setPassword("admin");
	userService.login(loginDetails);
}

@Test(expected=EMSException.class)
public void loginTest5() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(1);
	loginDetails.setPassword(null);
	userService.login(loginDetails);

}
@Test(expected=EMSException.class)
public void loginTest6() throws EMSException{
	UserServiceImpl userService=(UserServiceImpl)applicationContext.getBean("UserServiceImpl");
	LoginDetails loginDetails=new LoginDetails();
	loginDetails.setEmployeeCode(-2);
	loginDetails.setPassword("admin");
	userService.login(loginDetails);

}

}
