package com.medplus.ems.services;

import static org.junit.Assert.assertTrue;

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


@Ignore
public class UpdateTransactionStatusTest {

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ems-servlet.xml");

	@Test
	public void userChangingStatusToCancel() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(8, TransactionStatus.CANCELLED, 1, "User Has Cancelled");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(8);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(TransactionStatus.CANCELLED.equals(transactionDetails.getTransactionStatus()));
	}

	@Test(expected = EMSException.class)
	public void userAgainChangingStatusToCancel() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(8, TransactionStatus.CANCELLED, 1, "User Has Cancelled");

	}

	@Test(expected = EMSException.class)
	public void userChangingStatus() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(7, TransactionStatus.APPROVED, 1, "User Changing the status");

	}
	@Test
	public void aMChangingStatusCTA() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(7, TransactionStatus.APPROVED, 15, "Account Manager Changing the status");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(7);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(TransactionStatus.APPROVED.equals(transactionDetails.getTransactionStatus()));
	}
	@Test(expected = EMSException.class)
	public void aMAgainChangingStatusCTA() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(7, TransactionStatus.APPROVED, 15, "Account Manager Again Changing the status");

	}
	@Test(expected = EMSException.class)
	public void aMChangingStatusCTR() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(1, TransactionStatus.RECIEVED, 15, "User Changing the status");

	}

	@Test
	public void aMChangingStatusATR() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(7, TransactionStatus.RECIEVED, 15, "Account Manager Changing the status");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(7);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(TransactionStatus.RECIEVED.equals(transactionDetails.getTransactionStatus()));
	}
	@Test(expected = EMSException.class)
	public void aMAgainChangingStatusATR() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(7, TransactionStatus.RECIEVED, 15, "Account Manager Again Changing the status");

	}

	@Test
	public void aMChangingStatusATRJ() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(6, TransactionStatus.REJECTED, 15, "Account Manager Changing the status");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(6);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(TransactionStatus.REJECTED.equals(transactionDetails.getTransactionStatus()));
	}
	@Test(expected = EMSException.class)
	public void aMAgainChangingStatusATRJ() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(6, TransactionStatus.REJECTED, 15, "Account Manager Again Changing the status");

	}

	@Test
	public void aMChangingStatusCTCA() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(1, TransactionStatus.CANCELLED,15, "Account Manager Changing the status");
		TransactionDetails transactionDetails = null;
		TransactionSearchCriteria transactionSearch = new TransactionSearchCriteria();
		transactionSearch.setTransactionId(7);
		List<TransactionDetails> list = transactionService.getTransactionDetails(transactionSearch);
		for (TransactionDetails t : list) {
			transactionDetails=t;
		}
		assertTrue(TransactionStatus.CANCELLED.equals(transactionDetails.getTransactionStatus()));
	}
	@Test(expected = EMSException.class)
	public void aMAgainChangingStatusCTCA() throws EMSException {
		TransactionServiceImpl transactionService = (TransactionServiceImpl) applicationContext
				.getBean("TransactionServiceImpl");
		transactionService.updateTransactionStatus(1, TransactionStatus.CANCELLED, 15, "Account Manager Again Changing the status");

	}
}
