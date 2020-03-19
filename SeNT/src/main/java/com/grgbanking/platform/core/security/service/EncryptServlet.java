package com.grgbanking.platform.core.security.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grgbanking.sent.utils.ResultBMP;

public class EncryptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Algorithm = "DESede"; // 定义 加密算法,可用
	// DES,DESede,Blowfish
	private static final String AlgorithmInstance = "DESede/ECB/NoPadding";
	private static final String KEY = "123456789012345612345678";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncryptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			response.setContentType("text/html;charset=GBK");

			response.setHeader("Content-type", "text/html;charset=UTF-8");// 向浏览器发送一个响应头，设置浏览器的解码方式为UTF-8

			OutputStream stream = response.getOutputStream();
			String encryptText = request.getParameter("encryptText");
			String decryptText = request.getParameter("decryptText");

			if (encryptText != null && encryptText != "") {
				stream.write(byte2HexStr(encryptMode(KEY.getBytes(),string2ByteForNoPadding(encryptText))).getBytes("UTF-8"));
			} else if (decryptText != null && decryptText != "") {
				stream.write(new String(subByteForNoPadding(decryptMode(KEY.getBytes(),hex2byte(decryptText)))).getBytes("UTF-8"));
			} else {
				stream.write("参数输入有误".getBytes("UTF-8"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);// 在单一方面的加密或解密
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// 转换成十六进制字符串
	  public  String byte2HexStr(byte[] b) {

		  String hs = "";
		  String stmp = "";
		  for (int n = 0; n < b.length; n++) {
		  stmp = (Integer.toHexString(b[n] & 0XFF));
		  if (stmp.length() == 1)
		  hs = hs + "0" + stmp;
		  else
		  hs = hs + stmp;
		  }
		  return hs.toUpperCase();

		  }
	  
	  public static byte[] string2ByteForNoPadding(String src) {
		  
		  int mod = src.length()%8;
		  if(mod==0) mod=8;
		  byte[] b = new byte[src.length()+8-mod];
		  
		  byte[] srcBytes  = src.getBytes();
		  for(int i=0;i<b.length;i++){
			  if(i<src.length()){
				  b[i] =  srcBytes[i];  
			  }else{
				  b[i] =(byte)0x00;
			  }
			  
		  }
		  return b;

		}
	  
		public static byte[] subByteForNoPadding(byte[] b) {
			  
			  String hs = "";
			  String stmp = "";
			  
			  int length = 0;
			  for (int n = b.length-1; n>=0; n--) {
				  if(b[n]!=(byte)0x00){
					  length = n+1;  
					  break;
				  }
			  }
			  byte[] t = new byte[length];
			  
			  for (int n = 0; n<length; n++) {
				  t[n] = b[n];
			  }
			  return t;
		}
		
		//16 进制 转 2 进制
		public byte[] hex2byte(String hex) throws IllegalArgumentException {     
		    if (hex.length() % 2 != 0) {     
		        throw new IllegalArgumentException();     
		    }     
		    char[] arr = hex.toCharArray();     
		    byte[] b = new byte[hex.length() / 2];     
		    for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {     
		        String swap = "" + arr[i++] + arr[i];     
		        int byteint = Integer.parseInt(swap, 16) & 0xFF;     
		        b[j] = new Integer(byteint).byteValue();     
		    }     
		    return b;     
		} 

}
