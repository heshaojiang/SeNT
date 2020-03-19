package com.grgbanking.sent.utils;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevBaseMessage {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	 
	    
	    //protected char endSign = '\0';
		protected int type;    //4
		protected int length;   //4
		protected int messageno; // 4
		protected int devidLen;	//2 设备长度
		protected int devid;				//空
		protected int synchType;	//2
        protected int synchInfoLen; //2
        protected int synchInfoStr;		//空
 


		public int getType() {
			return type;
		}


		public void setType(int type) {
			this.type = type;
		}


		public int getLength() {
			return length;
		}


		public void setLength(int length) {
			this.length = length;
		}


		public int getMessageno() {
			return messageno;
		}


		public void setMessageno(int messageno) {
			this.messageno = messageno;
		}


		public int getDevidLen() {
			return devidLen;
		}


		public void setDevidLen(int devidLen) {
			this.devidLen = devidLen;
		}


		public int getDevid() {
			return devid;
		}


		public void setDevid(int devid) {
			this.devid = devid;
		}


		public int getSynchType() {
			return synchType;
		}


		public void setSynchType(int synchType) {
			this.synchType = synchType;
		}


		public int getSynchInfoLen() {
			return synchInfoLen;
		}


		public void setSynchInfoLen(int synchInfoLen) {
			this.synchInfoLen = synchInfoLen;
		}


		public int getSynchInfoStr() {
			return synchInfoStr;
		}


		public void setSynchInfoStr(int synchInfoStr) {
			this.synchInfoStr = synchInfoStr;
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
		
		/**
		 * 整数转为字节数组
		 * @param integer 整数 len 字节数组长度
		 * @return byte[]   
		 */
		protected byte[] integerToBytes(int integer, int len) {
			//   if (integer < 0) { throw new IllegalArgumentException("Can not cast negative to bytes : " + integer); }
			   ByteArrayOutputStream bo = new ByteArrayOutputStream();
			   for (int i = 0; i < len; i ++) {   
			    bo.write(integer);
			    integer = integer >> 8;
			   }
			   return bo.toByteArray();
			}
		
		/**
		 * 字节数组转为整数
		 * @param  bRefArr 字节数组
		 * @return int   
		 */
		protected int bytesToInt(byte[] bRefArr) {
		    int iOutcome = 0;
		    byte bLoop;

		    for (int i = 0; i < bRefArr.length; i++) {
		        bLoop = bRefArr[i];
		        iOutcome += (bLoop & 0xFF) << (8 * i);
		    }
		    return iOutcome;
		}
		
		
		/**
		 * 合并字节数组
		 * @param  srcArrays 字节数组
		 * @return byte[]   
		 */
		protected byte[] bytesMerge(List<byte[]> srcArrays) {

			int len = 0;

			for (byte[] srcArray : srcArrays) {

				len += srcArray.length;

			}

			byte[] destArray = new byte[len];

			int destLen = 0;

			for (byte[] srcArray : srcArrays) {

				System.arraycopy(srcArray, 0, destArray, destLen, srcArray.length);

				destLen += srcArray.length;

			}

			return destArray;

		}

	}