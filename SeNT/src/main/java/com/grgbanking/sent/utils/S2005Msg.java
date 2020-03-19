package com.grgbanking.sent.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class S2005Msg  extends DevBaseMessage {
	
	

	public byte[] packMessage() {
		
		byte[] bytes1 = integerToBytes(type,4);
		byte[] bytes2 = integerToBytes(length,4);
		byte[] bytes3 = integerToBytes(messageno,4);
		byte[] bytes4 = integerToBytes(devidLen,2);
		byte[] bytes5 = integerToBytes(synchType,2);
		byte[] bytes6 = integerToBytes(synchInfoLen,2);
		
		List<byte[]> byteList = new ArrayList<byte[]>();
		byteList.add(bytes1);
		byteList.add(bytes2);
		byteList.add(bytes3);
		byteList.add(bytes4);
		byteList.add(bytes5);
		byteList.add(bytes6);
	
		return bytesMerge(byteList);
		
	}
	public static void main(String[] args) {
		//String messageNo = String.valueOf(new Date().getTime()).substring(1, subLength);
		S2005Msg smsg = new S2005Msg();
		smsg.getReturnPack();
		
		
	}
	public R2005Msg getReturnPack()
	{
		S2005Msg smsg = new S2005Msg();
		String messageNo = String.valueOf(new Date().getTime()).substring(1, 13);
		smsg.setType(17);
		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
		//smsg.setDevid("00000001");
		smsg.setDevidLen(0);
		smsg.setLength(4);
		smsg.setSynchInfoLen(0);
		smsg.setSynchType(1);
		//smsg.setSynchInfoStr("");
		
		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();
		
		Transfer transfer=new Transfer();
		transfer.init();
		try
		{
			returnpack = transfer.sendPack(sendpack);
		}
		catch( IOException e )
		{
			logger.error("", e);
			returnpack = null;
		}

		if( returnpack == null )
		{
			return null;
		}
		else
		{
			R2005Msg rmsg = new R2005Msg();
			rmsg.unpackMessage(returnpack);
			return rmsg;
		}
		
	}
	

			
}
