package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;


/**
 * @author yt
 *
 */
public class S2001Msg extends BaseMessage {

	/*private String txdate = "\0\0\0\0\0\0\0\0";// 8位

	private String txtime = "\0\0\0\0";// 4位

	public void setTxdate(String txdate) {
		txdate += "\0\0\0\0\0\0\0\0";
		this.txdate = txdate.substring(0, 8);
	}

	public void setTxtime(String txtime) {
		txtime += "\0\0\0\0";
		this.txtime = txtime.substring(0, 4);
	}*/
   /**
    *@return byte 字节 
    */
	public byte[] packMessage() {
		// char[] msgHead = "01030070".toCharArray();
		char[] txcode = "2001".toCharArray();
		char[] length = "0057".toCharArray();
		char[] code1 = telno.toCharArray();
		char[] code2 = ttyp.toCharArray();
		char[] code3 = devid.toCharArray();
		char[] code4 = ogcd.toCharArray();
		char[] code5 = messageno.toCharArray();
		//char[] code6 = txdate.toCharArray();
		//char[] code7 = txtime.toCharArray();

		char[] msg = ArrayUtils.addAll(txcode, length);

		msg = ArrayUtils.addAll(msg, code1);
		msg = ArrayUtils.add(msg, endSign);
		msg = ArrayUtils.addAll(msg, code2);
		msg = ArrayUtils.add(msg, endSign);
		msg = ArrayUtils.addAll(msg, code3);
		msg = ArrayUtils.add(msg, endSign);
		msg = ArrayUtils.addAll(msg, code4);
		msg = ArrayUtils.add(msg, endSign);
		msg = ArrayUtils.addAll(msg, code5);
		msg = ArrayUtils.add(msg, endSign);
//		msg = ArrayUtils.addAll(msg, code6);
//		msg = ArrayUtils.add(msg, endSign);
//		msg = ArrayUtils.addAll(msg, code7);
//		msg = ArrayUtils.add(msg, endSign);

		

		return charsToBytes(msg);
	}

}
