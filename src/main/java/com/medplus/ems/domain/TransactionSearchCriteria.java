/**
 * 
 */
package com.medplus.ems.domain;

import java.util.Date;

import lombok.Data;

/**
 * @author medplus
 *
 */
@Data
public class TransactionSearchCriteria {
	private int employeeCode;
	private TransactionStatus transactionStatus;
	private int transactionId;
	private TransactionType transactionType;
	private Date fromDate;
	private Date toDate;

}