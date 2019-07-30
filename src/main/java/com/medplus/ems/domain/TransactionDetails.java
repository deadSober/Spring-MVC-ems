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
public class TransactionDetails {
	private int transactionId;
	private int employeeCode;
	private TransactionType transactionType;
	private String reason;
	private TransactionStatus transactionStatus;
	private String comments;
	private double amount;
	private int createdBy;
	private Date createdDate;
	private int modifiedBy;
	private Date modifiedDate;

}