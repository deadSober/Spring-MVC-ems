/**
 * 
 */
package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.services.impl.TransactionServiceImpl;

/**
 * @author medplus
 *
 */
@Ignore
public class TransactionSearchTest {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ems-servlet.xml");
	@Test
	public void transactionSearchTest1() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setEmployeeCode(3);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue((transactionDetails.getEmployeeCode()==3));
		
	}
	@Test
	public void transactionSearchTest2() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(12342);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue((transactionDetails.getEmployeeCode()==3));
		
	}
	@Test
	public void transactionSearchTest3() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionStatus(TransactionStatus.CREATED);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue((transactionDetails.getEmployeeCode()==3));
		
	}
	@Test
	public void transactionSearchTest4() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionType(TransactionType.CREDIT);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue((transactionDetails.getEmployeeCode()==3));
		
	}
	@Test
	public void transactionSearchTest5() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionType(TransactionType.DEBIT);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue((transactionDetails.getEmployeeCode()==2));
	}
	@Test
	public void transactionSearchTest6() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setFromDate(new Date());
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
	}
	@Test(expected=EMSException.class)
	public void transactionSearchTest7() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setEmployeeCode(3);
		transactionSearch.setTransactionType(TransactionType.DEBIT);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
	}
	@Test(expected=EMSException.class)
	public void transactionSearchTest8() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setEmployeeCode(3);
		transactionSearch.setTransactionStatus(TransactionStatus.CANCELLED);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
	}
	@Test
	public void transactionSearchTest9() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionType(TransactionType.CREDIT);
		transactionSearch.setTransactionStatus(TransactionStatus.CREATED);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
	}
	@Test
	public void transactionSearchTest10() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionType(TransactionType.CREDIT);
		transactionSearch.setTransactionStatus(TransactionStatus.CREATED);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(transactionDetails.getEmployeeCode()==3);
	}
	@Test
	public void transactionSearchTest11() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext.getBean("TransactionServiceImpl");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionStatus(TransactionStatus.CREATED);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(transactionDetails.getAmount()==120);
	}
}
