package com.grgbanking.exception;

import com.grgbanking.platform.core.exception.AppException;

@SuppressWarnings("serial")
public class SimpleAppException extends AppException
{

	public SimpleAppException(String message)
	{
		super(message, message);
	}

}
