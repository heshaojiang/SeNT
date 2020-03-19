package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author yt
 *
 */

public class R2001Msg extends BaseMessage {
		
	 /**
	  * @param msg msg
	  */
	public void unpackMessage(byte[] msg) {

		String msgHead = new String(bytesToChars(msg));
		final int a =4;
		final int b =8;
		final int c =12;
		final int d =9;
		final int e =13;
		int msgLength = Integer.parseInt(msgHead.substring(a, b));

		if (msgLength != (msg.length - b)) {
			
			return;
		}

		char[] message = bytesToChars(msg);

		message = ArrayUtils.subarray(message, b, msgHead.length());

		telno = new String(ArrayUtils.subarray(message, 0, c));

		message = ArrayUtils.subarray(message, e, message.length);

		ttyp = new String(ArrayUtils.subarray(message, 0, b));

		message = ArrayUtils.subarray(message, d, message.length);

		devid = new String(ArrayUtils.subarray(message, 0, b));

		message = ArrayUtils.subarray(message, b, message.length);

		ogcd = new String(ArrayUtils.subarray(message, 0, c));

		message = ArrayUtils.subarray(message, e, message.length);

		messageno = new String(ArrayUtils.subarray(message, 0, c));

		message = ArrayUtils.subarray(message, e, message.length);

		retcode = new String(ArrayUtils.subarray(message, 0, c));

	}
     /**
      * @return char
      */
	public char[] packMessage() {
		// char[] msgHead = "01030070".toCharArray();
		char[] txcode = "2001".toCharArray();
		char[] length = "0070".toCharArray();
		char[] code1 = telno.toCharArray();
		char[] code2 = ttyp.toCharArray();
		char[] code3 = devid.toCharArray();
		char[] code4 = ogcd.toCharArray();
		char[] code5 = messageno.toCharArray();

		char[] code6 = retcode.toCharArray();

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
		msg = ArrayUtils.addAll(msg, code6);
		msg = ArrayUtils.add(msg, endSign);

		return msg;
	}

}
