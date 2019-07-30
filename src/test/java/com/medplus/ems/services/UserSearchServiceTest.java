package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.Category;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.EmployeeStatus;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.UserServiceImpl;

@Ignore
public class UserSearchServiceTest {
	
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ems-servlet.xml");
	@Test
	public void searchTest1() throws EMSException {
		System.out.println("Test Number:1");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(1);
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getEmployeeCode()==1));
		}
		
	}
	@Test
	public void searchTest2() throws EMSException {
		System.out.println("Test Number:2");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setName("admin");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
		assertTrue(!list.isEmpty());
	}
	@Test
	public void searchTest3() throws EMSException {
		System.out.println("Test Number:3");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(1);
		search.setName("admin");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getEmployeeCode()==1)&&(e.getName().equals("admin")));
		}
		
	}
	@Test
	public void searchTest4() throws EMSException {
		System.out.println("Test Number:4");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setName("admin");
		search.setEmailId("adin@medplus.com");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getName().equals("admin"))&&(e.getEmailId().equals("adin@medplus.com")));
		}
		
	}
	@Test(expected=EMSException.class)
	public void searchTest5() throws EMSException {
		System.out.println("Test Number:5");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		
	}
	@Test(expected=EMSException.class)
	public void searchTest6() throws EMSException {
		System.out.println("Test Number:6");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setName("admin1");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		
	}
	@Test(expected=EMSException.class)
	public void searchTest7() throws EMSException {
		System.out.println("Test Number:7");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setName("admin");
		search.setEmailId("adin@medplus");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	
	}
	@Test
	public void searchTest8() throws EMSException {
		System.out.println("Test Number:8");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setCategory(Category.getCategory("A"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
		assertTrue(!list.isEmpty());
	}
	@Test(expected=EMSException.class)
	public void searchTest9() throws EMSException {
		System.out.println("Test Number:9");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setCategory(Category.getCategory("E"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
	@Test(expected=EMSException.class)
	public void searchTest10() throws EMSException {
		System.out.println("Test Number:10");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setMobileNumber(55L);
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	
	}
	@Test(expected=EMSException.class)
	public void searchTest11() throws EMSException {
		System.out.println("Test Number:11");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setMobileNumber(9876543291L);;
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
	@Test
	public void searchTest12() throws EMSException {
		System.out.println("Test Number:12");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setMobileNumber(9876543290L);;
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
	}
	@Test(expected=EMSException.class)
	public void searchTest13() throws EMSException {
		System.out.println("Test Number:13");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setMobileNumber(4876543290L);;
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
	}
	@Test
	public void searchTest14() throws EMSException {
		System.out.println("Test Number:14");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setCategory(Category.getCategory("A"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
		assertTrue(!list.isEmpty());
	}
	@Test(expected=EMSException.class)
	public void searchTest15() throws EMSException {
		System.out.println("Test Number:15");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(56);
		search.setCategory(Category.getCategory("A"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
	@Test
	public void searchTest16() throws EMSException {
		System.out.println("Test Number:16");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('A');
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
		assertTrue(!list.isEmpty());
	}
	@Test
	public void searchTest17() throws EMSException {
		System.out.println("Test Number:17");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setDepartmentId('A');
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			System.out.println(e);
		}
		assertTrue(!list.isEmpty());
	}
	@Test(expected=EMSException.class)
	public void searchTest18() throws EMSException {
		System.out.println("Test Number:18");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setDepartmentId('S');
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
	@Test(expected=EMSException.class)
	public void searchTest19() throws EMSException {
		System.out.println("Test Number:19");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('S');
		search.setEmailId("adin@medplus.com");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
	@Test
	public void searchTest20() throws EMSException {
		System.out.println("Test Number:20");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('A');
		search.setEmailId("adin@medplus.com");
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getEmployeeCode()==5)&&(e.getDepartmentId()=='A')&&(e.getEmailId().equals("adin@medplus.com")&&(e.getName().equals("admin"))));
		}
		assertTrue(!list.isEmpty());
	}
	@Test
	public void searchTest21() throws EMSException {
		System.out.println("Test Number:21");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('A');
		search.setEmailId("adin@medplus.com");
		search.setName("admin");
		search.setMobileNumber(9876543290L);
		search.setCategory(Category.getCategory("A"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getEmployeeCode()==5)&&(e.getDepartmentId()=='A')&&(e.getEmailId().equals("adin@medplus.com")&&(e.getName().equals("admin"))));
		}
		
	}
	@Test
	public void searchTest22() throws EMSException {
		System.out.println("Test Number:22");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('A');
		search.setEmailId("adin@medplus.com");
		search.setName("admin");
		search.setMobileNumber(9876543290L);
		search.setCategory(Category.getCategory("A"));
		search.setEmployeeStatus(EmployeeStatus.getEmployeeStatus("A"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
		for (EmployeeDetails e : list) {
			assertTrue((e.getEmployeeCode()==5)&&(e.getDepartmentId()=='A')&&(e.getEmailId().equals("adin@medplus.com")&&(e.getName().equals("admin"))));
		}
		
	}
	@Test(expected=EMSException.class)
	public void searchTest23() throws EMSException {
		System.out.println("Test Number:23");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
		EmployeeSearchCriteria search = new EmployeeSearchCriteria();
		search.setEmployeeCode(5);
		search.setDepartmentId('A');
		search.setEmailId("adin@medplus.com");
		search.setName("admin");
		search.setMobileNumber(9876543290L);
		search.setCategory(Category.getCategory("A"));
		search.setEmployeeStatus(EmployeeStatus.getEmployeeStatus("I"));
		List<EmployeeDetails> list = userService.getEmployeeDetails(search);
	}
}
