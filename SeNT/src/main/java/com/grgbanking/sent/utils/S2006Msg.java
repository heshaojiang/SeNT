package com.grgbanking.sent.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class S2006Msg  extends DevBaseMessage {
	
	private int tranIdLen ;
	private String tranId ;
	
	public int getTranIdLen() {
		return tranIdLen;
	}
	public void setTranIdLen(int tranIdLen) {
		this.tranIdLen = tranIdLen;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public byte[] packMessage() {
		
		byte[] bytes1 = integerToBytes(type,4);
		byte[] bytes2 = integerToBytes(length,4);
		byte[] bytes3 = integerToBytes(messageno,4);
		byte[] bytes4 = integerToBytes(devidLen,2);
		
		byte[] bytes5 = integerToBytes(tranIdLen,2);
		byte[] bytes6 = charsToBytes(tranId.toCharArray());
		
		List<byte[]> byteList = new ArrayList<byte[]>();
		byteList.add(bytes1);
		byteList.add(bytes2);
		byteList.add(bytes3);
		byteList.add(bytes4);
		byteList.add(bytes5);
		byteList.add(bytes6);
	
		return bytesMerge(byteList);
		
	}
	
	public int bytesToInt(byte[] bRefArr) {
		int iOutcome = 0;
		byte bLoop;

		for (int i = 0; i < bRefArr.length; i++) {
			bLoop = bRefArr[i];
			iOutcome += (bLoop & 0xFF) << (8 * i);
		}
		return iOutcome;
	}
	
	class SyncThread extends Thread{
        public Transfer transfer;  
        public byte[] sendpack;

		    public void run(){ 
		    	try {
					byte[] tmp = transfer.sendPack(sendpack);
					int result = bytesToInt(tmp);
					System.out.println(result);
				} catch (IOException e) {
					System.out.println(e.getStackTrace());
				}
		    }
	}
	
	public static void main(String[] args) throws IOException {
		S2006Msg smsg = new S2006Msg();
		String messageNo = String.valueOf(new Date().getTime()).substring(1, 13);
		smsg.setType(21);
		smsg.setTranIdLen("123456".length());
		smsg.setTranId("123456");
		
		byte[] sendpack = smsg.packMessage();
		
		Transfer transfer = new Transfer();
		transfer.initFRequestImg();
//		SyncThread syncThread= smsg.new SyncThread();
//		syncThread.transfer = transfer;
//		syncThread.sendpack = sendpack;
//		syncThread.start();
		byte[] tmp = transfer.sendPack(sendpack);
		int result = smsg.bytesToInt(tmp);
	}
	
}
