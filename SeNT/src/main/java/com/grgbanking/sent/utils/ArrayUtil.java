package com.grgbanking.sent.utils;


public class ArrayUtil
{

	public static boolean isBlank(Object[] arr)
	{
		if( arr==null || arr.length==0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String[] toStringArray(Object[] arr)
	{
		if( isBlank(arr) )
		{
			return new String[0];
		}
		else
		{
			String[] sArr = new String[arr.length];
			for( int i=0; i<sArr.length; i++ )
			{
				sArr[i] = String.valueOf(arr[i]);
			}
			return sArr;
		}
	}
	
	public static String[] toStringArray(Object obj)
	{
		if( obj==null )
		{
			return new String[0];
		}
		else if( obj instanceof Object[] )
		{
			return toStringArray((Object[])obj);
		}
		else
		{
			throw new IllegalArgumentException("unsupport data type: "+obj.getClass());
		}
			
	}
	
	public static String toString(Object[] arr)
	{
		if( arr==null )
		{
			return "null";
		}
		if( arr.length==0 )
		{
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for( int i=0; i<arr.length; i++ )
		{
			if( i!=0 )
			{
				sb.append(", ");
			}
			sb.append(arr[i]);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static int calculateTotal(int[] datas)
	{
		int result = 0;
		for( int data : datas )
		{
			result += data;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Object[] arr = new Object[]{1, 2, 3};
		String[] sArr = toStringArray(arr);
		System.out.println(toString(arr));
		System.out.println(toString(sArr));
		
	}
}
