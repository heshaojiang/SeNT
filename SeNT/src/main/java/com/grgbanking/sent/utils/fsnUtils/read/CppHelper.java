package com.grgbanking.sent.utils.fsnUtils.read;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class CppHelper
{

	/**
	 * 按C++的格式读取
	 */
	public static short readShort(DataInputStream in) throws IOException
	{
		int b0 = in.readUnsignedByte();
		int b1 = in.readUnsignedByte();
		return (short)( b0 | (b1<<8) );
	}
	
	/**
	 * 按C++的格式读取
	 */
	public static int readInt(DataInputStream in) throws IOException
	{
		int b0 = in.readUnsignedByte();
		int b1 = in.readUnsignedByte();
		int b2 = in.readUnsignedByte();
		int b3 = in.readUnsignedByte();
		return (int)( b0 | (b1<<8) | (b2<<16) | (b3<<24) );
	}
	
	/**
	 * 按C++的格式写入
	 */
	public static void writeBytes(DataOutputStream out, byte[] b) throws IOException
	{
		out.write(b);
	}
	
	/**
	 * 按C++的格式写入
	 */
	public static void writeBytes(DataOutputStream out, byte[] b, int off, int len) throws IOException
	{
		out.write(b, off, len);
	}

	/**
	 * 按C++的格式写入
	 */
	public static void writeInt16(DataOutputStream out, int x) throws IOException
	{
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}

	/**
	 * 按C++的格式写入
	 */
	public static void writeInt32(DataOutputStream out, int x) throws IOException
	{
		out.writeInt((x & 0xFF) << 24 | (x & 0xFF00) << 8 | (x & 0xFF0000) >>> 8 | (x & 0xFF000000) >>> 24);
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) throws IOException
	{
		
	}
}
