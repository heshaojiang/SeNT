package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;

public class R2005Msg extends DevBaseMessage{
	protected String retcode = "\0\0\0\0";//4

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		final int a = 4;
		retcode+="\0\0\0\0";
		this.retcode = retcode.substring(0, a);
	}
	public void unpackMessage(byte[] msg) {
			String msgHead = new String(bytesToChars(msg));
		    final int subStar=4;
		    final int endStr=8;
			final int a=12;
			final int b=13;
			final int c=9;
			final int size=256;
			logger.error("received:",msgHead);
			int msgLength = Integer.parseInt(msgHead.substring(subStar,endStr));

			if (msgLength != (msg.length - endStr)) {
				
				return;
			}

			char[] message = bytesToChars(msg);

//			message = ArrayUtils.subarray(message, endStr, msgHead.length());
//
//			devid = new String(ArrayUtils.subarray(message, 0, a));
//
//			message = ArrayUtils.subarray(message,b, message.length);
//
//			devidLen = new String(ArrayUtils.subarray(message, 0, endStr));
//
//			message = ArrayUtils.subarray(message, c, message.length);
//
//			devid = new String(ArrayUtils.subarray(message, 0, endStr));
//
//			message = ArrayUtils.subarray(message, c, message.length);
//
//			messageno = new String(ArrayUtils.subarray(message, 0, a));

			//message = ArrayUtils.subarray(message, b, message.length);

			//retcode = new String(ArrayUtils.subarray(message, 0, a));

/*			message = ArrayUtils.subarray(message, b, message.length);

			checkresult = new String(ArrayUtils.subarray(message, 0, a));

			message = ArrayUtils.subarray(message, b, message.length);

			filepath = new String(ArrayUtils.subarray(message, 0, size));*/

		}
		/**
		 *@return char
		 */
		public char[] packMessage() {
			
			// char[] msgHead = "01030070".toCharArray();

			//char[] code7 = checkresult.toCharArray();
			//char[] code8 = filepath.toCharArray();

			//char[] msg = ArrayUtils.addAll(txcode, length);

	/*		msg = ArrayUtils.addAll(msg, code1);
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
			msg = ArrayUtils.addAll(msg, code7);
			msg = ArrayUtils.add(msg, endSign);
			msg = ArrayUtils.addAll(msg, code8);
			msg = ArrayUtils.add(msg, endSign);*/
		
			
			//logger.info("send :" + new String((msg)));
			
			return null;
		}

	}
