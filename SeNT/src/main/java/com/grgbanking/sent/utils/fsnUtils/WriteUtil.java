package com.grgbanking.sent.utils.fsnUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class WriteUtil {

	public static void writeShort(short x, DataOutputStream out) throws IOException
	{
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}
	
	public static void writeByteArray(int x[], DataOutputStream out) throws IOException
	{
		for( int i = 0 ; i < x.length ; i++ )
		{
			int a = x[i];
			out.writeByte(a);
		}
	}
	
	public static void writeShortArray(short x[], DataOutputStream out) throws IOException
	{
		for( int i = 0 ; i < x.length ; i++ )
		{
			short a = x[i];
			writeShort(a, out);
		}
	}
	
	public static void writeInt16(int x, DataOutputStream out) throws IOException
	{
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}

	// 写入int整数
	public static void writeInt32(int x, DataOutputStream out) throws IOException
	{
		out.writeInt((x & 0xFF) << 24 | (x & 0xFF00) << 8 | (x & 0xFF0000) >>> 8 | (x & 0xFF000000) >>> 24);
	}

	// 写入int数组
	public static void writeInt16Array(int x[], DataOutputStream out) throws IOException
	{
		for( int i = 0 ; i < x.length ; i++ )
		{
			int a = x[i];
			writeInt16(a, out);
		}
	}

	// 写入 string
	public static void writeChars(String value, DataOutputStream out) throws IOException
	{
		out.writeChars(value);
	}
	
	public static DecimalFormat df = new DecimalFormat("00");
}
