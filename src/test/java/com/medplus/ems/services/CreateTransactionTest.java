package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.TransactionServiceImpl;

@Ignore
public class CreateTransactionTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ems-servlet.xml");
	
	@Test
	public void createTransaction() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("Marriage");
		transactionDetails.setAmount(100);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		int transactionId = transactionService.createTransaction(transactionDetails, 1);
		assertTrue(transactionId > 0);
	}
	
	@Test(expected = EMSException.class)
	public void employeeCodeisEmpty() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("Marriage");
		transactionDetails.setAmount(100);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}

	@Test(expected = EMSException.class)
	public void TransactionTypeisNull() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		//transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("Marriage");
		transactionDetails.setAmount(100);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	@Test(expected = EMSException.class)
	public void ReasonisEmpty() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		//transactionDetails.setReason("Marriage");
		transactionDetails.setAmount(100);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	@Test(expected = EMSException.class)
	public void ReasonisNull() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("");
		transactionDetails.setAmount(100);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	@Test(expected = EMSException.class)
	public void AmountisZero() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("");
		transactionDetails.setAmount(0);
		transactionDetails.setComments("hey");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	@Test(expected = EMSException.class)
	public void CommentsareNull() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("");
		transactionDetails.setAmount(0);
		transactionDetails.setComments("");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	@Test(expected = EMSException.class)
	public void CommentsEmpty() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setEmployeeCode(106);
		transactionDetails.setTransactionType(TransactionType.CREDIT);
		transactionDetails.setReason("");
		transactionDetails.setAmount(0);
		//transactionDetails.setComments("");
		transactionDetails.setCreatedDate(new Date());
		transactionDetails.setCreatedBy(12);
		transactionService.createTransaction(transactionDetails, 1);
	}
	
	
}
