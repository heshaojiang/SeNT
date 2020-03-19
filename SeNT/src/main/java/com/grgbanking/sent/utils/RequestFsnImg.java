package com.grgbanking.sent.utils;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.utils.S2006Msg.SyncThread;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class RequestFsnImg extends BaseService{
	
	public int requestFsnImgNT(int type,String tranId,Transfer transfer) throws IOException{
		S2006Msg smsg = new S2006Msg();
		int length = 0;
		String messageNo = String.valueOf(new Date().getTime()).substring(1, 13);
		smsg.setType(type);
		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
		length += 4;
		smsg.setDevidLen(0);
		length += 2;
		smsg.setTranId(tranId);
		length += 2;
		smsg.setTranIdLen(tranId.length());
		length += tranId.length();
		smsg.setLength(length);
		
		byte[] sendpack = smsg.packMessage();
//		Transfer transfer = new Transfer();
//		transfer.initFRequestImg();
		transfer.initFRequestImg();
		byte[] tmp = transfer.sendPack(sendpack);
		int result = bytesToInt(subBytes(tmp, 14, 4));
		return result;
	}
	
	/**
	 * 截取字节数组
	 */
	protected byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}
	
	public void requestFsnImgBT(int type,String tranId,Transfer transfer){
		S2006Msg smsg = new S2006Msg();
		smsg.setType(type);
		smsg.setTranIdLen(tranId.length());
		smsg.setTranId(tranId);
		byte[] sendpack = smsg.packMessage();
//		Transfer transfer = new Transfer();
		transfer.init();
		SyncThread syncThread= smsg.new SyncThread();
		syncThread.transfer = transfer;
		syncThread.sendpack = sendpack;
		syncThread.start();
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
	
}
