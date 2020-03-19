package com.grgbanking.sent.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
/**
 * 报文管理 service
 */
@Service
public class Transfer{
	/**
	 * 记录日志 
	 */
	private static Logger logger = LoggerFactory.getLogger(Transfer.class);

	@Autowired
	ParamDao paramDao;
	//转换数据字典对应的值
	/**
	 * IP地址
	 */
	public String ip;
	/**
	 * 端口
	 */
	public int port;
	/**
	 * 超时时间
	 */
	public int timeOut ;
	/**
	 * deskey值 
	 */
	public String deskey ;
	/**
	 * deskeyExist值
	 */
	public String deskeyExist;
	
	/**
	 * 创建时带的值
	 */
	public void init()
	{
		ip          = paramDao.getValueByPathWithException(AppConstants.SERVER_IP);
		port        = paramDao.getIntegerValueByPathWithException(AppConstants.SERVER_PORT);
		timeOut     = paramDao.getIntegerValueByPathWithException(AppConstants.TIMEOUT);
		deskey      = paramDao.getValueByPathWithException(AppConstants.DESKEY);
		deskeyExist = paramDao.getValueByPathWithException(AppConstants.DESKEY_EXIST);
		
//	      ip          = "10.1.3.175";
//	      port        = 8151;
//	      timeOut     = 20000;
//	      deskey      = "12345678";
//	      deskeyExist = "n";


	}
	
	//test
	public void initFRequestImg()
	{
		
		ip          = paramDao.getValueByPathWithException(AppConstants.SERVER_IP);
		System.out.println("ip:"+ip);
		port        = paramDao.getIntegerValueByPathWithException(AppConstants.SERVER_PORT);
		System.out.println("port:"+port);
		timeOut     = paramDao.getIntegerValueByPathWithException(AppConstants.TIMEOUTFREQUESTIMG);
		System.out.println("timeOut:"+timeOut);
		deskey      = paramDao.getValueByPathWithException(AppConstants.DESKEY);
		System.out.println("deskey:"+deskey);
		deskeyExist = paramDao.getValueByPathWithException(AppConstants.DESKEY_EXIST);
		System.out.println("deskeyExist:"+deskeyExist);
//			ip="10.1.149.49";
//			port=5602;
//			timeOut=5000;
//			deskey="12345678";
//			deskeyExist="n";
		
	}
	
	public void initByService(ParamDao paramDao)
	{
		ip          = paramDao.getValueByPathWithException(AppConstants.SERVER_IP);
		port        = paramDao.getIntegerValueByPathWithException(AppConstants.SERVER_PORT);
		timeOut     = paramDao.getIntegerValueByPathWithException(AppConstants.TIMEOUT);
		deskey      = paramDao.getValueByPathWithException(AppConstants.DESKEY);
		deskeyExist = paramDao.getValueByPathWithException(AppConstants.DESKEY_EXIST);
		
	/*     ip          = "10.1.3.175";
	     port        = 8151;
	     timeOut     = 2000;
	     deskey      = "12345678";
	     deskeyExist = "n";*/

	}
	
	/**
	 * 发送报文
	 * @param sendpack 发送出去的数据
	 * @return byte[] 
	 * @throws IOException 报文异常
	 */
	public byte[] sendPack(byte[] sendpack) throws IOException {
			
		return this.sendPack3DesSafeContent(sendpack);

	}
	/**
	 * 发送报文
	 * @param sendpack 发送出去的数据
	 * @return byte[] 
	 * @throws IOException 报文异常
	 */

	public byte[] sendPack3DesSafeContent(byte[] sendpack) throws IOException
	{
		final int charlength = 16;
		final int fin8 = 8;
		final int fin4 = 4;
		char tempKey[] = new char[charlength];
		tempKey = vStrToBin(deskey.toCharArray(), deskey.toCharArray().length / 2);
		Des3Safe des3Safe = new Des3Safe();
		char desChar[] = tempKey;
		byte tempsendpack[];
		if( deskeyExist != null && (deskeyExist.equals("y") || deskeyExist.equals("Y")) )
		{
			final int srcLength = 4;
			byte[] sendSrclength = new byte[srcLength];
			char sendpackchar[] = new char[sendpack.length];
			for( int i = 0 ; i < sendpack.length ; i++ )
			{
				sendpackchar[i] = (char) sendpack[i];
			}
			for( int i = 0 ; i < srcLength ; i++ )
			{// 提取交易码，和原始报文长度
				sendSrclength[i] = sendpack[i + srcLength];
			}
			int sendlength = 0;
			sendlength = Integer.parseInt(new String(BaseMessage.bytesToChars(sendSrclength)));
			if( sendlength % fin8 != 0 )
			{
				int templength = sendlength % fin8;
				sendlength = sendlength + fin8 - templength + fin8;
			}
			else
			{
				sendlength = sendlength + fin8;
			}
			tempsendpack = new byte[sendlength];
			char[] desdatesendpack = new char[sendlength];
			for( int i = 0 ; i < sendpack.length ; i++ )
			{
				desdatesendpack[i] = sendpackchar[i];
			}
			int count = 0;
			count = sendlength / fin8;
			for( int jj = 1 ; jj < count ; jj++ )
			{
				char tempSrc[] = new char[fin8];
				char tempRet[] = new char[fin8];
				for( int i = 0 ; i < fin8 ; i++ )
				{
					tempSrc[i] = desdatesendpack[jj * fin8 + i];
				}
				tempRet = des3Safe.v3DES('E', desChar, tempSrc);
				for( int i = 0 ; i < fin8 ; i++ )
				{
					desdatesendpack[jj * fin8 + i] = tempRet[i];
				}
			}
			for( int i = 0 ; i < desdatesendpack.length ; i++ )
			{
				tempsendpack[i] = (byte) desdatesendpack[i];
			}
		}
		else
		{
			tempsendpack = sendpack;
		}
		Socket theSocket = new Socket();
		theSocket.connect(new InetSocketAddress(ip, port), timeOut);
		theSocket.setSoTimeout(timeOut);
		InputStream serverReturn = theSocket.getInputStream();
		OutputStream sendToServer = theSocket.getOutputStream();
		sendToServer.write(tempsendpack);
		sendToServer.flush();
		int length = 0;
		final int returnpackLength = 1024;
		byte[] returnpack = new byte[returnpackLength];
		try
		{
			length = serverReturn.read(returnpack);
		}
		catch( InterruptedIOException eee )
		{// 捕捉超时异常
			closeSock(theSocket, serverReturn, sendToServer);
			return null;
		}
		catch( IOException ee )
		{
			closeSock(theSocket, serverReturn, sendToServer);
			return null;
		}
		final int packleng = 4;
		byte[] packlengths = new byte[packleng];
		try
		{
			returnpack = ArrayUtils.subarray(returnpack, 0, length);
			for( int i = 0 ; i < packleng ; i++ )
			{
				packlengths[i] = returnpack[i + packleng];
			}
		}
		catch( ArrayIndexOutOfBoundsException e )
		{
			closeSock(theSocket, serverReturn, sendToServer);
			return null;
		}
		if( deskeyExist != null && (deskeyExist.equals("y") || deskeyExist.equals("Y")) )
		{ 	// 解密
			int packlength = Integer.parseInt(new String(BaseMessage.bytesToChars(packlengths)));
			int templength = 0;	// 当位数与8不为0时，要补齐8的整数倍。要解密的位数
			if( packlength % fin8 != 0 )
			{
				int temp = packlength % fin8;
				templength = packlength + fin8 - temp + fin8;
			}
			else
			{
				templength = packlength;
			}
			int count = 0;
			count = templength / fin8;
			for( int jj = 1 ; jj < count ; jj++ )
			{
				char tempSrc[] = new char[fin8];
				char tempRet1[] = new char[fin8];
				byte tempRetbyte2[] = new byte[fin8];
				for( int i = 0 ; i < fin8 ; i++ )
				{
					tempSrc[i] = (char) returnpack[jj * fin8 + i];
				}
				tempRet1 = des3Safe.v3DES('D', desChar, tempSrc);
				for( int i = 0 ; i < tempRet1.length ; i++ )
				{
					tempRetbyte2[i] = (byte) tempRet1[i];
				}
				for( int i = 0 ; i < fin8 ; i++ )
				{
					returnpack[jj * fin8 + i] = tempRetbyte2[fin8];
				}
			}
		}
		try
		{
			if( (BaseMessage.bytesToChars(returnpack)).length > fin8 )
			{
				length = Integer.parseInt(new String(BaseMessage.bytesToChars(returnpack)).substring(fin4, fin8)) + fin8;
				if( returnpack.length >= length )
				{
					byte[] temppack = new byte[length];
					System.arraycopy(returnpack, 0, temppack, 0, (length - 1));
					returnpack = temppack;
				}
			}
			closeSock(theSocket, serverReturn, sendToServer);
			return returnpack;
		}
		catch( NumberFormatException e )
		{
			closeSock(theSocket, serverReturn, sendToServer);
			return returnpack;
		}

	}
	/**
	 * 对报文流进行关闭
	 * @param socker 链接
	 * @param is 接收的数据
	 * @param os 发送出去的 数据
	 */
	public void closeSock(Socket socker,InputStream is ,OutputStream os){
		try {
			os.close();
			is.close();
			socker.close();
			
		} catch (IOException e) {
		logger.error("",e);
		}
		
	}
	/**
	 *	转化
	 *	@param b char 数组
	 *	@return hs string
	 *  
	 */
	public String byte2hex(char[] b) {
		String hs = "";
		String stmp = "";
         final int zhuanhuan =0XFF;
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & zhuanhuan));
			if (stmp.length() == 1){
				hs = hs + "0" + stmp;
			}
			else{
				hs = hs + stmp;}
			if (n < b.length - 1){
				}
		}
		return hs.toUpperCase();
	}
     
	/**
	 * 对c进行转化 
	 * @param c byte类型
	 * @return c char类型 
	 */
	public char atob(byte c) {
		final int ten = 10;
		if ((c >= '0') && (c <= '9')){
			return ((char) (c - '0'));
		}
		if ((c >= 'A') && (c <= 'F')){
			return ((char) (c - 'A' + ten));
		}
		if ((c >= 'a') && (c <= 'f')){
			return ((char) (c - 'a' + ten));
		}

		return (0);
	} // char AtoB(char c)
	/**
	 * @param p_pcSourceStr 数组 
	 * @param p_iBinLen  规定长度
	 * @return char[] char数组
	 */

	public char[] vStrToBin(char p_pcSourceStr[], int p_iBinLen) {
		char p_pcDestBin[] = new char[p_iBinLen];
		int i = 0;
		int j = 0;
		final int sixt =16;
		while (p_iBinLen > 0) {
			if ('\0' == p_pcSourceStr[i]){
				return p_pcDestBin;
			}
			if (p_pcSourceStr[i + 1] == '\0') {
				p_pcDestBin[j] = (char) ((byte) atob((byte) ((byte) (p_pcSourceStr[i]) * sixt)));
				return p_pcDestBin;
			}

			p_pcDestBin[j] = (char) ((byte) atob((byte) p_pcSourceStr[i]) * sixt + (byte) atob((byte) (p_pcSourceStr[i + 1])));
			j++;
			i += 2;
			p_iBinLen--;

		} // while(p_iLen>0)
		return p_pcDestBin;
	}

}