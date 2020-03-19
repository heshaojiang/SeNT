package com.grgbanking.platform.core.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalHelper
{

	private static ThreadLocal<Map<Object, Object>> threadLocal = new ThreadLocal<Map<Object, Object>>()
	{
		protected Map<Object, Object> initialValue()
		{
			return new HashMap<Object, Object>();
		}
	};
	
	
	public static Object get(Object key)
	{
		return threadLocal.get().get(key);
	}
	
	public static void put(Object key, Object value)
	{
		threadLocal.get().put(key, value);
	}
	
	
	
	
}












