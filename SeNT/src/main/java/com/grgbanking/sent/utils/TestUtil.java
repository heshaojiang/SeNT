package com.grgbanking.sent.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestUtil
{
	
	public static void printObject(Object obj)
	{
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printObject");
		if( obj==null )
		{
			System.out.println("::::null");
		}
		else
		{
			Class<?> clazz = obj.getClass();
			while( clazz!=null )
			{
				System.out.println("::::class : "+clazz.getName());
				Field[] fields = clazz.getDeclaredFields();
				for( Field field : fields )
				{
					try
					{
						boolean isAccessible = field.isAccessible();
						field.setAccessible(true);
						System.out.println(field.getName()+" : "+field.get(obj));
						field.setAccessible(isAccessible);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				clazz = clazz.getSuperclass();
			}
		}
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printObject");
	}
	
	/**
	 * 
	 */
	public static void printArray(Object[] arr)
	{
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printArray");
		int i=0;
		for( Object value : arr )
		{
			System.out.println("item("+(i)+"):	["+value+"]");
			i++;
		}
		System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
	}
	
	/**
	 * 
	 */
	public static void printList(List<Object> list)
	{
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printList");
		int i=0;
		for( Object value : list )
		{
			System.out.println("item("+(i)+"):	["+value+"]");
			i++;
		}
		System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static void printMap(Map map)
	{
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{printMap");
		Iterator<Entry<Object, Object>> iter = map.entrySet().iterator();
		int i=0;
		while( iter.hasNext() )
		{
			Entry<Object, Object> entry = iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("entry("+(i)+")	["+key+"]=["+value+"]");
			i++;
		}
		System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
	}
	
}
