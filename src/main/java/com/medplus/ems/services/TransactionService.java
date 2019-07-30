/**
 * 
 */
package com.medplus.ems.services;

import java.util.List;

import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;

/**
 * @author medplus
 *
 */

public interface TransactionService {
	/**
	 *
	 * @param transactionDetails
	 * @param userId
	 * @return transactionId
	 * @throws EMSException
	 * 
	 *             validate the fields whether null or not
	 *              insert status as created by considering EmployeeCode(userId)
	 *              then insert the details in the transaction table
	 *             get the transaction_id as return
	 *             if the insertion is failed then exception arises
	 * 
	 * 
	 */

	public int createTransaction(TransactionDetails transactionDetails, int userId) throws EMSException;

	/**
	 * 
	 * @param transactionid
	 * @param Transactionstatus
	 * @param userId
	 * @param comments
	 * @throws EMSException
	 * 
	 *             if status is in created state then it can be updated as approve/reject/delete using EmployeeCede(userId)
	 *             if status is in approved state then it can be updated as receive/deduct
	 *             we will update status in transaction table using userId 
	 *             TransactionStatus , Comments throws an exception if approved
	 *             if the updation is failed then exception arises
	 * 
	 */

	public void updateTransactionStatus(int transactionid, TransactionStatus status, int userId, String comments)
			throws EMSException;

	/**
	 * 
	 * @param searchTransaction
	 * @return list
	 * @throws EMSException
	 * 
	 *             validate searchTransaction fields are null --> if yes -- throw no records found
	 *             --> if no, for employee -- call Transaction dao-- get TransactionDetails 
	 *                        for account_manager -- call Transaction dao
	 * 
	 * 
	 */

	public List<TransactionDetails> getTransactionDetails(TransactionSearchCriteria transactionSearchCriteria)
			throws EMSException;

	/**
	 * 
	 * 
	 * @param userId
	 * @return balance
	 * 
	 * call balance dao -- get balance
	 * @throws EMSException 
	 * 
	 */

	public double getBalance(int employeeCode) throws EMSException;

	/**
	 * 
	 * @param userId
	 * @param amount
	 * @param transactionType
	 * 
	 *            when TransactionStatus is set to Receive, call Balance-- credit the amount
	 *            when TransactionStatus is set to Deduct, call Balance -- debit the amount
	 *            if balance doesnt update throws exception
	 * 
	 */
	
	public void editTransactionDetails(TransactionDetails transactionDetails,int userId) throws EMSException;
}