package com.medplus.ems.dao;


import java.util.List;

import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.exception.EMSException;

public interface TransactionDao {
	public int createTransaction(TransactionDetails transactionDetails,int userId) throws EMSException;
	public List<TransactionDetails> getTransactionDetails(TransactionSearchCriteria transactionSearchCriteria);
	public void editTransactionDetails(TransactionDetails transactionDetails,int userId) throws EMSException;
	public void updateBalance(int employeeCode, double amount, int userId);
	public double getBalanceAmount(int employeeCode) throws EMSException;
	void updateTransactionStatus(int transactionId, TransactionStatus status, String comments, int userId)
			throws EMSException;
}
