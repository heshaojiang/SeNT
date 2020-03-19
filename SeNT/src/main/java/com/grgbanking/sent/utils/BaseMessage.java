package com.grgbanking.sent.utils;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * BaseMessage
 * @author 广电运通
 * @version :1.0 </br>
 */
/**
 * BaseMessage
 * @author 广电运通
 * @version :1.0 </br>
 */
public class BaseMessage {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected char endSign = '\0';

	protected String telno = "\0\0\0\0\0\0\0\0\0\0\0\0"; // 12

	protected String ttyp = "\0\0\0\0\0\0\0\0";// 8

	protected String devid = "\0\0\0\0\0\0\0\0";// 8

	protected String ogcd = "\0\0\0\0\0\0\0\0\0\0\0\0";// 12

	protected String messageno = "\0\0\0\0\0\0\0\0\0\0\0\0";// 12

	protected String retcode = "\0\0\0\0\0\0\0\0\0\0\0\0";// 12

	/**
	 * 	截取telno字段
	 *	@param  telno telno字段
	 */
	public void setTelno(String telno) {
		final int a= 12;
		telno += "\0\0\0\0\0\0\0\0\0\0\0\0";
		
		this.telno = telno.substring(0, a);
	}
	/**
	 * 	截取ttyp字段
	 *	@param  ttyp  ttyp字段
	 */
	public void setTtyp(String ttyp) {
		final int  a= 8 ;
		ttyp += "\0\0\0\0\0\0\0\0";
		this.ttyp = ttyp.substring(0, a);
	}
	/**
	 * 	截取devid字段
	 *	@param  devid devid字段
	 */
	public void setDevid(String devid) {
		final int a = 8 ;
		devid += "\0\0\0\0\0\0\0\0";
		this.devid = devid.substring(0, a);
	}
	/**
	 * 	截取ogcd字段
	 *	@param  ogcd ogcd字段
	 */
	public void setOgcd(String ogcd) {
		final  int   a = 12;
		ogcd += "\0\0\0\0\0\0\0\0\0\0\0\0";
		this.ogcd = ogcd.substring(0, a);
	}
	/**
	 * 	截取messageno字段
	 *	@param  messageno messageno字段
	 */
	public void setMessageno(String messageno) {
		final int a = 12; 
		messageno += "\0\0\0\0\0\0\0\0\0\0\0\0";
		this.messageno = messageno.substring(0, a);
	}
	/**
	 * 	截取retcode字段
	 *	@param  retcode retcode字段
	 */
	public void setRetcode(String retcode) {
		final int  a = 12; 
		retcode += "\0\0\0\0\0\0\0\0\0\0\0\0";
		this.retcode = retcode.substring(0, a);
	}

	/**
	 * telno的get方法
	 * @return  telno telno字段
	 */
	public String getTelno() {
		return getValue(telno);
	}
	/**
	 * ttyp的get方法
	 * @return  ttyp ttyp字段
	 */
	public String getTtyp() {
		return getValue(ttyp);
	}
	/**
	 * devid的get方法
	 * @return  devid devid字段
	 */
	public String getDevid() {
		return getValue(devid);
	}
	/**
	 * ogcd的get方法
	 * @return  ogcd ogcd字段
	 */
	public String getOgcd() {
		return getValue(ogcd);
	}
	/**
	 * messageno的get方法
	 * @return  messageno messageno字段
	 */
	public String getMessageno() {
		return getValue(messageno);
	}
	/**
	 * retcode的get方法
	 * @return  retcode retcode字段
	 */

	public String getRetcode() {
		return getValue(retcode);
	}

	// ------------------------------------------------------------------------------
	/**
	 * 将  p_abyData从byte数组 转换成char数组
	 * @param p_abyData  p_abyData 数组
	 * @return char[]数组
	 */
	public static final char[] bytesToChars(byte[] p_abyData) {
		return bytesToChars(p_abyData, p_abyData.length);
	}


	/**
	 * 对 byte 数组p_abyData的进行转化成char数组
	 * @param p_abyData byte[]p_abyData
	 * @param p_iLength  转化指定规则
	 * @return  char[]数组
	 */
	protected static final char[] bytesToChars(byte[] p_abyData, int p_iLength) {
		char[] l_acMsgChars = new char[p_iLength];
		final int a = 256;
		for (int j = 0; j < p_iLength; j++) {
			if (p_abyData[j] < 0) {
				l_acMsgChars[j] = (char) (a + p_abyData[j]);
			} else {
				l_acMsgChars[j] = (char) p_abyData[j];
			}
		}
		return l_acMsgChars;
	}


	/**
     * 将 为char[] p_acData转换为byte[]格式的静态方法
     * @param  p_acData char[]的p_acData
     * @return byte[]
     */
	public static byte[] charsToBytes(char[] p_acData) {
		return charsToBytes(p_acData, p_acData.length);
	}

	// ------------------------------------------------------------------------------
	/**
	 * 对 byte 数组p_abyData的进行转化成char数组
	 * @param p_acData byte[]p_acData
	 * @param p_iLength  转化指定规则
	 * @return  char[]数组
	 */
	protected static byte[] charsToBytes(char[] p_acData, int p_iLength) {
		byte[] l_abyMsgBytes = new byte[p_iLength];
		for (int j = 0; j < p_iLength; j++) {
			l_abyMsgBytes[j] = (byte) p_acData[j];
		}
		return l_abyMsgBytes;
	}

	// --------------------------------------------------------------------------------
	/**
	 * 对str进行标准格式处理
	 * @param str 传进来的字段
	 * @return str 输出字段
	 */
	protected String getValue(String str) {
		int i;
		char[] s = str.toCharArray();
		for (i = 0; i < s.length; i++) {
			if (s[i] == '\0') {
				break;
			}
		}
		if (i == 0) {
			str = "";
		} else {
			s = ArrayUtils.subarray(s, 0, i);
			str = String.valueOf(s);
		}
		return str;
	}
	/**
	 * 根据特定的个数生成str
	 * @param i 个数
	 * @return String   
	 */
	protected String getBlank(int i) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < i; j++) {
			sb.append("\0");
		}
		return sb.toString();
	}

}