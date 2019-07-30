package com.medplus.ems.services;



import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.TransactionServiceImpl;
@Ignore
public class EditTransactionTest {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ems-servlet.xml");

	@Test
	public void editTransactionTest1() throws EMSException {
		System.out.println("Test Number:1");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(1);
		transactionDetails.setEmployeeCode(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("Yo");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(50);
		transactionService.editTransactionDetails(transactionDetails, 1);
		
		
	}
	@Test
	public void editTransactionTest2() throws EMSException {
		System.out.println("Test Number:1");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(2);
		transactionDetails.setEmployeeCode(2);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 1);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest3() throws EMSException {
		System.out.println("Test Number:3");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(2);
		transactionDetails.setEmployeeCode(2);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 2);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest4() throws EMSException {
		System.out.println("Test Number:4");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(2);
		transactionDetails.setEmployeeCode(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 50);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest5() throws EMSException {
		System.out.println("Test Number:5");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(2);
		transactionDetails.setEmployeeCode(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 50);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest6() throws EMSException {
		System.out.println("Test Number:6");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(3);
		transactionDetails.setEmployeeCode(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 1);;
		
		
	}
	@Test
	public void editTransactionTest7() throws EMSException {
		System.out.println("Test Number:7");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(1);
		transactionDetails.setEmployeeCode(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("55");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 7);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest8() throws EMSException {
		System.out.println("Test Number:8");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionId(1);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("21");
		transactionDetails.setComments("hey");
		transactionDetails.setAmount(100);
		transactionService.editTransactionDetails(transactionDetails, 7);;
		
		
	}
	@Test(expected=EMSException.class)
	public void editTransactionTest9() throws EMSException {
		System.out.println("Test Number:9");
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionService.editTransactionDetails(transactionDetails, 7);;
		
		
	}
}
