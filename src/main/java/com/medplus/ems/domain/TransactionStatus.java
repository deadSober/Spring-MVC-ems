/**
 * 
 */
package com.medplus.ems.domain;

/**
 * @author medplus
 *
 */
public enum TransactionStatus {
	CREATED("C"), APPROVED("A"), REJECTED("R"), CANCELLED("X"), RECIEVED("P");
	private final String status;

	private TransactionStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static TransactionStatus getTransactionStatus(String status) {
		for (TransactionStatus t : TransactionStatus.values()) {
			if (t.getValue().equalsIgnoreCase(status)) {
				return t;
			}
		}
		return null;
	}
}