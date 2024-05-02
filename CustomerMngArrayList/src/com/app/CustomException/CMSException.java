package com.app.CustomException;

@SuppressWarnings("serial")
public class CMSException extends Exception {
	public CMSException(String errMesg) {
		super(errMesg);
	}
}
