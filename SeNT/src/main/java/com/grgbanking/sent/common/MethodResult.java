package com.grgbanking.sent.common;

import java.util.HashMap;
import java.util.Map;

public class MethodResult
{

	private boolean success = true;
	
	private String message;
	
	private Map<String, Object> properties = new HashMap<String, Object>();

	
	
	

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Map<String, Object> getProperties()
	{
		return properties;
	}

	public void setProperties(Map<String, Object> properties)
	{
		this.properties = properties;
	}
	
	public Object getProperty(String key)
	{
		return properties.get(key);
	}
	
	public void setProperty(String key, Object value)
	{
		properties.put(key, value);
	}
}
