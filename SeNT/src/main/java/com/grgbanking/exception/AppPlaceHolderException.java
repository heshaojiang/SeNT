package com.grgbanking.exception;

import com.grgbanking.platform.core.exception.AppException;

@SuppressWarnings("serial")
public class AppPlaceHolderException extends AppException
{
	
	
	private Object[] placeHolders;
	
	public Object[] getPlaceHolders()
	{
		return placeHolders;
	}

	public AppPlaceHolderException(String msgKey, String logMessage, Object... placeHolders)
	{
		super(msgKey, replacePlaceHolder(logMessage, placeHolders));
		this.placeHolders = placeHolders;
	}
	
	private static String replacePlaceHolder(String logMessage, Object... placeHolders)
	{
		if( logMessage==null )
		{
			throw new IllegalArgumentException("logMessage cannot be null.");
		}
		if( placeHolders==null )
		{
			throw new IllegalArgumentException("placeHolders cannot be null.");
		}
		return String.format(logMessage, placeHolders);
	}

}
