package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;



/**
 * @author yt
 *
 */
public class R2002Msg extends BaseMessage {

	private String checkresult = "\0\0\0\0\0\0\0\0\0\0\0\0"; // //�������� 12
     final int size=256;
	private String filepath = getBlank(size);
	/**
	 *@return String
	 */
	public String getCheckresult() {
		return getValue(checkresult);
	}
	/**得到路径
	 *@return String 
	 */
	public String getFilepath() {
		return getValue(filepath);
	}
	/**设置结果
	 *@param checkresult checkresult
	 */
	public void setCheckresult(String checkresult) {
		checkresult += "\0\0\0\0\0\0\0\0\0\0\0\0";
		 final int subStr=12;
		this.checkresult = checkresult.substring(0, subStr);
	}
	
	/**设值
	 *@param  filepath filepath
	 */ 
	public void setFilepath(String filepath) {
		final int size=256;
		filepath += getBlank(size);
		this.filepath = filepath.substring(0, size);
	}
	/**
	 *@param  msg msg
	 */
	public void unpackMessage(byte[] msg)
	{
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

		message = ArrayUtils.subarray(message, endStr, msgHead.length());

		telno = new String(ArrayUtils.subarray(message, 0, a));

		message = ArrayUtils.subarray(message,b, message.length);

		ttyp = new String(ArrayUtils.subarray(message, 0, endStr));

		message = ArrayUtils.subarray(message, c, message.length);

		devid = new String(ArrayUtils.subarray(message, 0, endStr));

		message = ArrayUtils.subarray(message, c, message.length);

		ogcd = new String(ArrayUtils.subarray(message, 0, a));

		message = ArrayUtils.subarray(message, b, message.length);

		messageno = new String(ArrayUtils.subarray(message, 0, a));

		message = ArrayUtils.subarray(message, b, message.length);

		retcode = new String(ArrayUtils.subarray(message, 0, a));

		message = ArrayUtils.subarray(message, b, message.length);

		checkresult = new String(ArrayUtils.subarray(message, 0, a));

		message = ArrayUtils.subarray(message, b, message.length);

		filepath = new String(ArrayUtils.subarray(message, 0, size));

	}
	/**
	 *@return char
	 */
	public char[] packMessage() {
		
		// char[] msgHead = "01030070".toCharArray();
		char[] txcode = "2002".toCharArray();
		char[] length = "0340".toCharArray();
		char[] code1 = telno.toCharArray();
		char[] code2 = ttyp.toCharArray();
		char[] code3 = devid.toCharArray();
		char[] code4 = ogcd.toCharArray();
		char[] code5 = messageno.toCharArray();

		char[] code6 = retcode.toCharArray();
		char[] code7 = checkresult.toCharArray();
		char[] code8 = filepath.toCharArray();

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
		msg = ArrayUtils.addAll(msg, code7);
		msg = ArrayUtils.add(msg, endSign);
		msg = ArrayUtils.addAll(msg, code8);
		msg = ArrayUtils.add(msg, endSign);
	
		
		logger.info("send :" + new String((msg)));
		
		return msg;
	}

}
