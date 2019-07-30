package com.medplus.ems.helper;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.exception.EMSException;


public class TransactionServiceHelper {


	public static TransactionStatus getPreviousStatus(TransactionStatus currentStatus) throws EMSException
	{
		TransactionStatus previousStatus;
		if (currentStatus.equals(TransactionStatus.APPROVED)) {
			previousStatus=TransactionStatus.CREATED;
		} else if (currentStatus.equals(TransactionStatus.RECIEVED)) {
			previousStatus=TransactionStatus.APPROVED;
		} else if (currentStatus.equals(TransactionStatus.REJECTED)) {
			previousStatus=TransactionStatus.APPROVED;
		} else if (currentStatus.equals(TransactionStatus.CANCELLED)) {
			previousStatus=TransactionStatus.CREATED;
		} else {
			throw new EMSException("Invalid Change Of TransactionStatus");
		}
		return previousStatus;
		
	}
}


