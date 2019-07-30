package com.medplus.ems.services;

//import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.TransactionServiceImpl;
//@Ignore
public class GetBalanceTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ems-servlet.xml");
	
	@Test
	public void getbal() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean(TransactionServiceImpl.class);
		transactionService.getBalance(1);
	}
	@Test(expected = EMSException.class)
	public void getbal1() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean(TransactionServiceImpl.class);
		transactionService.getBalance(212);
	}
	@Test(expected = EMSException.class)
	public void getbal2() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean(TransactionServiceImpl.class);
		transactionService.getBalance(0);
	}
	@Test(expected = EMSException.class)
	public void getbal3() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean(TransactionServiceImpl.class);
		transactionService.getBalance(-12);
	}
	@Test(expected = EMSException.class)
	public void getbal4() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean(TransactionServiceImpl.class);
		transactionService.getBalance(-0);
	}
}
