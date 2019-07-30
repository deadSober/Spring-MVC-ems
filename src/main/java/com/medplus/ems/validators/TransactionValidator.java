package com.medplus.ems.validators;

import com.medplus.ems.constants.ErrorConstants;
import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;

public class TransactionValidator {
	public static void validateTransactionDetails(TransactionDetails transactionDetails) throws EMSException {
		CommonValidator.validate(transactionDetails, ErrorConstants.INVALID_TRANSACTION_DETAILS);
		CommonValidator.validateInt(transactionDetails.getEmployeeCode(), ErrorConstants.INVALID_EMPLOYEE_CODE);
		CommonValidator.validateString(transactionDetails.getReason(), ErrorConstants.INVALID_TRANSACTION_REASON);
		CommonValidator.validateDouble(transactionDetails.getAmount(), ErrorConstants.INVALID_TRANSACTION_AMOUNT);
		CommonValidator.validate(transactionDetails.getTransactionType(), ErrorConstants.INVALID_TRANSACTION_TYPE);
		CommonValidator.validateString(transactionDetails.getComments(), ErrorConstants.INVALID_TRANSACTION_COMMENTS);
	}
	public static void validateEditTransaction(TransactionDetails transactionDetails) throws EMSException
	{
	CommonValidator.validate(transactionDetails,ErrorConstants.INVALID_TRANSACTION_DETAILS);
	CommonValidator.validateInt(transactionDetails.getTransactionId(),ErrorConstants.INVALID_TRANSACTION_ID);
	CommonValidator.validateInt(transactionDetails.getEmployeeCode(),ErrorConstants.INVALID_EMPLOYEE_CODE);
	CommonValidator.validateString(transactionDetails.getReason(),ErrorConstants.INVALID_TRANSACTION_REASON);
	CommonValidator.validateDouble(transactionDetails.getAmount(),ErrorConstants.INVALID_TRANSACTION_AMOUNT);
	CommonValidator.validate(transactionDetails.getTransactionType(),ErrorConstants.INVALID_TRANSACTION_TYPE);
	}
	public static void TransactionSearchValidate(TransactionSearchCriteria transactionSearchCriteria) throws EMSException {
		int flag = 0;
		if ((transactionSearchCriteria.getEmployeeCode()!= 0)) {
			flag = 1;
		}
		if ((transactionSearchCriteria.getTransactionId() != 0)) {
			flag = 1;
		}
		if ((transactionSearchCriteria.getTransactionStatus() != null)) {
			flag = 1;
		}
		if ((transactionSearchCriteria.getTransactionType() !=null)) {
			flag = 1;
		}
		if(transactionSearchCriteria.getFromDate() !=null) {
			flag = 1;
		}
		if(transactionSearchCriteria.getToDate() !=null) {
			flag = 1;
		}
		if (flag == 0) {
			throw new EMSException("Fields cant be null");
		}

	}
	public static void validateGetBalance(int employeeCode) throws EMSException
	{
		CommonValidator.validateInt(employeeCode,ErrorConstants.INVALID_EMPLOYEE_CODE);
	}
	public static void validateUpdateBalance(int employeeCode, double amount, TransactionType transactionType, int userId) throws EMSException {
		CommonValidator.validateInt(employeeCode, ErrorConstants.INVALID_EMPLOYEE_CODE);
		CommonValidator.validateDouble(amount, ErrorConstants.INVALID_TRANSACTION_AMOUNT);
		CommonValidator.validate(transactionType, ErrorConstants.INVALID_TRANSACTION_TYPE);
		CommonValidator.validateInt(userId, ErrorConstants.INVALID_USERID);
	}
	public static void updateTransactionStatus(int transactionid, TransactionStatus status, int userId, String comments) throws EMSException
	{
	CommonValidator.validateInt(transactionid,ErrorConstants.INVALID_TRANSACTION_ID);
	CommonValidator.validate(status,ErrorConstants.INVALID_TRANSACTION_STATUS);
	CommonValidator.validateInt(userId,ErrorConstants.INVALID_EMPLOYEE_CODE);
	CommonValidator.validateString(comments,ErrorConstants.INVALID_TRANSACTION_COMMENTS);
	
	}

	

}
