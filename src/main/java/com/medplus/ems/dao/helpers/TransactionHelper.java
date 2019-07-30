/**
 * 
 */
package com.medplus.ems.dao.helpers;

import java.util.Date;

import com.medplus.ems.domain.TransactionSearchCriteria;

/**
 * @author medplus
 *
 */
public class TransactionHelper {
	public static Object[] transactionSearchParameters(TransactionSearchCriteria transactionSearchCriteria) {
		int codeFlag = 0;
		int employeeCode = 0;
		if ((transactionSearchCriteria.getEmployeeCode() != 0)) {
			employeeCode = transactionSearchCriteria.getEmployeeCode();
			codeFlag = 1;
		}
		int transactionIdFlag = 0;
		int transactionId = 0;
		if ((transactionSearchCriteria.getTransactionId() != 0)) {
			transactionId = transactionSearchCriteria.getTransactionId();
			transactionIdFlag = 1;
		}
		int transactionStatusFlag = 0;
		String transactionStatus = null;
		if ((transactionSearchCriteria.getTransactionStatus() != null)) {
			transactionStatus = transactionSearchCriteria.getTransactionStatus().getValue();
			transactionStatusFlag = 1;
		}
		int transactionTypeFlag = 0;
		String transactionType = null;
		if ((transactionSearchCriteria.getTransactionType() != null)) {
			transactionType = transactionSearchCriteria.getTransactionType().getValue();
			transactionTypeFlag = 1;
		}
		int fromDateFlag=0;
		Date fromDate =null;
		if(transactionSearchCriteria.getFromDate() !=null) {
		fromDate=transactionSearchCriteria.getFromDate();
		}
		int toDateFlag=0;
		Date toDate=null;
		if(transactionSearchCriteria.getToDate() !=null) {
		toDate=transactionSearchCriteria.getFromDate();
		}
		Object[] transactionParameters = {codeFlag,employeeCode, transactionIdFlag,transactionId, transactionStatusFlag, transactionStatus,
				transactionTypeFlag,transactionType,fromDateFlag,fromDate,toDateFlag,toDate};
	return transactionParameters;

	}
}
