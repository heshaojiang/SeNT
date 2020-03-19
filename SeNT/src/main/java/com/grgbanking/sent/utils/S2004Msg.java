package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author yt
 *
 */
public class S2004Msg extends BaseMessage {
 
	 final int starIndex=0;
	    final int strNum1=14;
	    final int strNum2=12;
		private String rcdate = "\0\0\0\0\0\0\0\0\0\0\0\0\0\0";// 14

		private String sequence = "\0\0\0\0\0\0\0\0\0\0\0\0";// 12
	   
		/**
	     * @param rcdate 
	     */
		public void setRcdate(String rcdate) {
			rcdate += "\0\0\0\0\0\0\0\0\0\0\0\0\0\0";//14位
			this.rcdate = rcdate.substring(starIndex, strNum1);
		}
	     /**
	      *@param sequence sequence
	      * 
	      */
		public void setSequence(String sequence) {
			sequence+="\0\0\0\0\0\0\0\0\0\0\0\0"; //12位
			this.sequence = sequence.substring(starIndex,strNum2);
		}
	    /**
	     * @return byte 字节
	     */
		public byte[] packMessage() {
			// char[] msgHead = "01030070".toCharArray();
			char[] txcode = "2004".toCharArray();
			char[] length = "0085".toCharArray
			();
			char[] code1 = telno.toCharArray();
			char[] code2 = ttyp.toCharArray();
			char[] code3 = devid.toCharArray();
			char[] code4 = ogcd.toCharArray();
			char[] code5 = messageno.toCharArray();
			char[] code6 = rcdate.toCharArray();
			char[] code7 = sequence.toCharArray();

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

			
			logger.error("send",msg);
			return charsToBytes(msg);
		}

	
}
