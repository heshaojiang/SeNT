package com.grgbanking.sent.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImpFsnTitle
{
	// 文件头
	public final int HEAD_START[] = { 20, 10, 7, 26 };
	public final int HEAD_STRING[] = { 0, 1, 45, 83, 78, 111 };
	public final int HEAD_STRING1[] = { 0, 1, 46, 83, 78, 111 };
	public final int HEAD_END[] = { 0, 1, 2, 3 };

	// 包含冠字号码的总条数
	public int COUNTER = 0;
	public DataOutputStream out;

	public void writeInt16(int x) throws IOException
	{
		out.writeShort((x & 0xFF) << 8 | (x & 0xFF00) >>> 8);
	}

	// 写入int整数
	public void writeInt32(int x) throws IOException
	{
		out.writeInt((x & 0xFF) << 24 | (x & 0xFF00) << 8 | (x & 0xFF0000) >>> 8 | (x & 0xFF000000) >>> 24);
	}

	// 写入int数组
	public void writeIntArr16(int x[]) throws IOException
	{
		for( int i = 0 ; i < x.length ; i++ )
		{
			int a = x[i];
			writeInt16(a);
		}
	}

	public ImpFsnTitle(OutputStream out)
	{

		this.out = new DataOutputStream(out);
	}

	public ImpFsnTitle()
	{

	}

}
