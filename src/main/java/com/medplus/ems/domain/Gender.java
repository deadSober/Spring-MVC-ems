package com.medplus.ems.domain;

public enum Gender {
	MALE("M"), FEMALE("F");
	private final String status;

	Gender(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static Gender getGenderStatus(String status) {
		for (Gender e : Gender.values()) {
			if (e.getValue().equalsIgnoreCase(status)) {
				return e;
			}
		}
		return null;
	}
}