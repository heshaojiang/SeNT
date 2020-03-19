/**
 * 文件名：AESUtil.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author yrliang <br>
 *         高级加密标准算法加密
 */
public class AESUtil {
	private static Logger logger = LoggerFactory.getLogger(AESUtil.class);
	private static byte[] keybytes = { 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x40, 0x41, 0x42, 0x43,
			0x44, 0x45, 0x46 };

	public static void main(String[] args) throws Exception {
		// 对明文进行加密
		String e1 = encrypt("javapt");
		// 对密文进行解密
		String e2 = decrypt(e1);
		// 输出密文=明文
		logger.info(e2 + "=" + e1);

	}

	public static String encrypt(String value) {
		String s = null;
		int mode = Cipher.ENCRYPT_MODE;
		 
			try {
				Cipher cipher = initCipher(mode);
				byte[] outBytes = cipher.doFinal(value.getBytes());
				s = String.valueOf(Hex.encodeHex(outBytes));
				return s;
			} catch (InvalidKeyException e) {
				logger.error("Encrypt error! error String is '" + value + "'", e);
			} catch (NoSuchAlgorithmException e) {
				logger.error("Encrypt error! error String is '" + value + "'", e);
			} catch (NoSuchPaddingException e) {
				logger.error("Encrypt error! error String is '" + value + "'", e);
			} catch (IllegalBlockSizeException e) {
				logger.error("Encrypt error! error String is '" + value + "'", e);
			} catch (BadPaddingException e) {
				logger.error("Encrypt error! error String is '" + value + "'", e);
		}
		return value;
	}

	public static String decrypt(String value) {
		String s = null;
		int mode = Cipher.DECRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);
			byte[] outBytes = cipher
					.doFinal(Hex.decodeHex(value.toCharArray()));
			s = new String(outBytes);
			return s;
		} catch (InvalidKeyException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		} catch (NoSuchPaddingException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		} catch (IllegalBlockSizeException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		} catch (BadPaddingException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		} catch (DecoderException e) {
			logger.error("Decrypt error! Error string is '" + value + "'", e);
		}

		return value;
	}

	private static Cipher initCipher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		Key key = new SecretKeySpec(keybytes, "AES");
		cipher.init(mode, key);
		return cipher;
	}
}
