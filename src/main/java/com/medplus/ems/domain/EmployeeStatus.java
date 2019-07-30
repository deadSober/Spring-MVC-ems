package com.medplus.ems.domain;

public enum EmployeeStatus {
	ACTIVE("A"), INACTIVE("I");
	private final String status;

	EmployeeStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static EmployeeStatus getEmployeeStatus(String status) {
		for (EmployeeStatus e : EmployeeStatus.values()) {
			if (e.getValue().equalsIgnoreCase(status)) {
				return e;
			}
		}
		return null;
	}
}