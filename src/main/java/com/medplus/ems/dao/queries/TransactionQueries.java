package com.medplus.ems.dao.queries;

public class TransactionQueries {
	public static final String INSERT_TRANSACTION_DETAILS_QRY = "INSERT INTO tbl_transaction (employeeCode,status,transactionType,reason,amount,createdDate,createdBy) VALUES (?,?,?,?,?,?,?) ";
	public static final String INSERT_TRANSACTION_DETAILS_LOG_QRY = "INSERT INTO  tbl_transaction_log (transactionId,employeeCode,transactionType,reason,status,comments,amount,createdDate,createdBy,modifiedDate,modifiedBy) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String EDIT_TRANSACTION_DETAILS_QRY="update tbl_transaction set amount=?,reason=?,transactiontype=?,modifiedBy=?,modifiedDate=? where transactionId=? and status='C'";
	public static final String GET_BALANCE_QRY = "Select balance from tbl_balance where employeeCode=?";
	public static final String GET_TRANSACTION_DETAILS_QRY ="SELECT transactionId,employeeCode,transactionType,reason,status,comments,amount,createdBy,createdDate,modifiedBy,modifiedDate FROM tbl_transaction WHERE (?=0 OR employeeCode=?) AND (?=0 OR transactionId=?) AND (?=0 OR status=?) AND (?=0 OR transactionType=?) AND (?=0 OR createdDate>?) AND (?=0 OR createdDate<?)";
	public static final String UPDATE_BALANCE_QRY ="update tbl_balance set balance = balance + ?,modifiedBy = ?,modifiedDate = ? where employeeCode = ?";
	public static final String UPDATE_TRANSACTION_STATUS_QRY="update tbl_transaction set status=?,comments=?,modifiedBy=?,modifiedDate=? where transactionId=?";
}
