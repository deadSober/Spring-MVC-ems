/**
 * 
 */
package com.medplus.ems.exception;

/**
 * @author medplus
 *
 */
public class EMSException extends Exception {

	/**
	 * 
	 */
	public EMSException(String message, Throwable error) {
		super(message, error);

	}

	/**
	 * @param arg0
	 */
	public EMSException(String message) {
		super(message);
	}

}