package com.medplus.ems.services;

import com.medplus.ems.exception.EMSException;

public interface EmailServices {
	public void sendEmail(String email, String message) throws EMSException;
}