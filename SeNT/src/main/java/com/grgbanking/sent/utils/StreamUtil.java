package com.grgbanking.sent.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.grgbanking.platform.core.exception.SysException;

public class StreamUtil
{
	
	public static void close( InputStream in )
	{
		if( in!=null )
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				throw new SysException(e);
			}
		}
	}
	
	public static void close( OutputStream out )
	{
		if( out!=null )
		{
			try
			{
				out.close();
			}
			catch (IOException e)
			{
				throw new SysException(e);
			}
		}
	}

}
