package com.medplus.ems.domain;

public enum Category {
	 ADMIN("A"), ACCOUNT_MANAGER("M"), EMPLOYEE("E");
	private final String status;

	Category(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static Category getCategory(String status) {
		for (Category e : Category.values()) {
			if (e.getValue().equalsIgnoreCase(status)) {
				return e;
			}
		}
		return null;
	}
}