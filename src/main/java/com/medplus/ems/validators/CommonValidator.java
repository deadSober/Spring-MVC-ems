/**
 * 
 */
package com.medplus.ems.validators;

import java.util.regex.Pattern;

import com.medplus.ems.exception.EMSException;

/**
 * @author medplus
 *
 */
public class CommonValidator {
	public static void validate(Object object, String message) throws EMSException {
		if (object == null) {
			throw new EMSException(message);
		}
	}

	public static void validateInt(int number, String message) throws EMSException {
		if (number <= 0) {
			throw new EMSException(message);
		}
	}

	public static void validateString(String string, String message) throws EMSException {
		if (string == null || string.trim().isEmpty()) {
			throw new EMSException(message);
		}
	}

	public static void validateEmailId(String emailId, String message) throws EMSException {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (!pat.matcher(emailId).matches()) {
			throw new EMSException(message);
		}
	}

	public static void validateName(String name, String message) throws EMSException {
		if (!(name.matches("^[a-zA-Z]*$"))) {
			throw new EMSException(message);
		}
	}

	public static void validateMobileNumber(long mobileNumber, String message) throws EMSException {
		Long number = mobileNumber;

		if (!number.toString().matches("^[6-9][0-9]{9}$")) {
			throw new EMSException(message);
		}
	}

	public static void validateDouble(double number, String message) throws EMSException {

		if (number <= 0) {
			throw new EMSException(message);
		}
	}
	public static void validateChar(char character, String message) throws EMSException {
		if (character == ' ') {
			throw new EMSException(message);
		}
	}
}
