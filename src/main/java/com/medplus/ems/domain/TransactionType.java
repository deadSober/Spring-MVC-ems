/**
 * 
 */
package com.medplus.ems.domain;

/**
 * @author medplus
 *
 */
public enum TransactionType {
	CREDIT("C"), DEBIT("D");
	private final String type;

	private TransactionType(String type) {
		this.type = type;
	}

	public String getValue() {
		return type;
	}

	public static TransactionType getTransactionType(String type) {
		for (TransactionType t : TransactionType.values()) {
			if (t.getValue().equalsIgnoreCase(type)) {
				return t;
			}
		}
		return null;
	}
}
