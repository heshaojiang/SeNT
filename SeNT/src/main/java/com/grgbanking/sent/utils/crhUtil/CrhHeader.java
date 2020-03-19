package com.grgbanking.sent.utils.crhUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.grgbanking.sent.utils.fsnUtils.WriteUtil;
import com.grgbanking.sent.utils.fsnUtils.read.CppHelper;

public class CrhHeader {
	public int headStart[] = { 20, 10, 7, 26 };
	public int headString[] = { 0, 1, 46, 83, 78, 111 };
	public int headEnd[] = { 0, 1, 2, 3 };
	public int counter = 0;
	
	
	
	public CrhHeader() {
		
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		WriteUtil.writeInt16Array(headStart, out);
		WriteUtil.writeInt16Array(headString, out);
		WriteUtil.writeInt32(counter, out);
		WriteUtil.writeInt16Array(headEnd, out);
	}	
	
	public void read( DataInputStream in ) throws IOException
	{
		// 读 headStart
		for( int i=0; i<headStart.length; i++ )
		{
			headStart[i] = CppHelper.readShort(in);
		}
		// 读 headString
		for( int i=0; i<headString.length; i++ )
		{
			headString[i] = CppHelper.readShort(in);
		}
		// 读 counter
		counter = CppHelper.readInt(in);
		// 读 headEnd
		for( int i=0; i<headEnd.length; i++ )
		{
			headEnd[i] = CppHelper.readShort(in);
		}
	}
	
	public int[] getHeadString() {
		return headString;
	}

	public void setHeadString(int[] headString) {
		this.headString = headString;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int[] getHeadStart() {
		return headStart;
	}

	public int[] getHeadEnd() {
		return headEnd;
	}
}
