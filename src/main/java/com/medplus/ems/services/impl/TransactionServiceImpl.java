/**
 * 
 */
package com.medplus.ems.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.ems.dao.TransactionDao;
import com.medplus.ems.dao.UserDao;
import com.medplus.ems.domain.Category;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;
import com.medplus.ems.helper.TransactionServiceHelper;
import com.medplus.ems.services.TransactionService;
import com.medplus.ems.validators.TransactionValidator;


/**
 * @author medplus
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao transactionDao;
	@Autowired
	private UserDao userDao;

	@Override
	public int createTransaction(TransactionDetails transactionDetails, int userId) throws EMSException {
		TransactionValidator.validateTransactionDetails(transactionDetails);
		int transactionId = transactionDao.createTransaction(transactionDetails, userId);
		return transactionId;
	}

	@Override
	public void updateTransactionStatus(int transactionid, TransactionStatus status, int userId, String comments)
			throws EMSException {
		TransactionValidator.updateTransactionStatus(transactionid, status, userId, comments);
		TransactionDetails transactionDetails = validateStatusOfTransaction(transactionid, status);
		validateUpdateTransactionAuthorization(transactionDetails.getEmployeeCode(), status, userId);
		transactionDao.updateTransactionStatus(transactionid, status, comments, userId);
		if (TransactionStatus.RECIEVED.equals(status))
			updateBalance(transactionDetails.getEmployeeCode(), transactionDetails.getAmount(),
					transactionDetails.getTransactionType(), userId);
	}

	

	@Override
	public List<TransactionDetails> getTransactionDetails(TransactionSearchCriteria transactionSearchCriteria)
			throws EMSException {
	    TransactionValidator.TransactionSearchValidate(transactionSearchCriteria);
	    List<TransactionDetails> searchTransactionDetails = null;
	    searchTransactionDetails=transactionDao.getTransactionDetails(transactionSearchCriteria);
		if(searchTransactionDetails.isEmpty()) {
			throw new EMSException("No records found");
		}
		else {
			return searchTransactionDetails;
		}
	    
			}

	@Override
	public double getBalance(int employeeCode) throws EMSException {
		TransactionValidator.validateGetBalance(employeeCode);
		getBalanceAuthorization(employeeCode);
		double balance = transactionDao.getBalanceAmount(employeeCode);
		return balance;
	}
	

	@Override
	public void editTransactionDetails(TransactionDetails transactionDetails, int userId) throws EMSException {
		
		TransactionValidator.validateEditTransaction(transactionDetails);
		validateStatusForEditTransactionDetails(transactionDetails,TransactionStatus.CREATED);
		editTransactionDetailsAuthorization(transactionDetails,userId);
		transactionDao.editTransactionDetails(transactionDetails, userId);
		
	}
	
	private TransactionDetails validateStatusForEditTransactionDetails(TransactionDetails transaction,TransactionStatus status) throws EMSException
	{
		TransactionSearchCriteria transactionSearchCriteria=new TransactionSearchCriteria();
		transactionSearchCriteria.setTransactionId(transaction.getTransactionId());
		List<TransactionDetails> transactionDetailsList=transactionDao.getTransactionDetails(transactionSearchCriteria);
		if(transactionDetailsList==null||transactionDetailsList.isEmpty()||transactionDetailsList.get(0)==null)
		{
			throw new EMSException("No Records Found");
		}
		TransactionDetails transactionDetails=transactionDetailsList.get(0);
		if(!status.equals(transactionDetails.getTransactionStatus()))
		{
			throw new EMSException("Cannot change Transaction");
		}
		return transactionDetails;
		
	}
	
	private void editTransactionDetailsAuthorization(TransactionDetails transactionDetails, int userId)
			throws EMSException {
		if (userId != transactionDetails.getEmployeeCode()) {
			userAuthorizationCheck(userId, Category.ACCOUNT_MANAGER);

		}
	}

	private void userAuthorizationCheck(int userId, Category category) throws EMSException {
		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		employeeSearchCriteria.setEmployeeCode(userId);
		List<EmployeeDetails> EmployeeDetailsList = userDao.getEmployeeDetails(employeeSearchCriteria);
		if (EmployeeDetailsList == null || EmployeeDetailsList.isEmpty() || EmployeeDetailsList.get(0) == null) {
			throw new EMSException("Invalid Authorization");
		}
		if (!category.equals(EmployeeDetailsList.get(0).getCategory())) {
			throw new EMSException("Invalid Authorization");
		}
	}

	private void getBalanceAuthorization(int employeeCode) throws EMSException
	{
		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		employeeSearchCriteria.setEmployeeCode(employeeCode);

		List<EmployeeDetails> employeeDetailsList = userDao.getEmployeeDetails(employeeSearchCriteria);
		
		if (employeeDetailsList == null || employeeDetailsList.isEmpty() || employeeDetailsList.get(0) == null) {

			throw new EMSException("Invalid Employee");
		}
	}
	private void updateBalance(int employeeCode, double amount, TransactionType transactionType, int userId)
			throws EMSException {
		TransactionValidator.validateUpdateBalance(employeeCode, amount, transactionType, userId);
		userAuthorizationCheck(userId, Category.ACCOUNT_MANAGER);
		if (TransactionType.DEBIT.equals(transactionType)) {
			amount = amount * -1;
		}
		transactionDao.updateBalance(employeeCode, amount, userId);
		
	}
	private void validateUpdateTransactionAuthorization(int employeeCode, TransactionStatus status, int userId) throws EMSException {
		if (employeeCode == userId) {
			if (!(TransactionStatus.CANCELLED.equals(status))) {
				throw new EMSException("Invalid Change Of TransactionStatus");
			}

		} else {
			userAuthorizationCheck(userId, Category.ACCOUNT_MANAGER);
		}
		
	}

	private TransactionDetails validateStatusOfTransaction(int transactionId, TransactionStatus currentStatus) throws EMSException {
		TransactionStatus previousStatus =TransactionServiceHelper.getPreviousStatus(currentStatus);
		TransactionDetails transaction=new TransactionDetails();;
		transaction.setTransactionId(transactionId);
		TransactionDetails transactionDetails = validateStatusForEditTransactionDetails(transaction,previousStatus);
		return transactionDetails;
	}
		
	
}