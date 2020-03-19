package com.grgbanking.sent.utils;

public class ExceptionUtil
{

	
	public static void printException(Throwable ex)
	{
		System.out.println(ex);
		StackTraceElement[] traces = ex.getStackTrace();
		for( StackTraceElement trace : traces )
		{
			System.out.println("\tat "+trace);
		}
		if( ex.getCause()!=null )
		{
			printCauseException(ex.getCause());
		}
	}
	
	public static void printCauseException(Throwable ex)
	{
		System.out.println("Caused by: "+ex);
		StackTraceElement[] traces = ex.getStackTrace();
		for( StackTraceElement trace : traces )
		{
			System.out.println("\tat "+trace);
		}
		if( ex.getCause()!=null )
		{
			printCauseException(ex.getCause());
		}
	}
	
	public static void main(String[] args)
	{
		Throwable e1 = new Throwable();
		Throwable e2 = new Throwable(e1);
		printException(e2);
	}
	
}
